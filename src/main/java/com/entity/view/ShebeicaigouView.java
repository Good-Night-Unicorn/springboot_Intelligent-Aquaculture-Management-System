package com.entity.view;

import com.entity.ShebeicaigouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 设备采购
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
@TableName("shebeicaigou")
public class ShebeicaigouView  extends ShebeicaigouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShebeicaigouView(){
	}
 
 	public ShebeicaigouView(ShebeicaigouEntity shebeicaigouEntity){
 	try {
			BeanUtils.copyProperties(this, shebeicaigouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
