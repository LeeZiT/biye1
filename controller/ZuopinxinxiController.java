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

import com.entity.ZuopinxinxiEntity;
import com.entity.view.ZuopinxinxiView;

import com.service.ZuopinxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 作品信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
@RestController
@RequestMapping("/zuopinxinxi")
public class ZuopinxinxiController {
    @Autowired
    private ZuopinxinxiService zuopinxinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuopinxinxiEntity zuopinxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			zuopinxinxi.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			zuopinxinxi.setGonghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ZuopinxinxiEntity> ew = new EntityWrapper<ZuopinxinxiEntity>();


        //查询结果
		PageUtils page = zuopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuopinxinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZuopinxinxiEntity zuopinxinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZuopinxinxiEntity> ew = new EntityWrapper<ZuopinxinxiEntity>();

        //查询结果
		PageUtils page = zuopinxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuopinxinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuopinxinxiEntity zuopinxinxi){
       	EntityWrapper<ZuopinxinxiEntity> ew = new EntityWrapper<ZuopinxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuopinxinxi, "zuopinxinxi")); 
        return R.ok().put("data", zuopinxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuopinxinxiEntity zuopinxinxi){
        EntityWrapper< ZuopinxinxiEntity> ew = new EntityWrapper< ZuopinxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuopinxinxi, "zuopinxinxi")); 
		ZuopinxinxiView zuopinxinxiView =  zuopinxinxiService.selectView(ew);
		return R.ok("查询作品信息成功").put("data", zuopinxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuopinxinxiEntity zuopinxinxi = zuopinxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zuopinxinxi,deSens);
        return R.ok().put("data", zuopinxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuopinxinxiEntity zuopinxinxi = zuopinxinxiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zuopinxinxi,deSens);
        return R.ok().put("data", zuopinxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZuopinxinxiEntity zuopinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuopinxinxi);
        zuopinxinxiService.insert(zuopinxinxi);
        return R.ok().put("data",zuopinxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZuopinxinxiEntity zuopinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuopinxinxi);
        zuopinxinxiService.insert(zuopinxinxi);
        return R.ok().put("data",zuopinxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZuopinxinxiEntity zuopinxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuopinxinxi);
        //全部更新
        zuopinxinxiService.updateById(zuopinxinxi);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ZuopinxinxiEntity> list = new ArrayList<ZuopinxinxiEntity>();
        for(Long id : ids) {
            ZuopinxinxiEntity zuopinxinxi = zuopinxinxiService.selectById(id);
            zuopinxinxi.setSfsh(sfsh);
            zuopinxinxi.setShhf(shhf);
            list.add(zuopinxinxi);
        }
        zuopinxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zuopinxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
