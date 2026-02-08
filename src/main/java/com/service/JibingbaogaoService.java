package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JibingbaogaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JibingbaogaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JibingbaogaoView;


/**
 * 疾病报告
 *
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
public interface JibingbaogaoService extends IService<JibingbaogaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JibingbaogaoVO> selectListVO(Wrapper<JibingbaogaoEntity> wrapper);
   	
   	JibingbaogaoVO selectVO(@Param("ew") Wrapper<JibingbaogaoEntity> wrapper);
   	
   	List<JibingbaogaoView> selectListView(Wrapper<JibingbaogaoEntity> wrapper);
   	
   	JibingbaogaoView selectView(@Param("ew") Wrapper<JibingbaogaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JibingbaogaoEntity> wrapper);

   	

}

