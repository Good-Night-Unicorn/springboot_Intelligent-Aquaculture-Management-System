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


import com.dao.TouweirizhiDao;
import com.entity.TouweirizhiEntity;
import com.service.TouweirizhiService;
import com.entity.vo.TouweirizhiVO;
import com.entity.view.TouweirizhiView;

@Service("touweirizhiService")
public class TouweirizhiServiceImpl extends ServiceImpl<TouweirizhiDao, TouweirizhiEntity> implements TouweirizhiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TouweirizhiEntity> page = this.selectPage(
                new Query<TouweirizhiEntity>(params).getPage(),
                new EntityWrapper<TouweirizhiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TouweirizhiEntity> wrapper) {
		  Page<TouweirizhiView> page =new Query<TouweirizhiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TouweirizhiVO> selectListVO(Wrapper<TouweirizhiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TouweirizhiVO selectVO(Wrapper<TouweirizhiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TouweirizhiView> selectListView(Wrapper<TouweirizhiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TouweirizhiView selectView(Wrapper<TouweirizhiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<TouweirizhiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<TouweirizhiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<TouweirizhiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
