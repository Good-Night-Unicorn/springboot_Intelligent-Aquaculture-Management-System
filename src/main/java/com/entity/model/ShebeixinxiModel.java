package com.entity.model;

import com.entity.ShebeixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 设备信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
public class ShebeixinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 设备类型
	 */
	
	private String shebeileixing;
		
	/**
	 * 规格
	 */
	
	private String guige;
		
	/**
	 * 型号
	 */
	
	private String xinghao;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 设备描述
	 */
	
	private String shebeimiaoshu;
		
	/**
	 * 设备图片
	 */
	
	private String shebeitupian;
				
	
	/**
	 * 设置：设备类型
	 */
	 
	public void setShebeileixing(String shebeileixing) {
		this.shebeileixing = shebeileixing;
	}
	
	/**
	 * 获取：设备类型
	 */
	public String getShebeileixing() {
		return shebeileixing;
	}
				
	
	/**
	 * 设置：规格
	 */
	 
	public void setGuige(String guige) {
		this.guige = guige;
	}
	
	/**
	 * 获取：规格
	 */
	public String getGuige() {
		return guige;
	}
				
	
	/**
	 * 设置：型号
	 */
	 
	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}
	
	/**
	 * 获取：型号
	 */
	public String getXinghao() {
		return xinghao;
	}
				
	
	/**
	 * 设置：数量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
				
	
	/**
	 * 设置：设备描述
	 */
	 
	public void setShebeimiaoshu(String shebeimiaoshu) {
		this.shebeimiaoshu = shebeimiaoshu;
	}
	
	/**
	 * 获取：设备描述
	 */
	public String getShebeimiaoshu() {
		return shebeimiaoshu;
	}
				
	
	/**
	 * 设置：设备图片
	 */
	 
	public void setShebeitupian(String shebeitupian) {
		this.shebeitupian = shebeitupian;
	}
	
	/**
	 * 获取：设备图片
	 */
	public String getShebeitupian() {
		return shebeitupian;
	}
			
}
