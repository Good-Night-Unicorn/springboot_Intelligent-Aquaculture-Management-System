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


import com.dao.WupinkucunDao;
import com.entity.WupinkucunEntity;
import com.service.WupinkucunService;
import com.entity.vo.WupinkucunVO;
import com.entity.view.WupinkucunView;

@Service("wupinkucunService")
public class WupinkucunServiceImpl extends ServiceImpl<WupinkucunDao, WupinkucunEntity> implements WupinkucunService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WupinkucunEntity> page = this.selectPage(
                new Query<WupinkucunEntity>(params).getPage(),
                new EntityWrapper<WupinkucunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WupinkucunEntity> wrapper) {
		  Page<WupinkucunView> page =new Query<WupinkucunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<WupinkucunVO> selectListVO(Wrapper<WupinkucunEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WupinkucunVO selectVO(Wrapper<WupinkucunEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WupinkucunView> selectListView(Wrapper<WupinkucunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WupinkucunView selectView(Wrapper<WupinkucunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<WupinkucunEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<WupinkucunEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<WupinkucunEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
