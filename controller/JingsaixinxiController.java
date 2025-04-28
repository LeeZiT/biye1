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

import com.entity.JingsaixinxiEntity;
import com.entity.view.JingsaixinxiView;

import com.service.JingsaixinxiService;
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
 * 竞赛信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-26 08:22:47
 */
@RestController
@RequestMapping("/jingsaixinxi")
public class JingsaixinxiController {
    @Autowired
    private JingsaixinxiService jingsaixinxiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingsaixinxiEntity jingsaixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			jingsaixinxi.setGonghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<JingsaixinxiEntity> ew = new EntityWrapper<JingsaixinxiEntity>();


        //查询结果
		PageUtils page = jingsaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaixinxi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JingsaixinxiEntity jingsaixinxi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JingsaixinxiEntity> ew = new EntityWrapper<JingsaixinxiEntity>();

        //查询结果
		PageUtils page = jingsaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaixinxi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingsaixinxiEntity jingsaixinxi){
       	EntityWrapper<JingsaixinxiEntity> ew = new EntityWrapper<JingsaixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingsaixinxi, "jingsaixinxi")); 
        return R.ok().put("data", jingsaixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingsaixinxiEntity jingsaixinxi){
        EntityWrapper< JingsaixinxiEntity> ew = new EntityWrapper< JingsaixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingsaixinxi, "jingsaixinxi")); 
		JingsaixinxiView jingsaixinxiView =  jingsaixinxiService.selectView(ew);
		return R.ok("查询竞赛信息成功").put("data", jingsaixinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingsaixinxiEntity jingsaixinxi = jingsaixinxiService.selectById(id);
		jingsaixinxi.setClicktime(new Date());
		jingsaixinxiService.updateById(jingsaixinxi);
        jingsaixinxi = jingsaixinxiService.selectView(new EntityWrapper<JingsaixinxiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jingsaixinxi,deSens);
        return R.ok().put("data", jingsaixinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingsaixinxiEntity jingsaixinxi = jingsaixinxiService.selectById(id);
		jingsaixinxi.setClicktime(new Date());
		jingsaixinxiService.updateById(jingsaixinxi);
        jingsaixinxi = jingsaixinxiService.selectView(new EntityWrapper<JingsaixinxiEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jingsaixinxi,deSens);
        return R.ok().put("data", jingsaixinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingsaixinxiEntity jingsaixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingsaixinxi);
        jingsaixinxiService.insert(jingsaixinxi);
        return R.ok().put("data",jingsaixinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingsaixinxiEntity jingsaixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingsaixinxi);
        jingsaixinxiService.insert(jingsaixinxi);
        return R.ok().put("data",jingsaixinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingsaixinxiEntity jingsaixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingsaixinxi);
        //全部更新
        jingsaixinxiService.updateById(jingsaixinxi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingsaixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JingsaixinxiEntity jingsaixinxi, HttpServletRequest request,String pre){
        EntityWrapper<JingsaixinxiEntity> ew = new EntityWrapper<JingsaixinxiEntity>();
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

		PageUtils page = jingsaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaixinxi), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,JingsaixinxiEntity jingsaixinxi, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "jingsaileibie";
        // 查询收藏集合
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "jingsaixinxi").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<JingsaixinxiEntity> jingsaixinxiList = new ArrayList<JingsaixinxiEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            List<String> typeList = new ArrayList<String>();
            for(StoreupEntity s : storeups) {
                if(typeList.contains(s.getInteltype())) continue;
                typeList.add(s.getInteltype());
                jingsaixinxiList.addAll(jingsaixinxiService.selectList(new EntityWrapper<JingsaixinxiEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<JingsaixinxiEntity> ew = new EntityWrapper<JingsaixinxiEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        // 根据协同结果查询结果并返回
        PageUtils page = jingsaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaixinxi), params), params));
        List<JingsaixinxiEntity> pageList = (List<JingsaixinxiEntity>)page.getList();
        if(jingsaixinxiList.size()<limit) {
            int toAddNum = (limit-jingsaixinxiList.size())<=pageList.size()?(limit-jingsaixinxiList.size()):pageList.size();
            for(JingsaixinxiEntity o1 : pageList) {
                boolean addFlag = true;
                for(JingsaixinxiEntity o2 : jingsaixinxiList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    jingsaixinxiList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(jingsaixinxiList.size()>limit) {
            jingsaixinxiList = jingsaixinxiList.subList(0, limit);
        }
        page.setList(jingsaixinxiList);
        return R.ok().put("data", page);
    }





    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,JingsaixinxiEntity jingsaixinxi, HttpServletRequest request){
        String tableName = request.getSession().getAttribute("tableName").toString();
        if(tableName.equals("jiaoshi")) {
            jingsaixinxi.setGonghao((String)request.getSession().getAttribute("username"));
        }
        EntityWrapper<JingsaixinxiEntity> ew = new EntityWrapper<JingsaixinxiEntity>();
        int count = jingsaixinxiService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingsaixinxi), params), params));
        return R.ok().put("data", count);
    }

}
