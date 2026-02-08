package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjibingzhishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjibingzhishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjibingzhishiView;


/**
 * 疾病知识评论表
 *
 * @author 
 * @email 
 * @date 2025-04-27 09:14:14
 */
public interface DiscussjibingzhishiService extends IService<DiscussjibingzhishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjibingzhishiVO> selectListVO(Wrapper<DiscussjibingzhishiEntity> wrapper);
   	
   	DiscussjibingzhishiVO selectVO(@Param("ew") Wrapper<DiscussjibingzhishiEntity> wrapper);
   	
   	List<DiscussjibingzhishiView> selectListView(Wrapper<DiscussjibingzhishiEntity> wrapper);
   	
   	DiscussjibingzhishiView selectView(@Param("ew") Wrapper<DiscussjibingzhishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjibingzhishiEntity> wrapper);

   	

}

