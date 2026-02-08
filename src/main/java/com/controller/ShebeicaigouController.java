package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.annotation.SysLog;

import com.entity.ShebeicaigouEntity;
import com.entity.view.ShebeicaigouView;

import com.service.ShebeicaigouService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 设备采购
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
@RestController
@RequestMapping("/shebeicaigou")
public class ShebeicaigouController {
    @Autowired
    private ShebeicaigouService shebeicaigouService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebeicaigouEntity shebeicaigou,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShebeicaigouEntity> ew = new EntityWrapper<ShebeicaigouEntity>();


        //查询结果
		PageUtils page = shebeicaigouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeicaigou), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShebeicaigouEntity shebeicaigou, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShebeicaigouEntity> ew = new EntityWrapper<ShebeicaigouEntity>();

        //查询结果
		PageUtils page = shebeicaigouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeicaigou), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebeicaigouEntity shebeicaigou){
       	EntityWrapper<ShebeicaigouEntity> ew = new EntityWrapper<ShebeicaigouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebeicaigou, "shebeicaigou")); 
        return R.ok().put("data", shebeicaigouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebeicaigouEntity shebeicaigou){
        EntityWrapper< ShebeicaigouEntity> ew = new EntityWrapper< ShebeicaigouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebeicaigou, "shebeicaigou")); 
		ShebeicaigouView shebeicaigouView =  shebeicaigouService.selectView(ew);
		return R.ok("查询设备采购成功").put("data", shebeicaigouView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebeicaigouEntity shebeicaigou = shebeicaigouService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shebeicaigou,deSens);
        return R.ok().put("data", shebeicaigou);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebeicaigouEntity shebeicaigou = shebeicaigouService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shebeicaigou,deSens);
        return R.ok().put("data", shebeicaigou);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增设备采购") 
    public R save(@RequestBody ShebeicaigouEntity shebeicaigou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeicaigou);
        shebeicaigouService.insert(shebeicaigou);
        return R.ok().put("data",shebeicaigou.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增设备采购")
    @RequestMapping("/add")
    public R add(@RequestBody ShebeicaigouEntity shebeicaigou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeicaigou);
        shebeicaigouService.insert(shebeicaigou);
        return R.ok().put("data",shebeicaigou.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改设备采购")
    public R update(@RequestBody ShebeicaigouEntity shebeicaigou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeicaigou);
        //全部更新
        shebeicaigouService.updateById(shebeicaigou);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除设备采购")
    public R delete(@RequestBody Long[] ids){
        shebeicaigouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
