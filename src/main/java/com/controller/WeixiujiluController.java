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

import com.entity.WeixiujiluEntity;
import com.entity.view.WeixiujiluView;

import com.service.WeixiujiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 维修记录
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
@RestController
@RequestMapping("/weixiujilu")
public class WeixiujiluController {
    @Autowired
    private WeixiujiluService weixiujiluService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiujiluEntity weixiujilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			weixiujilu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<WeixiujiluEntity> ew = new EntityWrapper<WeixiujiluEntity>();


        //查询结果
		PageUtils page = weixiujiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiujilu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,WeixiujiluEntity weixiujilu, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<WeixiujiluEntity> ew = new EntityWrapper<WeixiujiluEntity>();

        //查询结果
		PageUtils page = weixiujiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiujilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiujiluEntity weixiujilu){
       	EntityWrapper<WeixiujiluEntity> ew = new EntityWrapper<WeixiujiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiujilu, "weixiujilu")); 
        return R.ok().put("data", weixiujiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiujiluEntity weixiujilu){
        EntityWrapper< WeixiujiluEntity> ew = new EntityWrapper< WeixiujiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiujilu, "weixiujilu")); 
		WeixiujiluView weixiujiluView =  weixiujiluService.selectView(ew);
		return R.ok("查询维修记录成功").put("data", weixiujiluView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiujiluEntity weixiujilu = weixiujiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(weixiujilu,deSens);
        return R.ok().put("data", weixiujilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiujiluEntity weixiujilu = weixiujiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(weixiujilu,deSens);
        return R.ok().put("data", weixiujilu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增维修记录") 
    public R save(@RequestBody WeixiujiluEntity weixiujilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiujilu);
        weixiujiluService.insert(weixiujilu);
        return R.ok().put("data",weixiujilu.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增维修记录")
    @RequestMapping("/add")
    public R add(@RequestBody WeixiujiluEntity weixiujilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiujilu);
        weixiujiluService.insert(weixiujilu);
        return R.ok().put("data",weixiujilu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改维修记录")
    public R update(@RequestBody WeixiujiluEntity weixiujilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiujilu);
        //全部更新
        weixiujiluService.updateById(weixiujilu);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除维修记录")
    public R delete(@RequestBody Long[] ids){
        weixiujiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
