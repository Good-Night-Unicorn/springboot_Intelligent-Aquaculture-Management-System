package com.dao;

import com.entity.TouweirizhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TouweirizhiVO;
import com.entity.view.TouweirizhiView;


/**
 * 投喂日志
 * 
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public interface TouweirizhiDao extends BaseMapper<TouweirizhiEntity> {
	
	List<TouweirizhiVO> selectListVO(@Param("ew") Wrapper<TouweirizhiEntity> wrapper);
	
	TouweirizhiVO selectVO(@Param("ew") Wrapper<TouweirizhiEntity> wrapper);
	
	List<TouweirizhiView> selectListView(@Param("ew") Wrapper<TouweirizhiEntity> wrapper);

	List<TouweirizhiView> selectListView(Pagination page,@Param("ew") Wrapper<TouweirizhiEntity> wrapper);

	
	TouweirizhiView selectView(@Param("ew") Wrapper<TouweirizhiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TouweirizhiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TouweirizhiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<TouweirizhiEntity> wrapper);



}
