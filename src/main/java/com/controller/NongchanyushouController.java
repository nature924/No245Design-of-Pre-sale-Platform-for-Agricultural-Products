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

import com.entity.NongchanyushouEntity;
import com.entity.view.NongchanyushouView;

import com.service.NongchanyushouService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 农产预售
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
@RestController
@RequestMapping("/nongchanyushou")
public class NongchanyushouController {
    @Autowired
    private NongchanyushouService nongchanyushouService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongchanyushouEntity nongchanyushou,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("nonghu")) {
			nongchanyushou.setNonghuhao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<NongchanyushouEntity> ew = new EntityWrapper<NongchanyushouEntity>();

		PageUtils page = nongchanyushouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanyushou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NongchanyushouEntity nongchanyushou, 
		HttpServletRequest request){
        EntityWrapper<NongchanyushouEntity> ew = new EntityWrapper<NongchanyushouEntity>();

		PageUtils page = nongchanyushouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanyushou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongchanyushouEntity nongchanyushou){
       	EntityWrapper<NongchanyushouEntity> ew = new EntityWrapper<NongchanyushouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongchanyushou, "nongchanyushou")); 
        return R.ok().put("data", nongchanyushouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongchanyushouEntity nongchanyushou){
        EntityWrapper< NongchanyushouEntity> ew = new EntityWrapper< NongchanyushouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongchanyushou, "nongchanyushou")); 
		NongchanyushouView nongchanyushouView =  nongchanyushouService.selectView(ew);
		return R.ok("查询农产预售成功").put("data", nongchanyushouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongchanyushouEntity nongchanyushou = nongchanyushouService.selectById(id);
		nongchanyushou.setClicktime(new Date());
		nongchanyushouService.updateById(nongchanyushou);
        return R.ok().put("data", nongchanyushou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongchanyushouEntity nongchanyushou = nongchanyushouService.selectById(id);
		nongchanyushou.setClicktime(new Date());
		nongchanyushouService.updateById(nongchanyushou);
        return R.ok().put("data", nongchanyushou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NongchanyushouEntity nongchanyushou, HttpServletRequest request){
    	nongchanyushou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongchanyushou);
        nongchanyushouService.insert(nongchanyushou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NongchanyushouEntity nongchanyushou, HttpServletRequest request){
    	nongchanyushou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongchanyushou);
        nongchanyushouService.insert(nongchanyushou);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NongchanyushouEntity nongchanyushou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongchanyushou);
        nongchanyushouService.updateById(nongchanyushou);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nongchanyushouService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<NongchanyushouEntity> wrapper = new EntityWrapper<NongchanyushouEntity>();
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

		int count = nongchanyushouService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,NongchanyushouEntity nongchanyushou, HttpServletRequest request,String pre){
        EntityWrapper<NongchanyushouEntity> ew = new EntityWrapper<NongchanyushouEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
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
		PageUtils page = nongchanyushouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanyushou), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,NongchanyushouEntity nongchanyushou, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "chanpinleixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "nongchanyushou").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<NongchanyushouEntity> nongchanyushouList = new ArrayList<NongchanyushouEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                nongchanyushouList.addAll(nongchanyushouService.selectList(new EntityWrapper<NongchanyushouEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<NongchanyushouEntity> ew = new EntityWrapper<NongchanyushouEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = nongchanyushouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanyushou), params), params));
        List<NongchanyushouEntity> pageList = (List<NongchanyushouEntity>)page.getList();
        if(nongchanyushouList.size()<limit) {
            int toAddNum = (limit-nongchanyushouList.size())<=pageList.size()?(limit-nongchanyushouList.size()):pageList.size();
            for(NongchanyushouEntity o1 : pageList) {
                boolean addFlag = true;
                for(NongchanyushouEntity o2 : nongchanyushouList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    nongchanyushouList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(nongchanyushouList.size()>limit) {
            nongchanyushouList = nongchanyushouList.subList(0, limit);
        }
        page.setList(nongchanyushouList);
        return R.ok().put("data", page);
    }







}
