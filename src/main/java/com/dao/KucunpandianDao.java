package com.dao;

import com.entity.KucunpandianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KucunpandianVO;
import com.entity.view.KucunpandianView;


/**
 * 库存盘点
 * 
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public interface KucunpandianDao extends BaseMapper<KucunpandianEntity> {
	
	List<KucunpandianVO> selectListVO(@Param("ew") Wrapper<KucunpandianEntity> wrapper);
	
	KucunpandianVO selectVO(@Param("ew") Wrapper<KucunpandianEntity> wrapper);
	
	List<KucunpandianView> selectListView(@Param("ew") Wrapper<KucunpandianEntity> wrapper);

	List<KucunpandianView> selectListView(Pagination page,@Param("ew") Wrapper<KucunpandianEntity> wrapper);

	
	KucunpandianView selectView(@Param("ew") Wrapper<KucunpandianEntity> wrapper);
	

}
