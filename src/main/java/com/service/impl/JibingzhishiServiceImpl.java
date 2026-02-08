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


import com.dao.JibingzhishiDao;
import com.entity.JibingzhishiEntity;
import com.service.JibingzhishiService;
import com.entity.vo.JibingzhishiVO;
import com.entity.view.JibingzhishiView;

@Service("jibingzhishiService")
public class JibingzhishiServiceImpl extends ServiceImpl<JibingzhishiDao, JibingzhishiEntity> implements JibingzhishiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JibingzhishiEntity> page = this.selectPage(
                new Query<JibingzhishiEntity>(params).getPage(),
                new EntityWrapper<JibingzhishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JibingzhishiEntity> wrapper) {
		  Page<JibingzhishiView> page =new Query<JibingzhishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JibingzhishiVO> selectListVO(Wrapper<JibingzhishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JibingzhishiVO selectVO(Wrapper<JibingzhishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JibingzhishiView> selectListView(Wrapper<JibingzhishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JibingzhishiView selectView(Wrapper<JibingzhishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
