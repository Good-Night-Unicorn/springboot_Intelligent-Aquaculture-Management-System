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

import com.entity.JibingzhishiEntity;
import com.entity.view.JibingzhishiView;

import com.service.JibingzhishiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 疾病知识
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
@RestController
@RequestMapping("/jibingzhishi")
public class JibingzhishiController {
    @Autowired
    private JibingzhishiService jibingzhishiService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JibingzhishiEntity jibingzhishi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JibingzhishiEntity> ew = new EntityWrapper<JibingzhishiEntity>();


        //查询结果
		PageUtils page = jibingzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jibingzhishi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JibingzhishiEntity jibingzhishi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JibingzhishiEntity> ew = new EntityWrapper<JibingzhishiEntity>();

        //查询结果
		PageUtils page = jibingzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jibingzhishi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JibingzhishiEntity jibingzhishi){
       	EntityWrapper<JibingzhishiEntity> ew = new EntityWrapper<JibingzhishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jibingzhishi, "jibingzhishi")); 
        return R.ok().put("data", jibingzhishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JibingzhishiEntity jibingzhishi){
        EntityWrapper< JibingzhishiEntity> ew = new EntityWrapper< JibingzhishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jibingzhishi, "jibingzhishi")); 
		JibingzhishiView jibingzhishiView =  jibingzhishiService.selectView(ew);
		return R.ok("查询疾病知识成功").put("data", jibingzhishiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JibingzhishiEntity jibingzhishi = jibingzhishiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jibingzhishi,deSens);
        return R.ok().put("data", jibingzhishi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JibingzhishiEntity jibingzhishi = jibingzhishiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jibingzhishi,deSens);
        return R.ok().put("data", jibingzhishi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增疾病知识") 
    public R save(@RequestBody JibingzhishiEntity jibingzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jibingzhishi);
        jibingzhishiService.insert(jibingzhishi);
        return R.ok().put("data",jibingzhishi.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增疾病知识")
    @RequestMapping("/add")
    public R add(@RequestBody JibingzhishiEntity jibingzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jibingzhishi);
        jibingzhishiService.insert(jibingzhishi);
        return R.ok().put("data",jibingzhishi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改疾病知识")
    public R update(@RequestBody JibingzhishiEntity jibingzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jibingzhishi);
        //全部更新
        jibingzhishiService.updateById(jibingzhishi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除疾病知识")
    public R delete(@RequestBody Long[] ids){
        jibingzhishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
