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

import com.entity.DiscussjibingzhishiEntity;
import com.entity.view.DiscussjibingzhishiView;

import com.service.DiscussjibingzhishiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 疾病知识评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 09:14:14
 */
@RestController
@RequestMapping("/discussjibingzhishi")
public class DiscussjibingzhishiController {
    @Autowired
    private DiscussjibingzhishiService discussjibingzhishiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjibingzhishiEntity discussjibingzhishi,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussjibingzhishiEntity> ew = new EntityWrapper<DiscussjibingzhishiEntity>();


        //查询结果
		PageUtils page = discussjibingzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjibingzhishi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,DiscussjibingzhishiEntity discussjibingzhishi, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscussjibingzhishiEntity> ew = new EntityWrapper<DiscussjibingzhishiEntity>();

        //查询结果
		PageUtils page = discussjibingzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjibingzhishi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjibingzhishiEntity discussjibingzhishi){
       	EntityWrapper<DiscussjibingzhishiEntity> ew = new EntityWrapper<DiscussjibingzhishiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjibingzhishi, "discussjibingzhishi")); 
        return R.ok().put("data", discussjibingzhishiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjibingzhishiEntity discussjibingzhishi){
        EntityWrapper< DiscussjibingzhishiEntity> ew = new EntityWrapper< DiscussjibingzhishiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjibingzhishi, "discussjibingzhishi")); 
		DiscussjibingzhishiView discussjibingzhishiView =  discussjibingzhishiService.selectView(ew);
		return R.ok("查询疾病知识评论表成功").put("data", discussjibingzhishiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjibingzhishiEntity discussjibingzhishi = discussjibingzhishiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussjibingzhishi,deSens);
        return R.ok().put("data", discussjibingzhishi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjibingzhishiEntity discussjibingzhishi = discussjibingzhishiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discussjibingzhishi,deSens);
        return R.ok().put("data", discussjibingzhishi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增疾病知识评论表") 
    public R save(@RequestBody DiscussjibingzhishiEntity discussjibingzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjibingzhishi);
        discussjibingzhishiService.insert(discussjibingzhishi);
        return R.ok().put("data",discussjibingzhishi.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增疾病知识评论表")
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjibingzhishiEntity discussjibingzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjibingzhishi);
        discussjibingzhishiService.insert(discussjibingzhishi);
        return R.ok().put("data",discussjibingzhishi.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscussjibingzhishiEntity discussjibingzhishi = discussjibingzhishiService.selectOne(new EntityWrapper<DiscussjibingzhishiEntity>().eq("", username));
        return R.ok().put("data", discussjibingzhishi);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussjibingzhishiEntity discussjibingzhishi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjibingzhishi);
        //全部更新
        discussjibingzhishiService.updateById(discussjibingzhishi);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除疾病知识评论表")
    public R delete(@RequestBody Long[] ids){
        discussjibingzhishiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussjibingzhishiEntity discussjibingzhishi, HttpServletRequest request,String pre){
        EntityWrapper<DiscussjibingzhishiEntity> ew = new EntityWrapper<DiscussjibingzhishiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");

		PageUtils page = discussjibingzhishiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjibingzhishi), params), params));
        return R.ok().put("data", page);
    }








}
