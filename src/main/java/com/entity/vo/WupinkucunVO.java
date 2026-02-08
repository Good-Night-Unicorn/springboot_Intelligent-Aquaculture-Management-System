package com.entity.vo;

import com.entity.WupinkucunEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 物品库存
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public class WupinkucunVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 物品类型
	 */
	
	private String wupinleixing;
		
	/**
	 * 规格
	 */
	
	private String guige;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 存放位置
	 */
	
	private String cunfangweizhi;
		
	/**
	 * 物品描述
	 */
	
	private String wupinmiaoshu;
		
	/**
	 * 物品图片
	 */
	
	private String wupintupian;
				
	
	/**
	 * 设置：物品类型
	 */
	 
	public void setWupinleixing(String wupinleixing) {
		this.wupinleixing = wupinleixing;
	}
	
	/**
	 * 获取：物品类型
	 */
	public String getWupinleixing() {
		return wupinleixing;
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
	 * 设置：存放位置
	 */
	 
	public void setCunfangweizhi(String cunfangweizhi) {
		this.cunfangweizhi = cunfangweizhi;
	}
	
	/**
	 * 获取：存放位置
	 */
	public String getCunfangweizhi() {
		return cunfangweizhi;
	}
				
	
	/**
	 * 设置：物品描述
	 */
	 
	public void setWupinmiaoshu(String wupinmiaoshu) {
		this.wupinmiaoshu = wupinmiaoshu;
	}
	
	/**
	 * 获取：物品描述
	 */
	public String getWupinmiaoshu() {
		return wupinmiaoshu;
	}
				
	
	/**
	 * 设置：物品图片
	 */
	 
	public void setWupintupian(String wupintupian) {
		this.wupintupian = wupintupian;
	}
	
	/**
	 * 获取：物品图片
	 */
	public String getWupintupian() {
		return wupintupian;
	}
			
}
