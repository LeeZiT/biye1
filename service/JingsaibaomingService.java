package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JingsaibaomingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JingsaibaomingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JingsaibaomingView;


/**
 * 竞赛报名
 *
 * @author 
 * @email 
 * @date 2025-04-26 08:22:47
 */
public interface JingsaibaomingService extends IService<JingsaibaomingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingsaibaomingVO> selectListVO(Wrapper<JingsaibaomingEntity> wrapper);
   	
   	JingsaibaomingVO selectVO(@Param("ew") Wrapper<JingsaibaomingEntity> wrapper);
   	
   	List<JingsaibaomingView> selectListView(Wrapper<JingsaibaomingEntity> wrapper);
   	
   	JingsaibaomingView selectView(@Param("ew") Wrapper<JingsaibaomingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingsaibaomingEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<JingsaibaomingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<JingsaibaomingEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<JingsaibaomingEntity> wrapper);



}

