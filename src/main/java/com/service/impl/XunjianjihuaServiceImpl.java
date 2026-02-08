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


import com.dao.XunjianjihuaDao;
import com.entity.XunjianjihuaEntity;
import com.service.XunjianjihuaService;
import com.entity.vo.XunjianjihuaVO;
import com.entity.view.XunjianjihuaView;

@Service("xunjianjihuaService")
public class XunjianjihuaServiceImpl extends ServiceImpl<XunjianjihuaDao, XunjianjihuaEntity> implements XunjianjihuaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XunjianjihuaEntity> page = this.selectPage(
                new Query<XunjianjihuaEntity>(params).getPage(),
                new EntityWrapper<XunjianjihuaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XunjianjihuaEntity> wrapper) {
		  Page<XunjianjihuaView> page =new Query<XunjianjihuaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XunjianjihuaVO> selectListVO(Wrapper<XunjianjihuaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XunjianjihuaVO selectVO(Wrapper<XunjianjihuaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XunjianjihuaView> selectListView(Wrapper<XunjianjihuaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XunjianjihuaView selectView(Wrapper<XunjianjihuaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
