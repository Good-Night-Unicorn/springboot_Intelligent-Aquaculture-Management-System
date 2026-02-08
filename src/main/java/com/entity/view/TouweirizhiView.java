package com.entity.view;

import com.entity.TouweirizhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 投喂日志
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
@TableName("touweirizhi")
public class TouweirizhiView  extends TouweirizhiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TouweirizhiView(){
	}
 
 	public TouweirizhiView(TouweirizhiEntity touweirizhiEntity){
 	try {
			BeanUtils.copyProperties(this, touweirizhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
