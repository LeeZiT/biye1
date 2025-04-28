package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZiliaoleixingEntity;
import com.entity.view.ZiliaoleixingView;

import com.service.ZiliaoleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 资料类型
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
@RestController
@RequestMapping("/ziliaoleixing")
public class ZiliaoleixingController {
    @Autowired
    private ZiliaoleixingService ziliaoleixingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiliaoleixingEntity ziliaoleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZiliaoleixingEntity> ew = new EntityWrapper<ZiliaoleixingEntity>();


        //查询结果
		PageUtils page = ziliaoleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziliaoleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZiliaoleixingEntity ziliaoleixing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZiliaoleixingEntity> ew = new EntityWrapper<ZiliaoleixingEntity>();

        //查询结果
		PageUtils page = ziliaoleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziliaoleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiliaoleixingEntity ziliaoleixing){
       	EntityWrapper<ZiliaoleixingEntity> ew = new EntityWrapper<ZiliaoleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziliaoleixing, "ziliaoleixing")); 
        return R.ok().put("data", ziliaoleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiliaoleixingEntity ziliaoleixing){
        EntityWrapper< ZiliaoleixingEntity> ew = new EntityWrapper< ZiliaoleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziliaoleixing, "ziliaoleixing")); 
		ZiliaoleixingView ziliaoleixingView =  ziliaoleixingService.selectView(ew);
		return R.ok("查询资料类型成功").put("data", ziliaoleixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiliaoleixingEntity ziliaoleixing = ziliaoleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(ziliaoleixing,deSens);
        return R.ok().put("data", ziliaoleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiliaoleixingEntity ziliaoleixing = ziliaoleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(ziliaoleixing,deSens);
        return R.ok().put("data", ziliaoleixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZiliaoleixingEntity ziliaoleixing, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(ziliaoleixingService.selectCount(new EntityWrapper<ZiliaoleixingEntity>().eq("ziliaoleixing", ziliaoleixing.getZiliaoleixing()))>0) {
            return R.error("资料类型已存在");
        }
        //ValidatorUtils.validateEntity(ziliaoleixing);
        ziliaoleixingService.insert(ziliaoleixing);
        return R.ok().put("data",ziliaoleixing.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZiliaoleixingEntity ziliaoleixing, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(ziliaoleixingService.selectCount(new EntityWrapper<ZiliaoleixingEntity>().eq("ziliaoleixing", ziliaoleixing.getZiliaoleixing()))>0) {
            return R.error("资料类型已存在");
        }
        //ValidatorUtils.validateEntity(ziliaoleixing);
        ziliaoleixingService.insert(ziliaoleixing);
        return R.ok().put("data",ziliaoleixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZiliaoleixingEntity ziliaoleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziliaoleixing);
        //验证字段唯一性，否则返回错误信息
        if(ziliaoleixingService.selectCount(new EntityWrapper<ZiliaoleixingEntity>().ne("id", ziliaoleixing.getId()).eq("ziliaoleixing", ziliaoleixing.getZiliaoleixing()))>0) {
            return R.error("资料类型已存在");
        }
        //全部更新
        ziliaoleixingService.updateById(ziliaoleixing);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ziliaoleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
