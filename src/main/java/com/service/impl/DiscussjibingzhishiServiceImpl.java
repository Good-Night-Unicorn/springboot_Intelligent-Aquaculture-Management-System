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


import com.dao.DiscussjibingzhishiDao;
import com.entity.DiscussjibingzhishiEntity;
import com.service.DiscussjibingzhishiService;
import com.entity.vo.DiscussjibingzhishiVO;
import com.entity.view.DiscussjibingzhishiView;

@Service("discussjibingzhishiService")
public class DiscussjibingzhishiServiceImpl extends ServiceImpl<DiscussjibingzhishiDao, DiscussjibingzhishiEntity> implements DiscussjibingzhishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjibingzhishiEntity> page = this.selectPage(
                new Query<DiscussjibingzhishiEntity>(params).getPage(),
                new EntityWrapper<DiscussjibingzhishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjibingzhishiEntity> wrapper) {
		  Page<DiscussjibingzhishiView> page =new Query<DiscussjibingzhishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussjibingzhishiVO> selectListVO(Wrapper<DiscussjibingzhishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjibingzhishiVO selectVO(Wrapper<DiscussjibingzhishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjibingzhishiView> selectListView(Wrapper<DiscussjibingzhishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjibingzhishiView selectView(Wrapper<DiscussjibingzhishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
