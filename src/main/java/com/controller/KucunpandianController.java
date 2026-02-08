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

import com.entity.KucunpandianEntity;
import com.entity.view.KucunpandianView;

import com.service.KucunpandianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 库存盘点
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
@RestController
@RequestMapping("/kucunpandian")
public class KucunpandianController {
    @Autowired
    private KucunpandianService kucunpandianService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KucunpandianEntity kucunpandian,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<KucunpandianEntity> ew = new EntityWrapper<KucunpandianEntity>();


        //查询结果
		PageUtils page = kucunpandianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kucunpandian), params), params));
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
    public R list(@RequestParam Map<String, Object> params,KucunpandianEntity kucunpandian, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<KucunpandianEntity> ew = new EntityWrapper<KucunpandianEntity>();

        //查询结果
		PageUtils page = kucunpandianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kucunpandian), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KucunpandianEntity kucunpandian){
       	EntityWrapper<KucunpandianEntity> ew = new EntityWrapper<KucunpandianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kucunpandian, "kucunpandian")); 
        return R.ok().put("data", kucunpandianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KucunpandianEntity kucunpandian){
        EntityWrapper< KucunpandianEntity> ew = new EntityWrapper< KucunpandianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kucunpandian, "kucunpandian")); 
		KucunpandianView kucunpandianView =  kucunpandianService.selectView(ew);
		return R.ok("查询库存盘点成功").put("data", kucunpandianView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KucunpandianEntity kucunpandian = kucunpandianService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(kucunpandian,deSens);
        return R.ok().put("data", kucunpandian);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KucunpandianEntity kucunpandian = kucunpandianService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(kucunpandian,deSens);
        return R.ok().put("data", kucunpandian);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增库存盘点") 
    public R save(@RequestBody KucunpandianEntity kucunpandian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kucunpandian);
        kucunpandianService.insert(kucunpandian);
        return R.ok().put("data",kucunpandian.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增库存盘点")
    @RequestMapping("/add")
    public R add(@RequestBody KucunpandianEntity kucunpandian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kucunpandian);
        kucunpandianService.insert(kucunpandian);
        return R.ok().put("data",kucunpandian.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改库存盘点")
    public R update(@RequestBody KucunpandianEntity kucunpandian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kucunpandian);
        //全部更新
        kucunpandianService.updateById(kucunpandian);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除库存盘点")
    public R delete(@RequestBody Long[] ids){
        kucunpandianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
