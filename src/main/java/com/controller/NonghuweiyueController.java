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

import com.entity.NonghuweiyueEntity;
import com.entity.view.NonghuweiyueView;

import com.service.NonghuweiyueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 农户违约
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
@RestController
@RequestMapping("/nonghuweiyue")
public class NonghuweiyueController {
    @Autowired
    private NonghuweiyueService nonghuweiyueService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NonghuweiyueEntity nonghuweiyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("nonghu")) {
			nonghuweiyue.setNonghuhao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("shanghu")) {
			nonghuweiyue.setShangjiahao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<NonghuweiyueEntity> ew = new EntityWrapper<NonghuweiyueEntity>();

		PageUtils page = nonghuweiyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nonghuweiyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NonghuweiyueEntity nonghuweiyue, 
		HttpServletRequest request){
        EntityWrapper<NonghuweiyueEntity> ew = new EntityWrapper<NonghuweiyueEntity>();

		PageUtils page = nonghuweiyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nonghuweiyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NonghuweiyueEntity nonghuweiyue){
       	EntityWrapper<NonghuweiyueEntity> ew = new EntityWrapper<NonghuweiyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nonghuweiyue, "nonghuweiyue")); 
        return R.ok().put("data", nonghuweiyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NonghuweiyueEntity nonghuweiyue){
        EntityWrapper< NonghuweiyueEntity> ew = new EntityWrapper< NonghuweiyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nonghuweiyue, "nonghuweiyue")); 
		NonghuweiyueView nonghuweiyueView =  nonghuweiyueService.selectView(ew);
		return R.ok("查询农户违约成功").put("data", nonghuweiyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NonghuweiyueEntity nonghuweiyue = nonghuweiyueService.selectById(id);
        return R.ok().put("data", nonghuweiyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NonghuweiyueEntity nonghuweiyue = nonghuweiyueService.selectById(id);
        return R.ok().put("data", nonghuweiyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NonghuweiyueEntity nonghuweiyue, HttpServletRequest request){
    	nonghuweiyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nonghuweiyue);
        nonghuweiyueService.insert(nonghuweiyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NonghuweiyueEntity nonghuweiyue, HttpServletRequest request){
    	nonghuweiyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nonghuweiyue);
        nonghuweiyueService.insert(nonghuweiyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NonghuweiyueEntity nonghuweiyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nonghuweiyue);
        nonghuweiyueService.updateById(nonghuweiyue);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nonghuweiyueService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<NonghuweiyueEntity> wrapper = new EntityWrapper<NonghuweiyueEntity>();
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

		int count = nonghuweiyueService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
