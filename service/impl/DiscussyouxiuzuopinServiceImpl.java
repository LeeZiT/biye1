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


import com.dao.DiscussyouxiuzuopinDao;
import com.entity.DiscussyouxiuzuopinEntity;
import com.service.DiscussyouxiuzuopinService;
import com.entity.vo.DiscussyouxiuzuopinVO;
import com.entity.view.DiscussyouxiuzuopinView;

@Service("discussyouxiuzuopinService")
public class DiscussyouxiuzuopinServiceImpl extends ServiceImpl<DiscussyouxiuzuopinDao, DiscussyouxiuzuopinEntity> implements DiscussyouxiuzuopinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyouxiuzuopinEntity> page = this.selectPage(
                new Query<DiscussyouxiuzuopinEntity>(params).getPage(),
                new EntityWrapper<DiscussyouxiuzuopinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyouxiuzuopinEntity> wrapper) {
		  Page<DiscussyouxiuzuopinView> page =new Query<DiscussyouxiuzuopinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussyouxiuzuopinVO> selectListVO(Wrapper<DiscussyouxiuzuopinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyouxiuzuopinVO selectVO(Wrapper<DiscussyouxiuzuopinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyouxiuzuopinView> selectListView(Wrapper<DiscussyouxiuzuopinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyouxiuzuopinView selectView(Wrapper<DiscussyouxiuzuopinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
