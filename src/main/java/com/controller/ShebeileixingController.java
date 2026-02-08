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

import com.entity.ShebeileixingEntity;
import com.entity.view.ShebeileixingView;

import com.service.ShebeileixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 设备类型
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
@RestController
@RequestMapping("/shebeileixing")
public class ShebeileixingController {
    @Autowired
    private ShebeileixingService shebeileixingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebeileixingEntity shebeileixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShebeileixingEntity> ew = new EntityWrapper<ShebeileixingEntity>();


        //查询结果
		PageUtils page = shebeileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeileixing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShebeileixingEntity shebeileixing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShebeileixingEntity> ew = new EntityWrapper<ShebeileixingEntity>();

        //查询结果
		PageUtils page = shebeileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeileixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebeileixingEntity shebeileixing){
       	EntityWrapper<ShebeileixingEntity> ew = new EntityWrapper<ShebeileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebeileixing, "shebeileixing")); 
        return R.ok().put("data", shebeileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebeileixingEntity shebeileixing){
        EntityWrapper< ShebeileixingEntity> ew = new EntityWrapper< ShebeileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebeileixing, "shebeileixing")); 
		ShebeileixingView shebeileixingView =  shebeileixingService.selectView(ew);
		return R.ok("查询设备类型成功").put("data", shebeileixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebeileixingEntity shebeileixing = shebeileixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shebeileixing,deSens);
        return R.ok().put("data", shebeileixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebeileixingEntity shebeileixing = shebeileixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shebeileixing,deSens);
        return R.ok().put("data", shebeileixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增设备类型") 
    public R save(@RequestBody ShebeileixingEntity shebeileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeileixing);
        shebeileixingService.insert(shebeileixing);
        return R.ok().put("data",shebeileixing.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增设备类型")
    @RequestMapping("/add")
    public R add(@RequestBody ShebeileixingEntity shebeileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeileixing);
        shebeileixingService.insert(shebeileixing);
        return R.ok().put("data",shebeileixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改设备类型")
    public R update(@RequestBody ShebeileixingEntity shebeileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeileixing);
        //全部更新
        shebeileixingService.updateById(shebeileixing);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除设备类型")
    public R delete(@RequestBody Long[] ids){
        shebeileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
