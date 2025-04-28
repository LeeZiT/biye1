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


import com.dao.ZiyuankuDao;
import com.entity.ZiyuankuEntity;
import com.service.ZiyuankuService;
import com.entity.vo.ZiyuankuVO;
import com.entity.view.ZiyuankuView;

@Service("ziyuankuService")
public class ZiyuankuServiceImpl extends ServiceImpl<ZiyuankuDao, ZiyuankuEntity> implements ZiyuankuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZiyuankuEntity> page = this.selectPage(
                new Query<ZiyuankuEntity>(params).getPage(),
                new EntityWrapper<ZiyuankuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZiyuankuEntity> wrapper) {
		  Page<ZiyuankuView> page =new Query<ZiyuankuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZiyuankuVO> selectListVO(Wrapper<ZiyuankuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZiyuankuVO selectVO(Wrapper<ZiyuankuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZiyuankuView> selectListView(Wrapper<ZiyuankuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZiyuankuView selectView(Wrapper<ZiyuankuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
