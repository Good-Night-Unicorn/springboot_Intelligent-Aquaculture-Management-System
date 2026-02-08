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


import com.dao.DiaobojiluDao;
import com.entity.DiaobojiluEntity;
import com.service.DiaobojiluService;
import com.entity.vo.DiaobojiluVO;
import com.entity.view.DiaobojiluView;

@Service("diaobojiluService")
public class DiaobojiluServiceImpl extends ServiceImpl<DiaobojiluDao, DiaobojiluEntity> implements DiaobojiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiaobojiluEntity> page = this.selectPage(
                new Query<DiaobojiluEntity>(params).getPage(),
                new EntityWrapper<DiaobojiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiaobojiluEntity> wrapper) {
		  Page<DiaobojiluView> page =new Query<DiaobojiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiaobojiluVO> selectListVO(Wrapper<DiaobojiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiaobojiluVO selectVO(Wrapper<DiaobojiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiaobojiluView> selectListView(Wrapper<DiaobojiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiaobojiluView selectView(Wrapper<DiaobojiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
