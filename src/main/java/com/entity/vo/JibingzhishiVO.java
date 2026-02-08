package com.entity.vo;

import com.entity.JibingzhishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 疾病知识
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public class JibingzhishiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 疾病类型
	 */
	
	private String jibingleixing;
		
	/**
	 * 疾病症状
	 */
	
	private String jibingzhengzhuang;
		
	/**
	 * 治疗方案
	 */
	
	private String zhiliaofangan;
		
	/**
	 * 防治建议
	 */
	
	private String fangzhijianyi;
		
	/**
	 * 疾病图片
	 */
	
	private String jibingtupian;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：疾病类型
	 */
	 
	public void setJibingleixing(String jibingleixing) {
		this.jibingleixing = jibingleixing;
	}
	
	/**
	 * 获取：疾病类型
	 */
	public String getJibingleixing() {
		return jibingleixing;
	}
				
	
	/**
	 * 设置：疾病症状
	 */
	 
	public void setJibingzhengzhuang(String jibingzhengzhuang) {
		this.jibingzhengzhuang = jibingzhengzhuang;
	}
	
	/**
	 * 获取：疾病症状
	 */
	public String getJibingzhengzhuang() {
		return jibingzhengzhuang;
	}
				
	
	/**
	 * 设置：治疗方案
	 */
	 
	public void setZhiliaofangan(String zhiliaofangan) {
		this.zhiliaofangan = zhiliaofangan;
	}
	
	/**
	 * 获取：治疗方案
	 */
	public String getZhiliaofangan() {
		return zhiliaofangan;
	}
				
	
	/**
	 * 设置：防治建议
	 */
	 
	public void setFangzhijianyi(String fangzhijianyi) {
		this.fangzhijianyi = fangzhijianyi;
	}
	
	/**
	 * 获取：防治建议
	 */
	public String getFangzhijianyi() {
		return fangzhijianyi;
	}
				
	
	/**
	 * 设置：疾病图片
	 */
	 
	public void setJibingtupian(String jibingtupian) {
		this.jibingtupian = jibingtupian;
	}
	
	/**
	 * 获取：疾病图片
	 */
	public String getJibingtupian() {
		return jibingtupian;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
