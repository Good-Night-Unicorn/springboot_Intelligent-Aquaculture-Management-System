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


import com.dao.ShebeicaigouDao;
import com.entity.ShebeicaigouEntity;
import com.service.ShebeicaigouService;
import com.entity.vo.ShebeicaigouVO;
import com.entity.view.ShebeicaigouView;

@Service("shebeicaigouService")
public class ShebeicaigouServiceImpl extends ServiceImpl<ShebeicaigouDao, ShebeicaigouEntity> implements ShebeicaigouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShebeicaigouEntity> page = this.selectPage(
                new Query<ShebeicaigouEntity>(params).getPage(),
                new EntityWrapper<ShebeicaigouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShebeicaigouEntity> wrapper) {
		  Page<ShebeicaigouView> page =new Query<ShebeicaigouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShebeicaigouVO> selectListVO(Wrapper<ShebeicaigouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShebeicaigouVO selectVO(Wrapper<ShebeicaigouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShebeicaigouView> selectListView(Wrapper<ShebeicaigouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShebeicaigouView selectView(Wrapper<ShebeicaigouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
