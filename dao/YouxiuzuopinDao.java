package com.dao;

import com.entity.YouxiuzuopinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YouxiuzuopinVO;
import com.entity.view.YouxiuzuopinView;


/**
 * 优秀作品
 * 
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
public interface YouxiuzuopinDao extends BaseMapper<YouxiuzuopinEntity> {
	
	List<YouxiuzuopinVO> selectListVO(@Param("ew") Wrapper<YouxiuzuopinEntity> wrapper);
	
	YouxiuzuopinVO selectVO(@Param("ew") Wrapper<YouxiuzuopinEntity> wrapper);
	
	List<YouxiuzuopinView> selectListView(@Param("ew") Wrapper<YouxiuzuopinEntity> wrapper);

	List<YouxiuzuopinView> selectListView(Pagination page,@Param("ew") Wrapper<YouxiuzuopinEntity> wrapper);

	
	YouxiuzuopinView selectView(@Param("ew") Wrapper<YouxiuzuopinEntity> wrapper);
	

}
