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

import com.entity.DiscussziyuankuEntity;
import com.entity.view.DiscussziyuankuView;

import com.service.DiscussziyuankuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 资源库评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-26 08:22:49
 */
@RestController
@RequestMapping("/discussziyuanku")
public class DiscussziyuankuController {
    @Autowired
    private DiscussziyuankuService discussziyuankuService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussziyuankuEntity discussziyuanku,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussziyuankuEntity> ew = new EntityWrapper<DiscussziyuankuEntity>();


        //查询结果
		PageUtils page = discussziyuankuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussziyuanku), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DiscussziyuankuEntity discussziyuanku, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussziyuankuEntity> ew = new EntityWrapper<DiscussziyuankuEntity>();

        //查询结果
		PageUtils page = discussziyuankuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussziyuanku), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussziyuankuEntity discussziyuanku){
       	EntityWrapper<DiscussziyuankuEntity> ew = new EntityWrapper<DiscussziyuankuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussziyuanku, "discussziyuanku")); 
        return R.ok().put("data", discussziyuankuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussziyuankuEntity discussziyuanku){
        EntityWrapper< DiscussziyuankuEntity> ew = new EntityWrapper< DiscussziyuankuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussziyuanku, "discussziyuanku")); 
		DiscussziyuankuView discussziyuankuView =  discussziyuankuService.selectView(ew);
		return R.ok("查询资源库评论表成功").put("data", discussziyuankuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussziyuankuEntity discussziyuanku = discussziyuankuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussziyuanku,deSens);
        return R.ok().put("data", discussziyuanku);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussziyuankuEntity discussziyuanku = discussziyuankuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussziyuanku,deSens);
        return R.ok().put("data", discussziyuanku);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussziyuankuEntity discussziyuanku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussziyuanku);
        discussziyuankuService.insert(discussziyuanku);
        return R.ok().put("data",discussziyuanku.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussziyuankuEntity discussziyuanku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussziyuanku);
        discussziyuankuService.insert(discussziyuanku);
        return R.ok().put("data",discussziyuanku.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussziyuankuEntity discussziyuanku = discussziyuankuService.selectOne(new EntityWrapper<DiscussziyuankuEntity>().eq("", username));
        return R.ok().put("data", discussziyuanku);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussziyuankuEntity discussziyuanku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussziyuanku);
        //全部更新
        discussziyuankuService.updateById(discussziyuanku);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussziyuankuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussziyuankuEntity discussziyuanku, HttpServletRequest request,String pre){
        EntityWrapper<DiscussziyuankuEntity> ew = new EntityWrapper<DiscussziyuankuEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");

		PageUtils page = discussziyuankuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussziyuanku), params), params));
        return R.ok().put("data", page);
    }








}
