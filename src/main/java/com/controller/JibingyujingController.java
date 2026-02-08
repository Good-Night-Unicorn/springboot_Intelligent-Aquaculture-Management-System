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

import com.entity.JibingyujingEntity;
import com.entity.view.JibingyujingView;

import com.service.JibingyujingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 疾病预警
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
@RestController
@RequestMapping("/jibingyujing")
public class JibingyujingController {
    @Autowired
    private JibingyujingService jibingyujingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JibingyujingEntity jibingyujing,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date yujingshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date yujingshijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JibingyujingEntity> ew = new EntityWrapper<JibingyujingEntity>();
        if(yujingshijianstart!=null) ew.ge("yujingshijian", yujingshijianstart);
        if(yujingshijianend!=null) ew.le("yujingshijian", yujingshijianend);


        //查询结果
		PageUtils page = jibingyujingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jibingyujing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JibingyujingEntity jibingyujing, 
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date yujingshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date yujingshijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JibingyujingEntity> ew = new EntityWrapper<JibingyujingEntity>();
        if(yujingshijianstart!=null) ew.ge("yujingshijian", yujingshijianstart);
        if(yujingshijianend!=null) ew.le("yujingshijian", yujingshijianend);

        //查询结果
		PageUtils page = jibingyujingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jibingyujing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JibingyujingEntity jibingyujing){
       	EntityWrapper<JibingyujingEntity> ew = new EntityWrapper<JibingyujingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jibingyujing, "jibingyujing")); 
        return R.ok().put("data", jibingyujingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JibingyujingEntity jibingyujing){
        EntityWrapper< JibingyujingEntity> ew = new EntityWrapper< JibingyujingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jibingyujing, "jibingyujing")); 
		JibingyujingView jibingyujingView =  jibingyujingService.selectView(ew);
		return R.ok("查询疾病预警成功").put("data", jibingyujingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JibingyujingEntity jibingyujing = jibingyujingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jibingyujing,deSens);
        return R.ok().put("data", jibingyujing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JibingyujingEntity jibingyujing = jibingyujingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jibingyujing,deSens);
        return R.ok().put("data", jibingyujing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增疾病预警") 
    public R save(@RequestBody JibingyujingEntity jibingyujing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jibingyujing);
        jibingyujingService.insert(jibingyujing);
        return R.ok().put("data",jibingyujing.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增疾病预警")
    @RequestMapping("/add")
    public R add(@RequestBody JibingyujingEntity jibingyujing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jibingyujing);
        jibingyujingService.insert(jibingyujing);
        return R.ok().put("data",jibingyujing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改疾病预警")
    public R update(@RequestBody JibingyujingEntity jibingyujing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jibingyujing);
        //全部更新
        jibingyujingService.updateById(jibingyujing);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除疾病预警")
    public R delete(@RequestBody Long[] ids){
        jibingyujingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
