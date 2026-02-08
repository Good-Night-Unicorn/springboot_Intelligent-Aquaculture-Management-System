package com.dao;

import com.entity.YangzhipinzhongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YangzhipinzhongVO;
import com.entity.view.YangzhipinzhongView;


/**
 * 养殖品种
 * 
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public interface YangzhipinzhongDao extends BaseMapper<YangzhipinzhongEntity> {
	
	List<YangzhipinzhongVO> selectListVO(@Param("ew") Wrapper<YangzhipinzhongEntity> wrapper);
	
	YangzhipinzhongVO selectVO(@Param("ew") Wrapper<YangzhipinzhongEntity> wrapper);
	
	List<YangzhipinzhongView> selectListView(@Param("ew") Wrapper<YangzhipinzhongEntity> wrapper);

	List<YangzhipinzhongView> selectListView(Pagination page,@Param("ew") Wrapper<YangzhipinzhongEntity> wrapper);

	
	YangzhipinzhongView selectView(@Param("ew") Wrapper<YangzhipinzhongEntity> wrapper);
	

}
