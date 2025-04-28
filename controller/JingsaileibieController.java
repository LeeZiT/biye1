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

import com.entity.JingsaileibieEntity;
import com.entity.view.JingsaileibieView;

import com.service.JingsaileibieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 竞赛类别
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-26 08:22:47
 */
@RestController
@RequestMapping("/jingsaileibie")
public class JingsaileibieController {
    @Autowired
    private JingsaileibieService jingsaileibieService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingsaileibieEntity jingsaileibie,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JingsaileibieEntity> ew = new EntityWrapper<JingsaileibieEntity>();


        //查询结果
		PageUtils page = jingsaileibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaileibie), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JingsaileibieEntity jingsaileibie, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JingsaileibieEntity> ew = new EntityWrapper<JingsaileibieEntity>();

        //查询结果
		PageUtils page = jingsaileibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaileibie), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingsaileibieEntity jingsaileibie){
       	EntityWrapper<JingsaileibieEntity> ew = new EntityWrapper<JingsaileibieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingsaileibie, "jingsaileibie")); 
        return R.ok().put("data", jingsaileibieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingsaileibieEntity jingsaileibie){
        EntityWrapper< JingsaileibieEntity> ew = new EntityWrapper< JingsaileibieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingsaileibie, "jingsaileibie")); 
		JingsaileibieView jingsaileibieView =  jingsaileibieService.selectView(ew);
		return R.ok("查询竞赛类别成功").put("data", jingsaileibieView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingsaileibieEntity jingsaileibie = jingsaileibieService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jingsaileibie,deSens);
        return R.ok().put("data", jingsaileibie);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingsaileibieEntity jingsaileibie = jingsaileibieService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jingsaileibie,deSens);
        return R.ok().put("data", jingsaileibie);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingsaileibieEntity jingsaileibie, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(jingsaileibieService.selectCount(new EntityWrapper<JingsaileibieEntity>().eq("jingsaileibie", jingsaileibie.getJingsaileibie()))>0) {
            return R.error("竞赛类别已存在");
        }
        //ValidatorUtils.validateEntity(jingsaileibie);
        jingsaileibieService.insert(jingsaileibie);
        return R.ok().put("data",jingsaileibie.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingsaileibieEntity jingsaileibie, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(jingsaileibieService.selectCount(new EntityWrapper<JingsaileibieEntity>().eq("jingsaileibie", jingsaileibie.getJingsaileibie()))>0) {
            return R.error("竞赛类别已存在");
        }
        //ValidatorUtils.validateEntity(jingsaileibie);
        jingsaileibieService.insert(jingsaileibie);
        return R.ok().put("data",jingsaileibie.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingsaileibieEntity jingsaileibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingsaileibie);
        //验证字段唯一性，否则返回错误信息
        if(jingsaileibieService.selectCount(new EntityWrapper<JingsaileibieEntity>().ne("id", jingsaileibie.getId()).eq("jingsaileibie", jingsaileibie.getJingsaileibie()))>0) {
            return R.error("竞赛类别已存在");
        }
        //全部更新
        jingsaileibieService.updateById(jingsaileibie);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingsaileibieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
