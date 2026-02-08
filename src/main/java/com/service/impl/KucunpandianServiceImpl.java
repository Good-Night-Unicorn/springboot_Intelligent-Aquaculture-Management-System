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


import com.dao.KucunpandianDao;
import com.entity.KucunpandianEntity;
import com.service.KucunpandianService;
import com.entity.vo.KucunpandianVO;
import com.entity.view.KucunpandianView;

@Service("kucunpandianService")
public class KucunpandianServiceImpl extends ServiceImpl<KucunpandianDao, KucunpandianEntity> implements KucunpandianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KucunpandianEntity> page = this.selectPage(
                new Query<KucunpandianEntity>(params).getPage(),
                new EntityWrapper<KucunpandianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KucunpandianEntity> wrapper) {
		  Page<KucunpandianView> page =new Query<KucunpandianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KucunpandianVO> selectListVO(Wrapper<KucunpandianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KucunpandianVO selectVO(Wrapper<KucunpandianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KucunpandianView> selectListView(Wrapper<KucunpandianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KucunpandianView selectView(Wrapper<KucunpandianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
