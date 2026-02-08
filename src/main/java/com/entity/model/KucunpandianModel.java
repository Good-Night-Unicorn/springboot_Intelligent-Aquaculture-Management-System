package com.entity.model;

import com.entity.KucunpandianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 库存盘点
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
public class KucunpandianModel  implements Serializable {
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
	 * 库存数
	 */
	
	private Integer shuliang;
		
	/**
	 * 盘点数
	 */
	
	private Integer pandianshu;
		
	/**
	 * 物品图片
	 */
	
	private String wupintupian;
		
	/**
	 * 盘点时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date pandianshijian;
		
	/**
	 * 盘点备注
	 */
	
	private String pandianbeizhu;
				
	
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
	 * 设置：库存数
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：库存数
	 */
	public Integer getShuliang() {
		return shuliang;
	}
				
	
	/**
	 * 设置：盘点数
	 */
	 
	public void setPandianshu(Integer pandianshu) {
		this.pandianshu = pandianshu;
	}
	
	/**
	 * 获取：盘点数
	 */
	public Integer getPandianshu() {
		return pandianshu;
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
	 * 设置：盘点时间
	 */
	 
	public void setPandianshijian(Date pandianshijian) {
		this.pandianshijian = pandianshijian;
	}
	
	/**
	 * 获取：盘点时间
	 */
	public Date getPandianshijian() {
		return pandianshijian;
	}
				
	
	/**
	 * 设置：盘点备注
	 */
	 
	public void setPandianbeizhu(String pandianbeizhu) {
		this.pandianbeizhu = pandianbeizhu;
	}
	
	/**
	 * 获取：盘点备注
	 */
	public String getPandianbeizhu() {
		return pandianbeizhu;
	}
			
}
