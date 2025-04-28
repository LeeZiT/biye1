package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZiyuankuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZiyuankuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZiyuankuView;


/**
 * 资源库
 *
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
public interface ZiyuankuService extends IService<ZiyuankuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiyuankuVO> selectListVO(Wrapper<ZiyuankuEntity> wrapper);
   	
   	ZiyuankuVO selectVO(@Param("ew") Wrapper<ZiyuankuEntity> wrapper);
   	
   	List<ZiyuankuView> selectListView(Wrapper<ZiyuankuEntity> wrapper);
   	
   	ZiyuankuView selectView(@Param("ew") Wrapper<ZiyuankuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZiyuankuEntity> wrapper);

   	

}

