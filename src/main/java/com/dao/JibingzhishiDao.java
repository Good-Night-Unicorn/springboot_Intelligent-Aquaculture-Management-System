package com.dao;

import com.entity.JibingzhishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JibingzhishiVO;
import com.entity.view.JibingzhishiView;


/**
 * 疾病知识
 * 
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public interface JibingzhishiDao extends BaseMapper<JibingzhishiEntity> {
	
	List<JibingzhishiVO> selectListVO(@Param("ew") Wrapper<JibingzhishiEntity> wrapper);
	
	JibingzhishiVO selectVO(@Param("ew") Wrapper<JibingzhishiEntity> wrapper);
	
	List<JibingzhishiView> selectListView(@Param("ew") Wrapper<JibingzhishiEntity> wrapper);

	List<JibingzhishiView> selectListView(Pagination page,@Param("ew") Wrapper<JibingzhishiEntity> wrapper);

	
	JibingzhishiView selectView(@Param("ew") Wrapper<JibingzhishiEntity> wrapper);
	

}
