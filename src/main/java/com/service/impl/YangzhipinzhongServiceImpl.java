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


import com.dao.YangzhipinzhongDao;
import com.entity.YangzhipinzhongEntity;
import com.service.YangzhipinzhongService;
import com.entity.vo.YangzhipinzhongVO;
import com.entity.view.YangzhipinzhongView;

@Service("yangzhipinzhongService")
public class YangzhipinzhongServiceImpl extends ServiceImpl<YangzhipinzhongDao, YangzhipinzhongEntity> implements YangzhipinzhongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YangzhipinzhongEntity> page = this.selectPage(
                new Query<YangzhipinzhongEntity>(params).getPage(),
                new EntityWrapper<YangzhipinzhongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YangzhipinzhongEntity> wrapper) {
		  Page<YangzhipinzhongView> page =new Query<YangzhipinzhongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YangzhipinzhongVO> selectListVO(Wrapper<YangzhipinzhongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YangzhipinzhongVO selectVO(Wrapper<YangzhipinzhongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YangzhipinzhongView> selectListView(Wrapper<YangzhipinzhongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YangzhipinzhongView selectView(Wrapper<YangzhipinzhongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
