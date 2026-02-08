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

import com.entity.ShebeibaoxiuEntity;
import com.entity.view.ShebeibaoxiuView;

import com.service.ShebeibaoxiuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 设备报修
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
@RestController
@RequestMapping("/shebeibaoxiu")
public class ShebeibaoxiuController {
    @Autowired
    private ShebeibaoxiuService shebeibaoxiuService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShebeibaoxiuEntity shebeibaoxiu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shebeibaoxiu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ShebeibaoxiuEntity> ew = new EntityWrapper<ShebeibaoxiuEntity>();


        //查询结果
		PageUtils page = shebeibaoxiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeibaoxiu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShebeibaoxiuEntity shebeibaoxiu, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShebeibaoxiuEntity> ew = new EntityWrapper<ShebeibaoxiuEntity>();

        //查询结果
		PageUtils page = shebeibaoxiuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shebeibaoxiu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShebeibaoxiuEntity shebeibaoxiu){
       	EntityWrapper<ShebeibaoxiuEntity> ew = new EntityWrapper<ShebeibaoxiuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shebeibaoxiu, "shebeibaoxiu")); 
        return R.ok().put("data", shebeibaoxiuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShebeibaoxiuEntity shebeibaoxiu){
        EntityWrapper< ShebeibaoxiuEntity> ew = new EntityWrapper< ShebeibaoxiuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shebeibaoxiu, "shebeibaoxiu")); 
		ShebeibaoxiuView shebeibaoxiuView =  shebeibaoxiuService.selectView(ew);
		return R.ok("查询设备报修成功").put("data", shebeibaoxiuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShebeibaoxiuEntity shebeibaoxiu = shebeibaoxiuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shebeibaoxiu,deSens);
        return R.ok().put("data", shebeibaoxiu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShebeibaoxiuEntity shebeibaoxiu = shebeibaoxiuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shebeibaoxiu,deSens);
        return R.ok().put("data", shebeibaoxiu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增设备报修") 
    public R save(@RequestBody ShebeibaoxiuEntity shebeibaoxiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeibaoxiu);
        shebeibaoxiuService.insert(shebeibaoxiu);
        return R.ok().put("data",shebeibaoxiu.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增设备报修")
    @RequestMapping("/add")
    public R add(@RequestBody ShebeibaoxiuEntity shebeibaoxiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeibaoxiu);
        shebeibaoxiuService.insert(shebeibaoxiu);
        return R.ok().put("data",shebeibaoxiu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改设备报修")
    public R update(@RequestBody ShebeibaoxiuEntity shebeibaoxiu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shebeibaoxiu);
        //全部更新
        shebeibaoxiuService.updateById(shebeibaoxiu);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核设备报修")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ShebeibaoxiuEntity> list = new ArrayList<ShebeibaoxiuEntity>();
        for(Long id : ids) {
            ShebeibaoxiuEntity shebeibaoxiu = shebeibaoxiuService.selectById(id);
            shebeibaoxiu.setSfsh(sfsh);
            shebeibaoxiu.setShhf(shhf);
            list.add(shebeibaoxiu);
        }
        shebeibaoxiuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除设备报修")
    public R delete(@RequestBody Long[] ids){
        shebeibaoxiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
