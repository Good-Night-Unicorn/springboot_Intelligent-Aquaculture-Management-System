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

import com.entity.JibingbaogaoEntity;
import com.entity.view.JibingbaogaoView;

import com.service.JibingbaogaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 疾病报告
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 09:14:12
 */
@RestController
@RequestMapping("/jibingbaogao")
public class JibingbaogaoController {
    @Autowired
    private JibingbaogaoService jibingbaogaoService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JibingbaogaoEntity jibingbaogao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jibingbaogao.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<JibingbaogaoEntity> ew = new EntityWrapper<JibingbaogaoEntity>();


        //查询结果
		PageUtils page = jibingbaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jibingbaogao), params), params));
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
    public R list(@RequestParam Map<String, Object> params,JibingbaogaoEntity jibingbaogao, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<JibingbaogaoEntity> ew = new EntityWrapper<JibingbaogaoEntity>();

        //查询结果
		PageUtils page = jibingbaogaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jibingbaogao), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JibingbaogaoEntity jibingbaogao){
       	EntityWrapper<JibingbaogaoEntity> ew = new EntityWrapper<JibingbaogaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jibingbaogao, "jibingbaogao")); 
        return R.ok().put("data", jibingbaogaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JibingbaogaoEntity jibingbaogao){
        EntityWrapper< JibingbaogaoEntity> ew = new EntityWrapper< JibingbaogaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jibingbaogao, "jibingbaogao")); 
		JibingbaogaoView jibingbaogaoView =  jibingbaogaoService.selectView(ew);
		return R.ok("查询疾病报告成功").put("data", jibingbaogaoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JibingbaogaoEntity jibingbaogao = jibingbaogaoService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jibingbaogao,deSens);
        return R.ok().put("data", jibingbaogao);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JibingbaogaoEntity jibingbaogao = jibingbaogaoService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(jibingbaogao,deSens);
        return R.ok().put("data", jibingbaogao);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增疾病报告") 
    public R save(@RequestBody JibingbaogaoEntity jibingbaogao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jibingbaogao);
        jibingbaogaoService.insert(jibingbaogao);
        return R.ok().put("data",jibingbaogao.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增疾病报告")
    @RequestMapping("/add")
    public R add(@RequestBody JibingbaogaoEntity jibingbaogao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jibingbaogao);
        jibingbaogaoService.insert(jibingbaogao);
        return R.ok().put("data",jibingbaogao.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改疾病报告")
    public R update(@RequestBody JibingbaogaoEntity jibingbaogao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jibingbaogao);
        //全部更新
        jibingbaogaoService.updateById(jibingbaogao);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核疾病报告")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JibingbaogaoEntity> list = new ArrayList<JibingbaogaoEntity>();
        for(Long id : ids) {
            JibingbaogaoEntity jibingbaogao = jibingbaogaoService.selectById(id);
            jibingbaogao.setSfsh(sfsh);
            jibingbaogao.setShhf(shhf);
            list.add(jibingbaogao);
        }
        jibingbaogaoService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除疾病报告")
    public R delete(@RequestBody Long[] ids){
        jibingbaogaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
