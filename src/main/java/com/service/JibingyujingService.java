package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JibingyujingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JibingyujingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JibingyujingView;


/**
 * 疾病预警
 *
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
public interface JibingyujingService extends IService<JibingyujingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JibingyujingVO> selectListVO(Wrapper<JibingyujingEntity> wrapper);
   	
   	JibingyujingVO selectVO(@Param("ew") Wrapper<JibingyujingEntity> wrapper);
   	
   	List<JibingyujingView> selectListView(Wrapper<JibingyujingEntity> wrapper);
   	
   	JibingyujingView selectView(@Param("ew") Wrapper<JibingyujingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JibingyujingEntity> wrapper);

   	

}

