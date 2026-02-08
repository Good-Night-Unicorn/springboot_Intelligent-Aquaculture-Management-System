package com.entity.view;

import com.entity.ShebeibaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 设备报废
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
@TableName("shebeibaofei")
public class ShebeibaofeiView  extends ShebeibaofeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShebeibaofeiView(){
	}
 
 	public ShebeibaofeiView(ShebeibaofeiEntity shebeibaofeiEntity){
 	try {
			BeanUtils.copyProperties(this, shebeibaofeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
