package com.dao;

import com.entity.WupinkucunEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WupinkucunVO;
import com.entity.view.WupinkucunView;


/**
 * 物品库存
 * 
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public interface WupinkucunDao extends BaseMapper<WupinkucunEntity> {
	
	List<WupinkucunVO> selectListVO(@Param("ew") Wrapper<WupinkucunEntity> wrapper);
	
	WupinkucunVO selectVO(@Param("ew") Wrapper<WupinkucunEntity> wrapper);
	
	List<WupinkucunView> selectListView(@Param("ew") Wrapper<WupinkucunEntity> wrapper);

	List<WupinkucunView> selectListView(Pagination page,@Param("ew") Wrapper<WupinkucunEntity> wrapper);

	
	WupinkucunView selectView(@Param("ew") Wrapper<WupinkucunEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<WupinkucunEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<WupinkucunEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<WupinkucunEntity> wrapper);



}
