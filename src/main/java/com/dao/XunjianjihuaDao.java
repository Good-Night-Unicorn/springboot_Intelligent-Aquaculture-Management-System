package com.dao;

import com.entity.XunjianjihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XunjianjihuaVO;
import com.entity.view.XunjianjihuaView;


/**
 * 巡检计划
 * 
 * @author 
 * @email 
 * @date 2025-04-27 09:14:13
 */
public interface XunjianjihuaDao extends BaseMapper<XunjianjihuaEntity> {
	
	List<XunjianjihuaVO> selectListVO(@Param("ew") Wrapper<XunjianjihuaEntity> wrapper);
	
	XunjianjihuaVO selectVO(@Param("ew") Wrapper<XunjianjihuaEntity> wrapper);
	
	List<XunjianjihuaView> selectListView(@Param("ew") Wrapper<XunjianjihuaEntity> wrapper);

	List<XunjianjihuaView> selectListView(Pagination page,@Param("ew") Wrapper<XunjianjihuaEntity> wrapper);

	
	XunjianjihuaView selectView(@Param("ew") Wrapper<XunjianjihuaEntity> wrapper);
	

}
