package com.dao;

import com.entity.DiaobojiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiaobojiluVO;
import com.entity.view.DiaobojiluView;


/**
 * 调拨记录
 * 
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public interface DiaobojiluDao extends BaseMapper<DiaobojiluEntity> {
	
	List<DiaobojiluVO> selectListVO(@Param("ew") Wrapper<DiaobojiluEntity> wrapper);
	
	DiaobojiluVO selectVO(@Param("ew") Wrapper<DiaobojiluEntity> wrapper);
	
	List<DiaobojiluView> selectListView(@Param("ew") Wrapper<DiaobojiluEntity> wrapper);

	List<DiaobojiluView> selectListView(Pagination page,@Param("ew") Wrapper<DiaobojiluEntity> wrapper);

	
	DiaobojiluView selectView(@Param("ew") Wrapper<DiaobojiluEntity> wrapper);
	

}
