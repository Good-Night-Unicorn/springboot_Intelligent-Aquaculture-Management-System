package com.dao;

import com.entity.YangzhijihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YangzhijihuaVO;
import com.entity.view.YangzhijihuaView;


/**
 * 养殖计划
 * 
 * @author 
 * @email 
 * @date 2025-04-27 09:14:10
 */
public interface YangzhijihuaDao extends BaseMapper<YangzhijihuaEntity> {
	
	List<YangzhijihuaVO> selectListVO(@Param("ew") Wrapper<YangzhijihuaEntity> wrapper);
	
	YangzhijihuaVO selectVO(@Param("ew") Wrapper<YangzhijihuaEntity> wrapper);
	
	List<YangzhijihuaView> selectListView(@Param("ew") Wrapper<YangzhijihuaEntity> wrapper);

	List<YangzhijihuaView> selectListView(Pagination page,@Param("ew") Wrapper<YangzhijihuaEntity> wrapper);

	
	YangzhijihuaView selectView(@Param("ew") Wrapper<YangzhijihuaEntity> wrapper);
	

}
