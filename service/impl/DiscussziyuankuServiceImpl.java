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


import com.dao.DiscussziyuankuDao;
import com.entity.DiscussziyuankuEntity;
import com.service.DiscussziyuankuService;
import com.entity.vo.DiscussziyuankuVO;
import com.entity.view.DiscussziyuankuView;

@Service("discussziyuankuService")
public class DiscussziyuankuServiceImpl extends ServiceImpl<DiscussziyuankuDao, DiscussziyuankuEntity> implements DiscussziyuankuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussziyuankuEntity> page = this.selectPage(
                new Query<DiscussziyuankuEntity>(params).getPage(),
                new EntityWrapper<DiscussziyuankuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussziyuankuEntity> wrapper) {
		  Page<DiscussziyuankuView> page =new Query<DiscussziyuankuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussziyuankuVO> selectListVO(Wrapper<DiscussziyuankuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussziyuankuVO selectVO(Wrapper<DiscussziyuankuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussziyuankuView> selectListView(Wrapper<DiscussziyuankuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussziyuankuView selectView(Wrapper<DiscussziyuankuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
