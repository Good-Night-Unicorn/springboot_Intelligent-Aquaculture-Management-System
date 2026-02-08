package com.entity.model;

import com.entity.YangzhijihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 养殖计划
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-27 09:14:10
 */
public class YangzhijihuaModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 养殖品种
	 */
	
	private String yangzhipinzhong;
		
	/**
	 * 养殖数量
	 */
	
	private Integer yangzhishuliang;
		
	/**
	 * 生长阶段
	 */
	
	private String shengzhangjieduan;
		
	/**
	 * 投苗时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date toumiaoshijian;
		
	/**
	 * 预计收获时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date yujishouhuoshijian;
		
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
	 * 设置：养殖数量
	 */
	 
	public void setYangzhishuliang(Integer yangzhishuliang) {
		this.yangzhishuliang = yangzhishuliang;
	}
	
	/**
	 * 获取：养殖数量
	 */
	public Integer getYangzhishuliang() {
		return yangzhishuliang;
	}
				
	
	/**
	 * 设置：生长阶段
	 */
	 
	public void setShengzhangjieduan(String shengzhangjieduan) {
		this.shengzhangjieduan = shengzhangjieduan;
	}
	
	/**
	 * 获取：生长阶段
	 */
	public String getShengzhangjieduan() {
		return shengzhangjieduan;
	}
				
	
	/**
	 * 设置：投苗时间
	 */
	 
	public void setToumiaoshijian(Date toumiaoshijian) {
		this.toumiaoshijian = toumiaoshijian;
	}
	
	/**
	 * 获取：投苗时间
	 */
	public Date getToumiaoshijian() {
		return toumiaoshijian;
	}
				
	
	/**
	 * 设置：预计收获时间
	 */
	 
	public void setYujishouhuoshijian(Date yujishouhuoshijian) {
		this.yujishouhuoshijian = yujishouhuoshijian;
	}
	
	/**
	 * 获取：预计收获时间
	 */
	public Date getYujishouhuoshijian() {
		return yujishouhuoshijian;
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
