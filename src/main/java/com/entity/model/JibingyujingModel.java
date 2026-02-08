package com.entity.model;

import com.entity.JibingyujingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 疾病预警
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
public class JibingyujingModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 预警时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date yujingshijian;
		
	/**
	 * 水质异常
	 */
	
	private String shuizhiyichang;
		
	/**
	 * 疾病风险
	 */
	
	private String jibingfengxian;
		
	/**
	 * 预防措施
	 */
	
	private String yufangcuoshi;
				
	
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
	 * 设置：预警时间
	 */
	 
	public void setYujingshijian(Date yujingshijian) {
		this.yujingshijian = yujingshijian;
	}
	
	/**
	 * 获取：预警时间
	 */
	public Date getYujingshijian() {
		return yujingshijian;
	}
				
	
	/**
	 * 设置：水质异常
	 */
	 
	public void setShuizhiyichang(String shuizhiyichang) {
		this.shuizhiyichang = shuizhiyichang;
	}
	
	/**
	 * 获取：水质异常
	 */
	public String getShuizhiyichang() {
		return shuizhiyichang;
	}
				
	
	/**
	 * 设置：疾病风险
	 */
	 
	public void setJibingfengxian(String jibingfengxian) {
		this.jibingfengxian = jibingfengxian;
	}
	
	/**
	 * 获取：疾病风险
	 */
	public String getJibingfengxian() {
		return jibingfengxian;
	}
				
	
	/**
	 * 设置：预防措施
	 */
	 
	public void setYufangcuoshi(String yufangcuoshi) {
		this.yufangcuoshi = yufangcuoshi;
	}
	
	/**
	 * 获取：预防措施
	 */
	public String getYufangcuoshi() {
		return yufangcuoshi;
	}
			
}
