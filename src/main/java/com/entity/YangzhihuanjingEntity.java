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
 * 养殖环境
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-27 09:14:10
 */
@TableName("yangzhihuanjing")
public class YangzhihuanjingEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YangzhihuanjingEntity() {
		
	}
	
	public YangzhihuanjingEntity(T t) {
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
