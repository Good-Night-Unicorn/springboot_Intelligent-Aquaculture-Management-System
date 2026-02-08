package com.dao;

import com.entity.YangzhihuanjingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YangzhihuanjingVO;
import com.entity.view.YangzhihuanjingView;


/**
 * 养殖环境
 * 
 * @author 
 * @email 
 * @date 2025-04-27 09:14:10
 */
public interface YangzhihuanjingDao extends BaseMapper<YangzhihuanjingEntity> {
	
	List<YangzhihuanjingVO> selectListVO(@Param("ew") Wrapper<YangzhihuanjingEntity> wrapper);
	
	YangzhihuanjingVO selectVO(@Param("ew") Wrapper<YangzhihuanjingEntity> wrapper);
	
	List<YangzhihuanjingView> selectListView(@Param("ew") Wrapper<YangzhihuanjingEntity> wrapper);

	List<YangzhihuanjingView> selectListView(Pagination page,@Param("ew") Wrapper<YangzhihuanjingEntity> wrapper);

	
	YangzhihuanjingView selectView(@Param("ew") Wrapper<YangzhihuanjingEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YangzhihuanjingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YangzhihuanjingEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<YangzhihuanjingEntity> wrapper);



}
