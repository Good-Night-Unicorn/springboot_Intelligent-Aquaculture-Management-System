package com.entity.vo;

import com.entity.XunjianjihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 巡检计划
 * @author 
 * @email 
 * @date 2025-04-27 09:14:13
 */
public class XunjianjihuaVO  implements Serializable {
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
	 * 设备图片
	 */
	
	private String shebeitupian;
		
	/**
	 * 巡检周期
	 */
	
	private String xunjianzhouqi;
		
	/**
	 * 巡检内容
	 */
	
	private String xunjianneirong;
				
	
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
				
	
	/**
	 * 设置：巡检周期
	 */
	 
	public void setXunjianzhouqi(String xunjianzhouqi) {
		this.xunjianzhouqi = xunjianzhouqi;
	}
	
	/**
	 * 获取：巡检周期
	 */
	public String getXunjianzhouqi() {
		return xunjianzhouqi;
	}
				
	
	/**
	 * 设置：巡检内容
	 */
	 
	public void setXunjianneirong(String xunjianneirong) {
		this.xunjianneirong = xunjianneirong;
	}
	
	/**
	 * 获取：巡检内容
	 */
	public String getXunjianneirong() {
		return xunjianneirong;
	}
			
}
