package com.dao;

import com.entity.DiscussjibingzhishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjibingzhishiVO;
import com.entity.view.DiscussjibingzhishiView;


/**
 * 疾病知识评论表
 * 
 * @author 
 * @email 
 * @date 2025-04-27 09:14:14
 */
public interface DiscussjibingzhishiDao extends BaseMapper<DiscussjibingzhishiEntity> {
	
	List<DiscussjibingzhishiVO> selectListVO(@Param("ew") Wrapper<DiscussjibingzhishiEntity> wrapper);
	
	DiscussjibingzhishiVO selectVO(@Param("ew") Wrapper<DiscussjibingzhishiEntity> wrapper);
	
	List<DiscussjibingzhishiView> selectListView(@Param("ew") Wrapper<DiscussjibingzhishiEntity> wrapper);

	List<DiscussjibingzhishiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjibingzhishiEntity> wrapper);

	
	DiscussjibingzhishiView selectView(@Param("ew") Wrapper<DiscussjibingzhishiEntity> wrapper);
	

}
