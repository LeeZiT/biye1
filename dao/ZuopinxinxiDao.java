package com.dao;

import com.entity.ZuopinxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZuopinxinxiVO;
import com.entity.view.ZuopinxinxiView;


/**
 * 作品信息
 * 
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
public interface ZuopinxinxiDao extends BaseMapper<ZuopinxinxiEntity> {
	
	List<ZuopinxinxiVO> selectListVO(@Param("ew") Wrapper<ZuopinxinxiEntity> wrapper);
	
	ZuopinxinxiVO selectVO(@Param("ew") Wrapper<ZuopinxinxiEntity> wrapper);
	
	List<ZuopinxinxiView> selectListView(@Param("ew") Wrapper<ZuopinxinxiEntity> wrapper);

	List<ZuopinxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ZuopinxinxiEntity> wrapper);

	
	ZuopinxinxiView selectView(@Param("ew") Wrapper<ZuopinxinxiEntity> wrapper);
	

}
