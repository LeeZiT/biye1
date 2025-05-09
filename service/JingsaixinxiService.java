package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JingsaixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JingsaixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JingsaixinxiView;


/**
 * 竞赛信息
 *
 * @author 
 * @email 
 * @date 2025-04-26 08:22:47
 */
public interface JingsaixinxiService extends IService<JingsaixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JingsaixinxiVO> selectListVO(Wrapper<JingsaixinxiEntity> wrapper);
   	
   	JingsaixinxiVO selectVO(@Param("ew") Wrapper<JingsaixinxiEntity> wrapper);
   	
   	List<JingsaixinxiView> selectListView(Wrapper<JingsaixinxiEntity> wrapper);
   	
   	JingsaixinxiView selectView(@Param("ew") Wrapper<JingsaixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JingsaixinxiEntity> wrapper);

   	

}

