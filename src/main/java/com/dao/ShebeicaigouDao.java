package com.dao;

import com.entity.ShebeicaigouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShebeicaigouVO;
import com.entity.view.ShebeicaigouView;


/**
 * 设备采购
 * 
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
public interface ShebeicaigouDao extends BaseMapper<ShebeicaigouEntity> {
	
	List<ShebeicaigouVO> selectListVO(@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);
	
	ShebeicaigouVO selectVO(@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);
	
	List<ShebeicaigouView> selectListView(@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);

	List<ShebeicaigouView> selectListView(Pagination page,@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);

	
	ShebeicaigouView selectView(@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);
	

}
