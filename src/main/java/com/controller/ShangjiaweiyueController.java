package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
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

import com.entity.ShangjiaweiyueEntity;
import com.entity.view.ShangjiaweiyueView;

import com.service.ShangjiaweiyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 商家违约
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
@RestController
@RequestMapping("/shangjiaweiyue")
public class ShangjiaweiyueController {
    @Autowired
    private ShangjiaweiyueService shangjiaweiyueService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShangjiaweiyueEntity shangjiaweiyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("nonghu")) {
			shangjiaweiyue.setNonghuhao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("shanghu")) {
			shangjiaweiyue.setShangjiahao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShangjiaweiyueEntity> ew = new EntityWrapper<ShangjiaweiyueEntity>();

		PageUtils page = shangjiaweiyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangjiaweiyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShangjiaweiyueEntity shangjiaweiyue, 
		HttpServletRequest request){
        EntityWrapper<ShangjiaweiyueEntity> ew = new EntityWrapper<ShangjiaweiyueEntity>();

		PageUtils page = shangjiaweiyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shangjiaweiyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShangjiaweiyueEntity shangjiaweiyue){
       	EntityWrapper<ShangjiaweiyueEntity> ew = new EntityWrapper<ShangjiaweiyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shangjiaweiyue, "shangjiaweiyue")); 
        return R.ok().put("data", shangjiaweiyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShangjiaweiyueEntity shangjiaweiyue){
        EntityWrapper< ShangjiaweiyueEntity> ew = new EntityWrapper< ShangjiaweiyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shangjiaweiyue, "shangjiaweiyue")); 
		ShangjiaweiyueView shangjiaweiyueView =  shangjiaweiyueService.selectView(ew);
		return R.ok("查询商家违约成功").put("data", shangjiaweiyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShangjiaweiyueEntity shangjiaweiyue = shangjiaweiyueService.selectById(id);
        return R.ok().put("data", shangjiaweiyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShangjiaweiyueEntity shangjiaweiyue = shangjiaweiyueService.selectById(id);
        return R.ok().put("data", shangjiaweiyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShangjiaweiyueEntity shangjiaweiyue, HttpServletRequest request){
    	shangjiaweiyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangjiaweiyue);
        shangjiaweiyueService.insert(shangjiaweiyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShangjiaweiyueEntity shangjiaweiyue, HttpServletRequest request){
    	shangjiaweiyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shangjiaweiyue);
        shangjiaweiyueService.insert(shangjiaweiyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShangjiaweiyueEntity shangjiaweiyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shangjiaweiyue);
        shangjiaweiyueService.updateById(shangjiaweiyue);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shangjiaweiyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<ShangjiaweiyueEntity> wrapper = new EntityWrapper<ShangjiaweiyueEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("nonghu")) {
			wrapper.eq("nonghuhao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("shanghu")) {
			wrapper.eq("shangjiahao", (String)request.getSession().getAttribute("username"));
		}

		int count = shangjiaweiyueService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
