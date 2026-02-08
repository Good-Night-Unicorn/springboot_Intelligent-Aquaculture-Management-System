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

import com.entity.ShebeibaofeiEntity;
import com.entity.view.ShebeibaofeiView;

import com.service.ShebeibaofeiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 设备报废
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
@RestController
@RequestMapping("/shebeibaofei")
public class ShebeibaofeiController {
    @Autowired
    private ShebeibaofeiService shebeibaofeiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebeibaofeiEntity shebeibaofei,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShebeibaofeiEntity> ew = new EntityWrapper<ShebeibaofeiEntity>();


        //查询结果
		PageUtils page = shebeibaofeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeibaofei), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShebeibaofeiEntity shebeibaofei, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShebeibaofeiEntity> ew = new EntityWrapper<ShebeibaofeiEntity>();

        //查询结果
		PageUtils page = shebeibaofeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeibaofei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebeibaofeiEntity shebeibaofei){
       	EntityWrapper<ShebeibaofeiEntity> ew = new EntityWrapper<ShebeibaofeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebeibaofei, "shebeibaofei")); 
        return R.ok().put("data", shebeibaofeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebeibaofeiEntity shebeibaofei){
        EntityWrapper< ShebeibaofeiEntity> ew = new EntityWrapper< ShebeibaofeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebeibaofei, "shebeibaofei")); 
		ShebeibaofeiView shebeibaofeiView =  shebeibaofeiService.selectView(ew);
		return R.ok("查询设备报废成功").put("data", shebeibaofeiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebeibaofeiEntity shebeibaofei = shebeibaofeiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shebeibaofei,deSens);
        return R.ok().put("data", shebeibaofei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebeibaofeiEntity shebeibaofei = shebeibaofeiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shebeibaofei,deSens);
        return R.ok().put("data", shebeibaofei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增设备报废") 
    public R save(@RequestBody ShebeibaofeiEntity shebeibaofei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeibaofei);
        shebeibaofeiService.insert(shebeibaofei);
        return R.ok().put("data",shebeibaofei.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增设备报废")
    @RequestMapping("/add")
    public R add(@RequestBody ShebeibaofeiEntity shebeibaofei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeibaofei);
        shebeibaofeiService.insert(shebeibaofei);
        return R.ok().put("data",shebeibaofei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改设备报废")
    public R update(@RequestBody ShebeibaofeiEntity shebeibaofei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeibaofei);
        //全部更新
        shebeibaofeiService.updateById(shebeibaofei);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除设备报废")
    public R delete(@RequestBody Long[] ids){
        shebeibaofeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
