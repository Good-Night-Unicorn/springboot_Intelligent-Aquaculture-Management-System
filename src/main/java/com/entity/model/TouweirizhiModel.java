package com.entity.model;

import com.entity.TouweirizhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 投喂日志
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public class TouweirizhiModel  implements Serializable {
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
	 * 投喂量
	 */
	
	private Integer shuliang;
		
	/**
	 * 物品图片
	 */
	
	private String wupintupian;
		
	/**
	 * 投喂时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date touweishijian;
		
	/**
	 * 养殖品种
	 */
	
	private String yangzhipinzhong;
		
	/**
	 * 投喂说明
	 */
	
	private String touweishuoming;
		
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
	 * 设置：投喂量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：投喂量
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
	 * 设置：投喂时间
	 */
	 
	public void setTouweishijian(Date touweishijian) {
		this.touweishijian = touweishijian;
	}
	
	/**
	 * 获取：投喂时间
	 */
	public Date getTouweishijian() {
		return touweishijian;
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
	 * 设置：投喂说明
	 */
	 
	public void setTouweishuoming(String touweishuoming) {
		this.touweishuoming = touweishuoming;
	}
	
	/**
	 * 获取：投喂说明
	 */
	public String getTouweishuoming() {
		return touweishuoming;
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
