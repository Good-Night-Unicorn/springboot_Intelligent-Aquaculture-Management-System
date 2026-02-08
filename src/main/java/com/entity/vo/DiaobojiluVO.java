package com.entity.vo;

import com.entity.DiaobojiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 调拨记录
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public class DiaobojiluVO  implements Serializable {
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
	 * 物品图片
	 */
	
	private String wupintupian;
		
	/**
	 * 调拨地点
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date diaobodidian;
		
	/**
	 * 调拨备注
	 */
	
	private String diaobobeizhu;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
				
	
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
				
	
	/**
	 * 设置：调拨地点
	 */
	 
	public void setDiaobodidian(Date diaobodidian) {
		this.diaobodidian = diaobodidian;
	}
	
	/**
	 * 获取：调拨地点
	 */
	public Date getDiaobodidian() {
		return diaobodidian;
	}
				
	
	/**
	 * 设置：调拨备注
	 */
	 
	public void setDiaobobeizhu(String diaobobeizhu) {
		this.diaobobeizhu = diaobobeizhu;
	}
	
	/**
	 * 获取：调拨备注
	 */
	public String getDiaobobeizhu() {
		return diaobobeizhu;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
			
}
