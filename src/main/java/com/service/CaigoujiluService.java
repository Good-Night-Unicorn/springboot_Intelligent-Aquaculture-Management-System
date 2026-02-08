package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CaigoujiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CaigoujiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CaigoujiluView;


/**
 * 采购记录
 *
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public interface CaigoujiluService extends IService<CaigoujiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaigoujiluVO> selectListVO(Wrapper<CaigoujiluEntity> wrapper);
   	
   	CaigoujiluVO selectVO(@Param("ew") Wrapper<CaigoujiluEntity> wrapper);
   	
   	List<CaigoujiluView> selectListView(Wrapper<CaigoujiluEntity> wrapper);
   	
   	CaigoujiluView selectView(@Param("ew") Wrapper<CaigoujiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaigoujiluEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<CaigoujiluEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<CaigoujiluEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<CaigoujiluEntity> wrapper);



}

