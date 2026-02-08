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

import com.entity.YangzhipinzhongEntity;
import com.entity.view.YangzhipinzhongView;

import com.service.YangzhipinzhongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 养殖品种
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 09:14:11
 */
@RestController
@RequestMapping("/yangzhipinzhong")
public class YangzhipinzhongController {
    @Autowired
    private YangzhipinzhongService yangzhipinzhongService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YangzhipinzhongEntity yangzhipinzhong,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YangzhipinzhongEntity> ew = new EntityWrapper<YangzhipinzhongEntity>();


        //查询结果
		PageUtils page = yangzhipinzhongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangzhipinzhong), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YangzhipinzhongEntity yangzhipinzhong, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YangzhipinzhongEntity> ew = new EntityWrapper<YangzhipinzhongEntity>();

        //查询结果
		PageUtils page = yangzhipinzhongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangzhipinzhong), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YangzhipinzhongEntity yangzhipinzhong){
       	EntityWrapper<YangzhipinzhongEntity> ew = new EntityWrapper<YangzhipinzhongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yangzhipinzhong, "yangzhipinzhong")); 
        return R.ok().put("data", yangzhipinzhongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YangzhipinzhongEntity yangzhipinzhong){
        EntityWrapper< YangzhipinzhongEntity> ew = new EntityWrapper< YangzhipinzhongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yangzhipinzhong, "yangzhipinzhong")); 
		YangzhipinzhongView yangzhipinzhongView =  yangzhipinzhongService.selectView(ew);
		return R.ok("查询养殖品种成功").put("data", yangzhipinzhongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YangzhipinzhongEntity yangzhipinzhong = yangzhipinzhongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yangzhipinzhong,deSens);
        return R.ok().put("data", yangzhipinzhong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YangzhipinzhongEntity yangzhipinzhong = yangzhipinzhongService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yangzhipinzhong,deSens);
        return R.ok().put("data", yangzhipinzhong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增养殖品种") 
    public R save(@RequestBody YangzhipinzhongEntity yangzhipinzhong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yangzhipinzhong);
        yangzhipinzhongService.insert(yangzhipinzhong);
        return R.ok().put("data",yangzhipinzhong.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增养殖品种")
    @RequestMapping("/add")
    public R add(@RequestBody YangzhipinzhongEntity yangzhipinzhong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yangzhipinzhong);
        yangzhipinzhongService.insert(yangzhipinzhong);
        return R.ok().put("data",yangzhipinzhong.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改养殖品种")
    public R update(@RequestBody YangzhipinzhongEntity yangzhipinzhong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yangzhipinzhong);
        //全部更新
        yangzhipinzhongService.updateById(yangzhipinzhong);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除养殖品种")
    public R delete(@RequestBody Long[] ids){
        yangzhipinzhongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
