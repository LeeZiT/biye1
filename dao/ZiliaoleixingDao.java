package com.dao;

import com.entity.ZiliaoleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZiliaoleixingVO;
import com.entity.view.ZiliaoleixingView;


/**
 * 资料类型
 * 
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
public interface ZiliaoleixingDao extends BaseMapper<ZiliaoleixingEntity> {
	
	List<ZiliaoleixingVO> selectListVO(@Param("ew") Wrapper<ZiliaoleixingEntity> wrapper);
	
	ZiliaoleixingVO selectVO(@Param("ew") Wrapper<ZiliaoleixingEntity> wrapper);
	
	List<ZiliaoleixingView> selectListView(@Param("ew") Wrapper<ZiliaoleixingEntity> wrapper);

	List<ZiliaoleixingView> selectListView(Pagination page,@Param("ew") Wrapper<ZiliaoleixingEntity> wrapper);

	
	ZiliaoleixingView selectView(@Param("ew") Wrapper<ZiliaoleixingEntity> wrapper);
	

}
