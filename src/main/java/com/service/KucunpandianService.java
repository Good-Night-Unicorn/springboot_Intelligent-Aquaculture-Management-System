package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KucunpandianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KucunpandianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KucunpandianView;


/**
 * 库存盘点
 *
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public interface KucunpandianService extends IService<KucunpandianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KucunpandianVO> selectListVO(Wrapper<KucunpandianEntity> wrapper);
   	
   	KucunpandianVO selectVO(@Param("ew") Wrapper<KucunpandianEntity> wrapper);
   	
   	List<KucunpandianView> selectListView(Wrapper<KucunpandianEntity> wrapper);
   	
   	KucunpandianView selectView(@Param("ew") Wrapper<KucunpandianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KucunpandianEntity> wrapper);

   	

}

