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

import com.entity.ZhuanyeEntity;
import com.entity.view.ZhuanyeView;

import com.service.ZhuanyeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 专业
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
@RestController
@RequestMapping("/zhuanye")
public class ZhuanyeController {
    @Autowired
    private ZhuanyeService zhuanyeService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhuanyeEntity zhuanye,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZhuanyeEntity> ew = new EntityWrapper<ZhuanyeEntity>();


        //查询结果
		PageUtils page = zhuanyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuanye), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZhuanyeEntity zhuanye, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZhuanyeEntity> ew = new EntityWrapper<ZhuanyeEntity>();

        //查询结果
		PageUtils page = zhuanyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuanye), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhuanyeEntity zhuanye){
       	EntityWrapper<ZhuanyeEntity> ew = new EntityWrapper<ZhuanyeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhuanye, "zhuanye")); 
        return R.ok().put("data", zhuanyeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhuanyeEntity zhuanye){
        EntityWrapper< ZhuanyeEntity> ew = new EntityWrapper< ZhuanyeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhuanye, "zhuanye")); 
		ZhuanyeView zhuanyeView =  zhuanyeService.selectView(ew);
		return R.ok("查询专业成功").put("data", zhuanyeView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhuanyeEntity zhuanye = zhuanyeService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhuanye,deSens);
        return R.ok().put("data", zhuanye);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhuanyeEntity zhuanye = zhuanyeService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhuanye,deSens);
        return R.ok().put("data", zhuanye);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhuanyeEntity zhuanye, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(zhuanyeService.selectCount(new EntityWrapper<ZhuanyeEntity>().eq("zhuanye", zhuanye.getZhuanye()))>0) {
            return R.error("专业已存在");
        }
        //ValidatorUtils.validateEntity(zhuanye);
        zhuanyeService.insert(zhuanye);
        return R.ok().put("data",zhuanye.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhuanyeEntity zhuanye, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(zhuanyeService.selectCount(new EntityWrapper<ZhuanyeEntity>().eq("zhuanye", zhuanye.getZhuanye()))>0) {
            return R.error("专业已存在");
        }
        //ValidatorUtils.validateEntity(zhuanye);
        zhuanyeService.insert(zhuanye);
        return R.ok().put("data",zhuanye.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhuanyeEntity zhuanye, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhuanye);
        //验证字段唯一性，否则返回错误信息
        if(zhuanyeService.selectCount(new EntityWrapper<ZhuanyeEntity>().ne("id", zhuanye.getId()).eq("zhuanye", zhuanye.getZhuanye()))>0) {
            return R.error("专业已存在");
        }
        //全部更新
        zhuanyeService.updateById(zhuanye);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhuanyeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
