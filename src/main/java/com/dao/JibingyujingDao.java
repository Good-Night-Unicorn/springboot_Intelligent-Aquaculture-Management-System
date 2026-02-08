package com.dao;

import com.entity.JibingyujingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JibingyujingVO;
import com.entity.view.JibingyujingView;


/**
 * 疾病预警
 * 
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
public interface JibingyujingDao extends BaseMapper<JibingyujingEntity> {
	
	List<JibingyujingVO> selectListVO(@Param("ew") Wrapper<JibingyujingEntity> wrapper);
	
	JibingyujingVO selectVO(@Param("ew") Wrapper<JibingyujingEntity> wrapper);
	
	List<JibingyujingView> selectListView(@Param("ew") Wrapper<JibingyujingEntity> wrapper);

	List<JibingyujingView> selectListView(Pagination page,@Param("ew") Wrapper<JibingyujingEntity> wrapper);

	
	JibingyujingView selectView(@Param("ew") Wrapper<JibingyujingEntity> wrapper);
	

}
