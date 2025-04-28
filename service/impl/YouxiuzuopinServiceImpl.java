package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YouxiuzuopinDao;
import com.entity.YouxiuzuopinEntity;
import com.service.YouxiuzuopinService;
import com.entity.vo.YouxiuzuopinVO;
import com.entity.view.YouxiuzuopinView;

@Service("youxiuzuopinService")
public class YouxiuzuopinServiceImpl extends ServiceImpl<YouxiuzuopinDao, YouxiuzuopinEntity> implements YouxiuzuopinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YouxiuzuopinEntity> page = this.selectPage(
                new Query<YouxiuzuopinEntity>(params).getPage(),
                new EntityWrapper<YouxiuzuopinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YouxiuzuopinEntity> wrapper) {
		  Page<YouxiuzuopinView> page =new Query<YouxiuzuopinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YouxiuzuopinVO> selectListVO(Wrapper<YouxiuzuopinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YouxiuzuopinVO selectVO(Wrapper<YouxiuzuopinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YouxiuzuopinView> selectListView(Wrapper<YouxiuzuopinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YouxiuzuopinView selectView(Wrapper<YouxiuzuopinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
