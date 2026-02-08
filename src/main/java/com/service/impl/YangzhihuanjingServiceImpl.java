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


import com.dao.YangzhihuanjingDao;
import com.entity.YangzhihuanjingEntity;
import com.service.YangzhihuanjingService;
import com.entity.vo.YangzhihuanjingVO;
import com.entity.view.YangzhihuanjingView;

@Service("yangzhihuanjingService")
public class YangzhihuanjingServiceImpl extends ServiceImpl<YangzhihuanjingDao, YangzhihuanjingEntity> implements YangzhihuanjingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YangzhihuanjingEntity> page = this.selectPage(
                new Query<YangzhihuanjingEntity>(params).getPage(),
                new EntityWrapper<YangzhihuanjingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YangzhihuanjingEntity> wrapper) {
		  Page<YangzhihuanjingView> page =new Query<YangzhihuanjingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YangzhihuanjingVO> selectListVO(Wrapper<YangzhihuanjingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YangzhihuanjingVO selectVO(Wrapper<YangzhihuanjingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YangzhihuanjingView> selectListView(Wrapper<YangzhihuanjingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YangzhihuanjingView selectView(Wrapper<YangzhihuanjingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<YangzhihuanjingEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<YangzhihuanjingEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<YangzhihuanjingEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
