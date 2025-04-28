package com.dao;

import com.entity.DiscussyouxiuzuopinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussyouxiuzuopinVO;
import com.entity.view.DiscussyouxiuzuopinView;


/**
 * 优秀作品评论表
 * 
 * @author 
 * @email 
 * @date 2025-04-26 08:22:49
 */
public interface DiscussyouxiuzuopinDao extends BaseMapper<DiscussyouxiuzuopinEntity> {
	
	List<DiscussyouxiuzuopinVO> selectListVO(@Param("ew") Wrapper<DiscussyouxiuzuopinEntity> wrapper);
	
	DiscussyouxiuzuopinVO selectVO(@Param("ew") Wrapper<DiscussyouxiuzuopinEntity> wrapper);
	
	List<DiscussyouxiuzuopinView> selectListView(@Param("ew") Wrapper<DiscussyouxiuzuopinEntity> wrapper);

	List<DiscussyouxiuzuopinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussyouxiuzuopinEntity> wrapper);

	
	DiscussyouxiuzuopinView selectView(@Param("ew") Wrapper<DiscussyouxiuzuopinEntity> wrapper);
	

}
