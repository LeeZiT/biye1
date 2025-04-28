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

import com.entity.ZiyuankuEntity;
import com.entity.view.ZiyuankuView;

import com.service.ZiyuankuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 资源库
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
@RestController
@RequestMapping("/ziyuanku")
public class ZiyuankuController {
    @Autowired
    private ZiyuankuService ziyuankuService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiyuankuEntity ziyuanku,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			ziyuanku.setGonghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ZiyuankuEntity> ew = new EntityWrapper<ZiyuankuEntity>();


        //查询结果
		PageUtils page = ziyuankuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanku), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZiyuankuEntity ziyuanku, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZiyuankuEntity> ew = new EntityWrapper<ZiyuankuEntity>();

        //查询结果
		PageUtils page = ziyuankuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanku), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiyuankuEntity ziyuanku){
       	EntityWrapper<ZiyuankuEntity> ew = new EntityWrapper<ZiyuankuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziyuanku, "ziyuanku")); 
        return R.ok().put("data", ziyuankuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiyuankuEntity ziyuanku){
        EntityWrapper< ZiyuankuEntity> ew = new EntityWrapper< ZiyuankuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziyuanku, "ziyuanku")); 
		ZiyuankuView ziyuankuView =  ziyuankuService.selectView(ew);
		return R.ok("查询资源库成功").put("data", ziyuankuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiyuankuEntity ziyuanku = ziyuankuService.selectById(id);
        if(null==ziyuanku.getClicknum()){
            ziyuanku.setClicknum(0);
        }
		ziyuanku.setClicknum(ziyuanku.getClicknum()+1);
		ziyuankuService.updateById(ziyuanku);
        ziyuanku = ziyuankuService.selectView(new EntityWrapper<ZiyuankuEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(ziyuanku,deSens);
        return R.ok().put("data", ziyuanku);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiyuankuEntity ziyuanku = ziyuankuService.selectById(id);
        if(null==ziyuanku.getClicknum()){
            ziyuanku.setClicknum(0);
        }
		ziyuanku.setClicknum(ziyuanku.getClicknum()+1);
		ziyuankuService.updateById(ziyuanku);
        ziyuanku = ziyuankuService.selectView(new EntityWrapper<ZiyuankuEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(ziyuanku,deSens);
        return R.ok().put("data", ziyuanku);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZiyuankuEntity ziyuanku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziyuanku);
        ziyuankuService.insert(ziyuanku);
        return R.ok().put("data",ziyuanku.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZiyuankuEntity ziyuanku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziyuanku);
        ziyuankuService.insert(ziyuanku);
        return R.ok().put("data",ziyuanku.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZiyuankuEntity ziyuanku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziyuanku);
        //全部更新
        ziyuankuService.updateById(ziyuanku);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ziyuankuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
