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


import com.dao.JibingyujingDao;
import com.entity.JibingyujingEntity;
import com.service.JibingyujingService;
import com.entity.vo.JibingyujingVO;
import com.entity.view.JibingyujingView;

@Service("jibingyujingService")
public class JibingyujingServiceImpl extends ServiceImpl<JibingyujingDao, JibingyujingEntity> implements JibingyujingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JibingyujingEntity> page = this.selectPage(
                new Query<JibingyujingEntity>(params).getPage(),
                new EntityWrapper<JibingyujingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JibingyujingEntity> wrapper) {
		  Page<JibingyujingView> page =new Query<JibingyujingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JibingyujingVO> selectListVO(Wrapper<JibingyujingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JibingyujingVO selectVO(Wrapper<JibingyujingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JibingyujingView> selectListView(Wrapper<JibingyujingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JibingyujingView selectView(Wrapper<JibingyujingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
