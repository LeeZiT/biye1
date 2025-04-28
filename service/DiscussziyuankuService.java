package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussziyuankuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussziyuankuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussziyuankuView;


/**
 * 资源库评论表
 *
 * @author 
 * @email 
 * @date 2025-04-26 08:22:49
 */
public interface DiscussziyuankuService extends IService<DiscussziyuankuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussziyuankuVO> selectListVO(Wrapper<DiscussziyuankuEntity> wrapper);
   	
   	DiscussziyuankuVO selectVO(@Param("ew") Wrapper<DiscussziyuankuEntity> wrapper);
   	
   	List<DiscussziyuankuView> selectListView(Wrapper<DiscussziyuankuEntity> wrapper);
   	
   	DiscussziyuankuView selectView(@Param("ew") Wrapper<DiscussziyuankuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussziyuankuEntity> wrapper);

   	

}

