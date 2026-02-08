package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XunjianjihuaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XunjianjihuaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XunjianjihuaView;


/**
 * 巡检计划
 *
 * @author 
 * @email 
 * @date 2025-04-27 09:14:13
 */
public interface XunjianjihuaService extends IService<XunjianjihuaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XunjianjihuaVO> selectListVO(Wrapper<XunjianjihuaEntity> wrapper);
   	
   	XunjianjihuaVO selectVO(@Param("ew") Wrapper<XunjianjihuaEntity> wrapper);
   	
   	List<XunjianjihuaView> selectListView(Wrapper<XunjianjihuaEntity> wrapper);
   	
   	XunjianjihuaView selectView(@Param("ew") Wrapper<XunjianjihuaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XunjianjihuaEntity> wrapper);

   	

}

