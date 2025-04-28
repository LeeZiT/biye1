package com.dao;

import com.entity.ZiyuankuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZiyuankuVO;
import com.entity.view.ZiyuankuView;


/**
 * 资源库
 * 
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
public interface ZiyuankuDao extends BaseMapper<ZiyuankuEntity> {
	
	List<ZiyuankuVO> selectListVO(@Param("ew") Wrapper<ZiyuankuEntity> wrapper);
	
	ZiyuankuVO selectVO(@Param("ew") Wrapper<ZiyuankuEntity> wrapper);
	
	List<ZiyuankuView> selectListView(@Param("ew") Wrapper<ZiyuankuEntity> wrapper);

	List<ZiyuankuView> selectListView(Pagination page,@Param("ew") Wrapper<ZiyuankuEntity> wrapper);

	
	ZiyuankuView selectView(@Param("ew") Wrapper<ZiyuankuEntity> wrapper);
	

}
