package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YangzhipinzhongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YangzhipinzhongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YangzhipinzhongView;


/**
 * 养殖品种
 *
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public interface YangzhipinzhongService extends IService<YangzhipinzhongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YangzhipinzhongVO> selectListVO(Wrapper<YangzhipinzhongEntity> wrapper);
   	
   	YangzhipinzhongVO selectVO(@Param("ew") Wrapper<YangzhipinzhongEntity> wrapper);
   	
   	List<YangzhipinzhongView> selectListView(Wrapper<YangzhipinzhongEntity> wrapper);
   	
   	YangzhipinzhongView selectView(@Param("ew") Wrapper<YangzhipinzhongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YangzhipinzhongEntity> wrapper);

   	

}

