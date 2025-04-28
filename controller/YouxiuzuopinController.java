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

import com.entity.YouxiuzuopinEntity;
import com.entity.view.YouxiuzuopinView;

import com.service.YouxiuzuopinService;
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
 * 优秀作品
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
@RestController
@RequestMapping("/youxiuzuopin")
public class YouxiuzuopinController {
    @Autowired
    private YouxiuzuopinService youxiuzuopinService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YouxiuzuopinEntity youxiuzuopin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			youxiuzuopin.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			youxiuzuopin.setGonghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<YouxiuzuopinEntity> ew = new EntityWrapper<YouxiuzuopinEntity>();


        //查询结果
		PageUtils page = youxiuzuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxiuzuopin), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YouxiuzuopinEntity youxiuzuopin, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YouxiuzuopinEntity> ew = new EntityWrapper<YouxiuzuopinEntity>();

        //查询结果
		PageUtils page = youxiuzuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxiuzuopin), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YouxiuzuopinEntity youxiuzuopin){
       	EntityWrapper<YouxiuzuopinEntity> ew = new EntityWrapper<YouxiuzuopinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( youxiuzuopin, "youxiuzuopin")); 
        return R.ok().put("data", youxiuzuopinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YouxiuzuopinEntity youxiuzuopin){
        EntityWrapper< YouxiuzuopinEntity> ew = new EntityWrapper< YouxiuzuopinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( youxiuzuopin, "youxiuzuopin")); 
		YouxiuzuopinView youxiuzuopinView =  youxiuzuopinService.selectView(ew);
		return R.ok("查询优秀作品成功").put("data", youxiuzuopinView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YouxiuzuopinEntity youxiuzuopin = youxiuzuopinService.selectById(id);
        if(null==youxiuzuopin.getClicknum()){
            youxiuzuopin.setClicknum(0);
        }
		youxiuzuopin.setClicknum(youxiuzuopin.getClicknum()+1);
		youxiuzuopinService.updateById(youxiuzuopin);
        youxiuzuopin = youxiuzuopinService.selectView(new EntityWrapper<YouxiuzuopinEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(youxiuzuopin,deSens);
        return R.ok().put("data", youxiuzuopin);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YouxiuzuopinEntity youxiuzuopin = youxiuzuopinService.selectById(id);
        if(null==youxiuzuopin.getClicknum()){
            youxiuzuopin.setClicknum(0);
        }
		youxiuzuopin.setClicknum(youxiuzuopin.getClicknum()+1);
		youxiuzuopinService.updateById(youxiuzuopin);
        youxiuzuopin = youxiuzuopinService.selectView(new EntityWrapper<YouxiuzuopinEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(youxiuzuopin,deSens);
        return R.ok().put("data", youxiuzuopin);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        YouxiuzuopinEntity youxiuzuopin = youxiuzuopinService.selectById(id);
        if(type.equals("1")) {
        	youxiuzuopin.setThumbsupnum(youxiuzuopin.getThumbsupnum()+1);
        } else {
        	youxiuzuopin.setCrazilynum(youxiuzuopin.getCrazilynum()+1);
        }
        youxiuzuopinService.updateById(youxiuzuopin);
        return R.ok("投票成功");
    }

    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YouxiuzuopinEntity youxiuzuopin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youxiuzuopin);
        youxiuzuopinService.insert(youxiuzuopin);
        return R.ok().put("data",youxiuzuopin.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YouxiuzuopinEntity youxiuzuopin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youxiuzuopin);
        youxiuzuopinService.insert(youxiuzuopin);
        return R.ok().put("data",youxiuzuopin.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YouxiuzuopinEntity youxiuzuopin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youxiuzuopin);
        //全部更新
        youxiuzuopinService.updateById(youxiuzuopin);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youxiuzuopinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
