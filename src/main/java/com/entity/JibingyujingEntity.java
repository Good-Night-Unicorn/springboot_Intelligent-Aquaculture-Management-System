package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 疾病预警
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
@TableName("jibingyujing")
public class JibingyujingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JibingyujingEntity() {
		
	}
	
	public JibingyujingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 养殖区域
	 */
					
	private String yangzhiquyu;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 预警时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：养殖区域
	 */
	public void setYangzhiquyu(String yangzhiquyu) {
		this.yangzhiquyu = yangzhiquyu;
	}
	/**
	 * 获取：养殖区域
	 */
	public String getYangzhiquyu() {
		return yangzhiquyu;
	}
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
