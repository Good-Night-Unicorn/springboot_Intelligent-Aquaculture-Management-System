package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WupinkucunEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WupinkucunVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WupinkucunView;


/**
 * 物品库存
 *
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public interface WupinkucunService extends IService<WupinkucunEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WupinkucunVO> selectListVO(Wrapper<WupinkucunEntity> wrapper);
   	
   	WupinkucunVO selectVO(@Param("ew") Wrapper<WupinkucunEntity> wrapper);
   	
   	List<WupinkucunView> selectListView(Wrapper<WupinkucunEntity> wrapper);
   	
   	WupinkucunView selectView(@Param("ew") Wrapper<WupinkucunEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WupinkucunEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<WupinkucunEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<WupinkucunEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<WupinkucunEntity> wrapper);



}

