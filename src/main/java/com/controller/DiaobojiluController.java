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

import com.entity.DiaobojiluEntity;
import com.entity.view.DiaobojiluView;

import com.service.DiaobojiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 调拨记录
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
@RestController
@RequestMapping("/diaobojilu")
public class DiaobojiluController {
    @Autowired
    private DiaobojiluService diaobojiluService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiaobojiluEntity diaobojilu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			diaobojilu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<DiaobojiluEntity> ew = new EntityWrapper<DiaobojiluEntity>();


        //查询结果
		PageUtils page = diaobojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diaobojilu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DiaobojiluEntity diaobojilu, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiaobojiluEntity> ew = new EntityWrapper<DiaobojiluEntity>();

        //查询结果
		PageUtils page = diaobojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diaobojilu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiaobojiluEntity diaobojilu){
       	EntityWrapper<DiaobojiluEntity> ew = new EntityWrapper<DiaobojiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( diaobojilu, "diaobojilu")); 
        return R.ok().put("data", diaobojiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiaobojiluEntity diaobojilu){
        EntityWrapper< DiaobojiluEntity> ew = new EntityWrapper< DiaobojiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( diaobojilu, "diaobojilu")); 
		DiaobojiluView diaobojiluView =  diaobojiluService.selectView(ew);
		return R.ok("查询调拨记录成功").put("data", diaobojiluView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiaobojiluEntity diaobojilu = diaobojiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(diaobojilu,deSens);
        return R.ok().put("data", diaobojilu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiaobojiluEntity diaobojilu = diaobojiluService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(diaobojilu,deSens);
        return R.ok().put("data", diaobojilu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增调拨记录") 
    public R save(@RequestBody DiaobojiluEntity diaobojilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(diaobojilu);
        diaobojiluService.insert(diaobojilu);
        return R.ok().put("data",diaobojilu.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增调拨记录")
    @RequestMapping("/add")
    public R add(@RequestBody DiaobojiluEntity diaobojilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(diaobojilu);
        diaobojiluService.insert(diaobojilu);
        return R.ok().put("data",diaobojilu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改调拨记录")
    public R update(@RequestBody DiaobojiluEntity diaobojilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(diaobojilu);
        //全部更新
        diaobojiluService.updateById(diaobojilu);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除调拨记录")
    public R delete(@RequestBody Long[] ids){
        diaobojiluService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
