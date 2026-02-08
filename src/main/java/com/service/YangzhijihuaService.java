package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YangzhijihuaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YangzhijihuaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YangzhijihuaView;


/**
 * 养殖计划
 *
 * @author 
 * @email 
 * @date 2025-04-27 09:14:10
 */
public interface YangzhijihuaService extends IService<YangzhijihuaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YangzhijihuaVO> selectListVO(Wrapper<YangzhijihuaEntity> wrapper);
   	
   	YangzhijihuaVO selectVO(@Param("ew") Wrapper<YangzhijihuaEntity> wrapper);
   	
   	List<YangzhijihuaView> selectListView(Wrapper<YangzhijihuaEntity> wrapper);
   	
   	YangzhijihuaView selectView(@Param("ew") Wrapper<YangzhijihuaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YangzhijihuaEntity> wrapper);

   	

}

