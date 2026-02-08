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
 * 疾病知识
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
@TableName("jibingzhishi")
public class JibingzhishiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JibingzhishiEntity() {
		
	}
	
	public JibingzhishiEntity(T t) {
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
	 * 疾病名称
	 */
					
	private String jibingmingcheng;
	
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
	 * 设置：疾病名称
	 */
	public void setJibingmingcheng(String jibingmingcheng) {
		this.jibingmingcheng = jibingmingcheng;
	}
	/**
	 * 获取：疾病名称
	 */
	public String getJibingmingcheng() {
		return jibingmingcheng;
	}
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
