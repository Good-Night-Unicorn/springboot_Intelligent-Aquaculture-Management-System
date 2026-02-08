package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JibingzhishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JibingzhishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JibingzhishiView;


/**
 * 疾病知识
 *
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public interface JibingzhishiService extends IService<JibingzhishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JibingzhishiVO> selectListVO(Wrapper<JibingzhishiEntity> wrapper);
   	
   	JibingzhishiVO selectVO(@Param("ew") Wrapper<JibingzhishiEntity> wrapper);
   	
   	List<JibingzhishiView> selectListView(Wrapper<JibingzhishiEntity> wrapper);
   	
   	JibingzhishiView selectView(@Param("ew") Wrapper<JibingzhishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JibingzhishiEntity> wrapper);

   	

}

