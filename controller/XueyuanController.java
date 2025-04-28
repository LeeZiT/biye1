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

import com.entity.XueyuanEntity;
import com.entity.view.XueyuanView;

import com.service.XueyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 学院
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
@RestController
@RequestMapping("/xueyuan")
public class XueyuanController {
    @Autowired
    private XueyuanService xueyuanService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XueyuanEntity xueyuan,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<XueyuanEntity> ew = new EntityWrapper<XueyuanEntity>();


        //查询结果
		PageUtils page = xueyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueyuan), params), params));
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
    public R list(@RequestParam Map<String, Object> params,XueyuanEntity xueyuan, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<XueyuanEntity> ew = new EntityWrapper<XueyuanEntity>();

        //查询结果
		PageUtils page = xueyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xueyuan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XueyuanEntity xueyuan){
       	EntityWrapper<XueyuanEntity> ew = new EntityWrapper<XueyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xueyuan, "xueyuan")); 
        return R.ok().put("data", xueyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XueyuanEntity xueyuan){
        EntityWrapper< XueyuanEntity> ew = new EntityWrapper< XueyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xueyuan, "xueyuan")); 
		XueyuanView xueyuanView =  xueyuanService.selectView(ew);
		return R.ok("查询学院成功").put("data", xueyuanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XueyuanEntity xueyuan = xueyuanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(xueyuan,deSens);
        return R.ok().put("data", xueyuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XueyuanEntity xueyuan = xueyuanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(xueyuan,deSens);
        return R.ok().put("data", xueyuan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XueyuanEntity xueyuan, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(xueyuanService.selectCount(new EntityWrapper<XueyuanEntity>().eq("xueyuan", xueyuan.getXueyuan()))>0) {
            return R.error("学院已存在");
        }
        //ValidatorUtils.validateEntity(xueyuan);
        xueyuanService.insert(xueyuan);
        return R.ok().put("data",xueyuan.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XueyuanEntity xueyuan, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(xueyuanService.selectCount(new EntityWrapper<XueyuanEntity>().eq("xueyuan", xueyuan.getXueyuan()))>0) {
            return R.error("学院已存在");
        }
        //ValidatorUtils.validateEntity(xueyuan);
        xueyuanService.insert(xueyuan);
        return R.ok().put("data",xueyuan.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XueyuanEntity xueyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xueyuan);
        //验证字段唯一性，否则返回错误信息
        if(xueyuanService.selectCount(new EntityWrapper<XueyuanEntity>().ne("id", xueyuan.getId()).eq("xueyuan", xueyuan.getXueyuan()))>0) {
            return R.error("学院已存在");
        }
        //全部更新
        xueyuanService.updateById(xueyuan);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xueyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
