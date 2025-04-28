package com.dao;

import com.entity.DiscussziyuankuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussziyuankuVO;
import com.entity.view.DiscussziyuankuView;


/**
 * 资源库评论表
 * 
 * @author 
 * @email 
 * @date 2025-04-26 08:22:49
 */
public interface DiscussziyuankuDao extends BaseMapper<DiscussziyuankuEntity> {
	
	List<DiscussziyuankuVO> selectListVO(@Param("ew") Wrapper<DiscussziyuankuEntity> wrapper);
	
	DiscussziyuankuVO selectVO(@Param("ew") Wrapper<DiscussziyuankuEntity> wrapper);
	
	List<DiscussziyuankuView> selectListView(@Param("ew") Wrapper<DiscussziyuankuEntity> wrapper);

	List<DiscussziyuankuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussziyuankuEntity> wrapper);

	
	DiscussziyuankuView selectView(@Param("ew") Wrapper<DiscussziyuankuEntity> wrapper);
	

}
