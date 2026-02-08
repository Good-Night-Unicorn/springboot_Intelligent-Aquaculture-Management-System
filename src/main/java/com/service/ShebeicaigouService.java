package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShebeicaigouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShebeicaigouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShebeicaigouView;


/**
 * 设备采购
 *
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
public interface ShebeicaigouService extends IService<ShebeicaigouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShebeicaigouVO> selectListVO(Wrapper<ShebeicaigouEntity> wrapper);
   	
   	ShebeicaigouVO selectVO(@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);
   	
   	List<ShebeicaigouView> selectListView(Wrapper<ShebeicaigouEntity> wrapper);
   	
   	ShebeicaigouView selectView(@Param("ew") Wrapper<ShebeicaigouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShebeicaigouEntity> wrapper);

   	

}

