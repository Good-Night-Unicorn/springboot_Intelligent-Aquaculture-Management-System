package com.entity.vo;

import com.entity.JibingbaogaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 疾病报告
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
public class JibingbaogaoVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 报告时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date baogaoshijian;
		
	/**
	 * 养殖品种
	 */
	
	private String yangzhipinzhong;
		
	/**
	 * 疾病数量
	 */
	
	private Integer jibingshuliang;
		
	/**
	 * 处理情况
	 */
	
	private String chuliqingkuang;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
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
	 * 设置：报告时间
	 */
	 
	public void setBaogaoshijian(Date baogaoshijian) {
		this.baogaoshijian = baogaoshijian;
	}
	
	/**
	 * 获取：报告时间
	 */
	public Date getBaogaoshijian() {
		return baogaoshijian;
	}
				
	
	/**
	 * 设置：养殖品种
	 */
	 
	public void setYangzhipinzhong(String yangzhipinzhong) {
		this.yangzhipinzhong = yangzhipinzhong;
	}
	
	/**
	 * 获取：养殖品种
	 */
	public String getYangzhipinzhong() {
		return yangzhipinzhong;
	}
				
	
	/**
	 * 设置：疾病数量
	 */
	 
	public void setJibingshuliang(Integer jibingshuliang) {
		this.jibingshuliang = jibingshuliang;
	}
	
	/**
	 * 获取：疾病数量
	 */
	public Integer getJibingshuliang() {
		return jibingshuliang;
	}
				
	
	/**
	 * 设置：处理情况
	 */
	 
	public void setChuliqingkuang(String chuliqingkuang) {
		this.chuliqingkuang = chuliqingkuang;
	}
	
	/**
	 * 获取：处理情况
	 */
	public String getChuliqingkuang() {
		return chuliqingkuang;
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
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
