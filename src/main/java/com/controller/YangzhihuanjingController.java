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

import com.entity.YangzhihuanjingEntity;
import com.entity.view.YangzhihuanjingView;

import com.service.YangzhihuanjingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 养殖环境
 * 后端接口
 * @author 
 * @email 
 * @date 2025-04-27 09:14:10
 */
@RestController
@RequestMapping("/yangzhihuanjing")
public class YangzhihuanjingController {
    @Autowired
    private YangzhihuanjingService yangzhihuanjingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YangzhihuanjingEntity yangzhihuanjing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YangzhihuanjingEntity> ew = new EntityWrapper<YangzhihuanjingEntity>();


        //查询结果
		PageUtils page = yangzhihuanjingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangzhihuanjing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YangzhihuanjingEntity yangzhihuanjing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YangzhihuanjingEntity> ew = new EntityWrapper<YangzhihuanjingEntity>();

        //查询结果
		PageUtils page = yangzhihuanjingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangzhihuanjing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YangzhihuanjingEntity yangzhihuanjing){
       	EntityWrapper<YangzhihuanjingEntity> ew = new EntityWrapper<YangzhihuanjingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yangzhihuanjing, "yangzhihuanjing")); 
        return R.ok().put("data", yangzhihuanjingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YangzhihuanjingEntity yangzhihuanjing){
        EntityWrapper< YangzhihuanjingEntity> ew = new EntityWrapper< YangzhihuanjingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yangzhihuanjing, "yangzhihuanjing")); 
		YangzhihuanjingView yangzhihuanjingView =  yangzhihuanjingService.selectView(ew);
		return R.ok("查询养殖环境成功").put("data", yangzhihuanjingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YangzhihuanjingEntity yangzhihuanjing = yangzhihuanjingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yangzhihuanjing,deSens);
        return R.ok().put("data", yangzhihuanjing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YangzhihuanjingEntity yangzhihuanjing = yangzhihuanjingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yangzhihuanjing,deSens);
        return R.ok().put("data", yangzhihuanjing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增养殖环境") 
    public R save(@RequestBody YangzhihuanjingEntity yangzhihuanjing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yangzhihuanjing);
        yangzhihuanjingService.insert(yangzhihuanjing);
        return R.ok().put("data",yangzhihuanjing.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增养殖环境")
    @RequestMapping("/add")
    public R add(@RequestBody YangzhihuanjingEntity yangzhihuanjing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yangzhihuanjing);
        yangzhihuanjingService.insert(yangzhihuanjing);
        return R.ok().put("data",yangzhihuanjing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改养殖环境")
    public R update(@RequestBody YangzhihuanjingEntity yangzhihuanjing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yangzhihuanjing);
        //全部更新
        yangzhihuanjingService.updateById(yangzhihuanjing);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除养殖环境")
    public R delete(@RequestBody Long[] ids){
        yangzhihuanjingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {

        Wrapper<YangzhihuanjingEntity> wrapper = new EntityWrapper<YangzhihuanjingEntity>();

        // 从map中获取remindStart和remindEnd，组装提醒过滤条件
        Object remindStart = map.get("remindstart") != null ? map.get("remindstart").toString() : null;
        Object remindEnd = map.get("remindend") != null ? map.get("remindend").toString() : null;
        if ("2".equals(type)) {
            Date startDate = null;
            Date endDate = null;
            if (null != remindStart) {
                Calendar c = Calendar.getInstance();
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH, Integer.parseInt(remindStart.toString()));
                startDate = c.getTime();
            }
            if (null != remindEnd) {
                Calendar c = Calendar.getInstance();
                c.setTime(new Date());
                c.add(Calendar.DAY_OF_MONTH, Integer.parseInt(remindEnd.toString()));
                endDate = c.getTime();
            }
            if (startDate != null && endDate != null) {
                if (startDate.before(endDate)) {
                    wrapper.ge(columnName, startDate).le(columnName, endDate);
                } else {
                    wrapper.ge(columnName, startDate).or().le(columnName, endDate);
                }
            } else if (startDate == null && endDate != null) {
                wrapper.le(columnName, endDate);
            } else if (startDate != null && endDate == null) {
                wrapper.ge(columnName, startDate);
            }
        } else {
            if (remindStart != null && remindEnd != null) {
                if (Double.parseDouble(remindStart.toString()) < Double.parseDouble(remindEnd.toString())) {
                    wrapper.ge(columnName, remindStart).le(columnName, remindEnd);
                } else {
                    wrapper.ge(columnName, remindStart).or().le(columnName, remindEnd);
                }
            } else if (remindStart == null && remindEnd != null) {
                wrapper.le(columnName, remindEnd);
            } else if (remindStart != null && remindEnd == null) {
                wrapper.ge(columnName, remindStart);
            }
        }

        //根据条件，查询结果
        List<YangzhihuanjingEntity> list = yangzhihuanjingService.selectList(wrapper);
        Map<String,Object> res= new HashMap<>();
        res.put("count", list.size());
        res.put("data",list.stream().map(YangzhihuanjingEntity::getYangzhiquyu).collect(Collectors.toList()));
        return R.ok(res);
	}






    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_yangzhihuanjing_" + xColumnName + "_" + yColumnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        //构建查询统计条件
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<YangzhihuanjingEntity> ew = new EntityWrapper<YangzhihuanjingEntity>();
            //获取结果
        List<Map<String, Object>> result = yangzhihuanjingService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        Collections.sort(result, (map1, map2) -> {
            // 假设 total 总是存在并且是数值类型
            Number total1 = (Number) map1.get("total");
            Number total2 = (Number) map2.get("total");
            if(total1==null)
            {
                total1 = 0;
            }
            if(total2==null)
            {
                total2 = 0;
            }
            return Double.compare(total2.doubleValue(), total1.doubleValue());
        });
        return R.ok().put("data", result);
    }
    
    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul,HttpServletRequest request)  throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_yangzhihuanjing_" + xColumnName + "_" + yColumnNameMul + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //构建查询统计条件
        EntityWrapper<YangzhihuanjingEntity> ew = new EntityWrapper<YangzhihuanjingEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = yangzhihuanjingService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
    
    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_yangzhihuanjing_" + xColumnName + "_" + yColumnName + "_"+timeStatType+".json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        //构建查询统计条件
        EntityWrapper<YangzhihuanjingEntity> ew = new EntityWrapper<YangzhihuanjingEntity>();
        List<Map<String, Object>> result = yangzhihuanjingService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }
    
    /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) throws IOException
    {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("value_yangzhihuanjing_" + xColumnName + "_" + yColumnNameMul + "_" + timeStatType + ".json");
        if (java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("timeStatType", timeStatType);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //构建查询统计条件
        EntityWrapper<YangzhihuanjingEntity> ew = new EntityWrapper<YangzhihuanjingEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = yangzhihuanjingService.selectTimeStatValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
    
    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) throws IOException {
        //读取文件，如果文件存在，则优先返回文件内容
        java.nio.file.Path path = java.nio.file.Paths.get("group_yangzhihuanjing_" + columnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)){
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        //构建查询统计条件
        EntityWrapper<YangzhihuanjingEntity> ew = new EntityWrapper<YangzhihuanjingEntity>();
        List<Map<String, Object>> result = yangzhihuanjingService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }    




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,YangzhihuanjingEntity yangzhihuanjing, HttpServletRequest request){
        EntityWrapper<YangzhihuanjingEntity> ew = new EntityWrapper<YangzhihuanjingEntity>();
        int count = yangzhihuanjingService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yangzhihuanjing), params), params));
        return R.ok().put("data", count);
    }

}
