package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussyouxiuzuopinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussyouxiuzuopinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussyouxiuzuopinView;


/**
 * 优秀作品评论表
 *
 * @author 
 * @email 
 * @date 2025-04-26 08:22:49
 */
public interface DiscussyouxiuzuopinService extends IService<DiscussyouxiuzuopinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussyouxiuzuopinVO> selectListVO(Wrapper<DiscussyouxiuzuopinEntity> wrapper);
   	
   	DiscussyouxiuzuopinVO selectVO(@Param("ew") Wrapper<DiscussyouxiuzuopinEntity> wrapper);
   	
   	List<DiscussyouxiuzuopinView> selectListView(Wrapper<DiscussyouxiuzuopinEntity> wrapper);
   	
   	DiscussyouxiuzuopinView selectView(@Param("ew") Wrapper<DiscussyouxiuzuopinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussyouxiuzuopinEntity> wrapper);

   	

}

