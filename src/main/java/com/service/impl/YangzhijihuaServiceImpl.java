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


import com.dao.YangzhijihuaDao;
import com.entity.YangzhijihuaEntity;
import com.service.YangzhijihuaService;
import com.entity.vo.YangzhijihuaVO;
import com.entity.view.YangzhijihuaView;

@Service("yangzhijihuaService")
public class YangzhijihuaServiceImpl extends ServiceImpl<YangzhijihuaDao, YangzhijihuaEntity> implements YangzhijihuaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YangzhijihuaEntity> page = this.selectPage(
                new Query<YangzhijihuaEntity>(params).getPage(),
                new EntityWrapper<YangzhijihuaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YangzhijihuaEntity> wrapper) {
		  Page<YangzhijihuaView> page =new Query<YangzhijihuaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YangzhijihuaVO> selectListVO(Wrapper<YangzhijihuaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YangzhijihuaVO selectVO(Wrapper<YangzhijihuaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YangzhijihuaView> selectListView(Wrapper<YangzhijihuaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YangzhijihuaView selectView(Wrapper<YangzhijihuaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
