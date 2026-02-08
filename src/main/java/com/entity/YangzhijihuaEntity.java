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
 * 养殖计划
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-04-27 09:14:10
 */
@TableName("yangzhijihua")
public class YangzhijihuaEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YangzhijihuaEntity() {
		
	}
	
	public YangzhijihuaEntity(T t) {
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date toumiaoshijian;
	
	/**
	 * 预计收获时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
