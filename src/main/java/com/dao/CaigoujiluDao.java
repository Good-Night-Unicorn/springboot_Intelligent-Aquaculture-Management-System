package com.dao;

import com.entity.CaigoujiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CaigoujiluVO;
import com.entity.view.CaigoujiluView;


/**
 * 采购记录
 * 
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public interface CaigoujiluDao extends BaseMapper<CaigoujiluEntity> {
	
	List<CaigoujiluVO> selectListVO(@Param("ew") Wrapper<CaigoujiluEntity> wrapper);
	
	CaigoujiluVO selectVO(@Param("ew") Wrapper<CaigoujiluEntity> wrapper);
	
	List<CaigoujiluView> selectListView(@Param("ew") Wrapper<CaigoujiluEntity> wrapper);

	List<CaigoujiluView> selectListView(Pagination page,@Param("ew") Wrapper<CaigoujiluEntity> wrapper);

	
	CaigoujiluView selectView(@Param("ew") Wrapper<CaigoujiluEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CaigoujiluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CaigoujiluEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CaigoujiluEntity> wrapper);



}
