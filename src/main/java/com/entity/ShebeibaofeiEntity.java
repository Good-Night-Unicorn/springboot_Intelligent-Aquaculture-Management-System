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
 * 设备报废
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
@TableName("shebeibaofei")
public class ShebeibaofeiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShebeibaofeiEntity() {
		
	}
	
	public ShebeibaofeiEntity(T t) {
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
	 * 设备名称
	 */
					
	private String shebeimingcheng;
	
	/**
	 * 设备类型
	 */
					
	private String shebeileixing;
	
	/**
	 * 规格
	 */
					
	private String guige;
	
	/**
	 * 型号
	 */
					
	private String xinghao;
	
	/**
	 * 数量
	 */
					
	private Integer shuliang;
	
	/**
	 * 设备图片
	 */
					
	private String shebeitupian;
	
	/**
	 * 报废时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date baofeishijian;
	
	/**
	 * 报废原因
	 */
					
	private String baofeiyuanyin;
	
	
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
	 * 设置：设备名称
	 */
	public void setShebeimingcheng(String shebeimingcheng) {
		this.shebeimingcheng = shebeimingcheng;
	}
	/**
	 * 获取：设备名称
	 */
	public String getShebeimingcheng() {
		return shebeimingcheng;
	}
	/**
	 * 设置：设备类型
	 */
	public void setShebeileixing(String shebeileixing) {
		this.shebeileixing = shebeileixing;
	}
	/**
	 * 获取：设备类型
	 */
	public String getShebeileixing() {
		return shebeileixing;
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
	 * 设置：型号
	 */
	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}
	/**
	 * 获取：型号
	 */
	public String getXinghao() {
		return xinghao;
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
	 * 设置：设备图片
	 */
	public void setShebeitupian(String shebeitupian) {
		this.shebeitupian = shebeitupian;
	}
	/**
	 * 获取：设备图片
	 */
	public String getShebeitupian() {
		return shebeitupian;
	}
	/**
	 * 设置：报废时间
	 */
	public void setBaofeishijian(Date baofeishijian) {
		this.baofeishijian = baofeishijian;
	}
	/**
	 * 获取：报废时间
	 */
	public Date getBaofeishijian() {
		return baofeishijian;
	}
	/**
	 * 设置：报废原因
	 */
	public void setBaofeiyuanyin(String baofeiyuanyin) {
		this.baofeiyuanyin = baofeiyuanyin;
	}
	/**
	 * 获取：报废原因
	 */
	public String getBaofeiyuanyin() {
		return baofeiyuanyin;
	}

}
