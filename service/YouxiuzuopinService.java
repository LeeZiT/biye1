package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YouxiuzuopinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YouxiuzuopinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YouxiuzuopinView;


/**
 * 优秀作品
 *
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
public interface YouxiuzuopinService extends IService<YouxiuzuopinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YouxiuzuopinVO> selectListVO(Wrapper<YouxiuzuopinEntity> wrapper);
   	
   	YouxiuzuopinVO selectVO(@Param("ew") Wrapper<YouxiuzuopinEntity> wrapper);
   	
   	List<YouxiuzuopinView> selectListView(Wrapper<YouxiuzuopinEntity> wrapper);
   	
   	YouxiuzuopinView selectView(@Param("ew") Wrapper<YouxiuzuopinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YouxiuzuopinEntity> wrapper);

   	

}

