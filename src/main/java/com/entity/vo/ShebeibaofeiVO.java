package com.entity.vo;

import com.entity.ShebeibaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 设备报废
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
public class ShebeibaofeiVO  implements Serializable {
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
	 * 报废时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date baofeishijian;
		
	/**
	 * 报废原因
	 */
	
	private String baofeiyuanyin;
				
	
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
	 * 设置：报废时间
	 */
	 
	public void setBaofeishijian(Date baofeishijian) {
		this.baofeishijian = baofeishijian;
	}
	
	/**
	 * 获取：报废时间
	 */
	public Date getBaofeishijian() {
		return baofeishijian;
	}
				
	
	/**
	 * 设置：报废原因
	 */
	 
	public void setBaofeiyuanyin(String baofeiyuanyin) {
		this.baofeiyuanyin = baofeiyuanyin;
	}
	
	/**
	 * 获取：报废原因
	 */
	public String getBaofeiyuanyin() {
		return baofeiyuanyin;
	}
			
}
