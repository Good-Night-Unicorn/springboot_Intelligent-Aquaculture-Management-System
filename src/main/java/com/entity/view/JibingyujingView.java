package com.entity.view;

import com.entity.JibingyujingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 疾病预警
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
@TableName("jibingyujing")
public class JibingyujingView  extends JibingyujingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JibingyujingView(){
	}
 
 	public JibingyujingView(JibingyujingEntity jibingyujingEntity){
 	try {
			BeanUtils.copyProperties(this, jibingyujingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
