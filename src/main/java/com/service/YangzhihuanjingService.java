package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YangzhihuanjingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YangzhihuanjingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YangzhihuanjingView;


/**
 * 养殖环境
 *
 * @author 
 * @email 
 * @date 2025-04-27 09:14:10
 */
public interface YangzhihuanjingService extends IService<YangzhihuanjingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YangzhihuanjingVO> selectListVO(Wrapper<YangzhihuanjingEntity> wrapper);
   	
   	YangzhihuanjingVO selectVO(@Param("ew") Wrapper<YangzhihuanjingEntity> wrapper);
   	
   	List<YangzhihuanjingView> selectListView(Wrapper<YangzhihuanjingEntity> wrapper);
   	
   	YangzhihuanjingView selectView(@Param("ew") Wrapper<YangzhihuanjingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YangzhihuanjingEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<YangzhihuanjingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<YangzhihuanjingEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<YangzhihuanjingEntity> wrapper);



}

