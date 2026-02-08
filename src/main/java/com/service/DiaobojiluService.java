package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiaobojiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiaobojiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiaobojiluView;


/**
 * 调拨记录
 *
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public interface DiaobojiluService extends IService<DiaobojiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiaobojiluVO> selectListVO(Wrapper<DiaobojiluEntity> wrapper);
   	
   	DiaobojiluVO selectVO(@Param("ew") Wrapper<DiaobojiluEntity> wrapper);
   	
   	List<DiaobojiluView> selectListView(Wrapper<DiaobojiluEntity> wrapper);
   	
   	DiaobojiluView selectView(@Param("ew") Wrapper<DiaobojiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiaobojiluEntity> wrapper);

   	

}

