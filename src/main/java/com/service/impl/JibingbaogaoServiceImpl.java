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


import com.dao.JibingbaogaoDao;
import com.entity.JibingbaogaoEntity;
import com.service.JibingbaogaoService;
import com.entity.vo.JibingbaogaoVO;
import com.entity.view.JibingbaogaoView;

@Service("jibingbaogaoService")
public class JibingbaogaoServiceImpl extends ServiceImpl<JibingbaogaoDao, JibingbaogaoEntity> implements JibingbaogaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JibingbaogaoEntity> page = this.selectPage(
                new Query<JibingbaogaoEntity>(params).getPage(),
                new EntityWrapper<JibingbaogaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JibingbaogaoEntity> wrapper) {
		  Page<JibingbaogaoView> page =new Query<JibingbaogaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JibingbaogaoVO> selectListVO(Wrapper<JibingbaogaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JibingbaogaoVO selectVO(Wrapper<JibingbaogaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JibingbaogaoView> selectListView(Wrapper<JibingbaogaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JibingbaogaoView selectView(Wrapper<JibingbaogaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
