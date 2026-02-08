package com.entity.vo;

import com.entity.YangzhihuanjingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 养殖环境
 * @author 
 * @email 
 * @date 2025-04-27 09:14:10
 */
public class YangzhihuanjingVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 温度
	 */
	
	private Double wendu;
		
	/**
	 * pH值
	 */
	
	private Double suanjiandu;
		
	/**
	 * 溶解氧
	 */
	
	private Double rongjieyang;
		
	/**
	 * 氨氮
	 */
	
	private Double andan;
		
	/**
	 * 电导率
	 */
	
	private Double diandaolv;
		
	/**
	 * 浊度
	 */
	
	private Double zhuodu;
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：温度
	 */
	 
	public void setWendu(Double wendu) {
		this.wendu = wendu;
	}
	
	/**
	 * 获取：温度
	 */
	public Double getWendu() {
		return wendu;
	}
				
	
	/**
	 * 设置：pH值
	 */
	 
	public void setSuanjiandu(Double suanjiandu) {
		this.suanjiandu = suanjiandu;
	}
	
	/**
	 * 获取：pH值
	 */
	public Double getSuanjiandu() {
		return suanjiandu;
	}
				
	
	/**
	 * 设置：溶解氧
	 */
	 
	public void setRongjieyang(Double rongjieyang) {
		this.rongjieyang = rongjieyang;
	}
	
	/**
	 * 获取：溶解氧
	 */
	public Double getRongjieyang() {
		return rongjieyang;
	}
				
	
	/**
	 * 设置：氨氮
	 */
	 
	public void setAndan(Double andan) {
		this.andan = andan;
	}
	
	/**
	 * 获取：氨氮
	 */
	public Double getAndan() {
		return andan;
	}
				
	
	/**
	 * 设置：电导率
	 */
	 
	public void setDiandaolv(Double diandaolv) {
		this.diandaolv = diandaolv;
	}
	
	/**
	 * 获取：电导率
	 */
	public Double getDiandaolv() {
		return diandaolv;
	}
				
	
	/**
	 * 设置：浊度
	 */
	 
	public void setZhuodu(Double zhuodu) {
		this.zhuodu = zhuodu;
	}
	
	/**
	 * 获取：浊度
	 */
	public Double getZhuodu() {
		return zhuodu;
	}
			
}
