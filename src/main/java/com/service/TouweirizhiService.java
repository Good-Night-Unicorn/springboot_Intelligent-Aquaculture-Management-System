package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TouweirizhiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TouweirizhiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TouweirizhiView;


/**
 * 投喂日志
 *
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public interface TouweirizhiService extends IService<TouweirizhiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TouweirizhiVO> selectListVO(Wrapper<TouweirizhiEntity> wrapper);
   	
   	TouweirizhiVO selectVO(@Param("ew") Wrapper<TouweirizhiEntity> wrapper);
   	
   	List<TouweirizhiView> selectListView(Wrapper<TouweirizhiEntity> wrapper);
   	
   	TouweirizhiView selectView(@Param("ew") Wrapper<TouweirizhiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TouweirizhiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<TouweirizhiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<TouweirizhiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<TouweirizhiEntity> wrapper);



}

