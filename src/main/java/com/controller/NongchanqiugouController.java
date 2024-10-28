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

import com.entity.NongchanqiugouEntity;
import com.entity.view.NongchanqiugouView;

import com.service.NongchanqiugouService;
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
 * 农产求购
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
@RestController
@RequestMapping("/nongchanqiugou")
public class NongchanqiugouController {
    @Autowired
    private NongchanqiugouService nongchanqiugouService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongchanqiugouEntity nongchanqiugou,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("nonghu")) {
			nongchanqiugou.setShangjiahao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<NongchanqiugouEntity> ew = new EntityWrapper<NongchanqiugouEntity>();

		PageUtils page = nongchanqiugouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanqiugou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NongchanqiugouEntity nongchanqiugou, 
		HttpServletRequest request){
        EntityWrapper<NongchanqiugouEntity> ew = new EntityWrapper<NongchanqiugouEntity>();

		PageUtils page = nongchanqiugouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanqiugou), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongchanqiugouEntity nongchanqiugou){
       	EntityWrapper<NongchanqiugouEntity> ew = new EntityWrapper<NongchanqiugouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongchanqiugou, "nongchanqiugou")); 
        return R.ok().put("data", nongchanqiugouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongchanqiugouEntity nongchanqiugou){
        EntityWrapper< NongchanqiugouEntity> ew = new EntityWrapper< NongchanqiugouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongchanqiugou, "nongchanqiugou")); 
		NongchanqiugouView nongchanqiugouView =  nongchanqiugouService.selectView(ew);
		return R.ok("查询农产求购成功").put("data", nongchanqiugouView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongchanqiugouEntity nongchanqiugou = nongchanqiugouService.selectById(id);
		nongchanqiugou.setClicktime(new Date());
		nongchanqiugouService.updateById(nongchanqiugou);
        return R.ok().put("data", nongchanqiugou);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongchanqiugouEntity nongchanqiugou = nongchanqiugouService.selectById(id);
		nongchanqiugou.setClicktime(new Date());
		nongchanqiugouService.updateById(nongchanqiugou);
        return R.ok().put("data", nongchanqiugou);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NongchanqiugouEntity nongchanqiugou, HttpServletRequest request){
    	nongchanqiugou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongchanqiugou);
        nongchanqiugouService.insert(nongchanqiugou);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NongchanqiugouEntity nongchanqiugou, HttpServletRequest request){
    	nongchanqiugou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nongchanqiugou);
        nongchanqiugouService.insert(nongchanqiugou);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NongchanqiugouEntity nongchanqiugou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongchanqiugou);
        nongchanqiugouService.updateById(nongchanqiugou);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nongchanqiugouService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<NongchanqiugouEntity> wrapper = new EntityWrapper<NongchanqiugouEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("nonghu")) {
			wrapper.eq("shangjiahao", (String)request.getSession().getAttribute("username"));
		}

		int count = nongchanqiugouService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,NongchanqiugouEntity nongchanqiugou, HttpServletRequest request,String pre){
        EntityWrapper<NongchanqiugouEntity> ew = new EntityWrapper<NongchanqiugouEntity>();
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
		PageUtils page = nongchanqiugouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanqiugou), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,NongchanqiugouEntity nongchanqiugou, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "chanpinleixing";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "nongchanqiugou").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<NongchanqiugouEntity> nongchanqiugouList = new ArrayList<NongchanqiugouEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                nongchanqiugouList.addAll(nongchanqiugouService.selectList(new EntityWrapper<NongchanqiugouEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<NongchanqiugouEntity> ew = new EntityWrapper<NongchanqiugouEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = nongchanqiugouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongchanqiugou), params), params));
        List<NongchanqiugouEntity> pageList = (List<NongchanqiugouEntity>)page.getList();
        if(nongchanqiugouList.size()<limit) {
            int toAddNum = (limit-nongchanqiugouList.size())<=pageList.size()?(limit-nongchanqiugouList.size()):pageList.size();
            for(NongchanqiugouEntity o1 : pageList) {
                boolean addFlag = true;
                for(NongchanqiugouEntity o2 : nongchanqiugouList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    nongchanqiugouList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(nongchanqiugouList.size()>limit) {
            nongchanqiugouList = nongchanqiugouList.subList(0, limit);
        }
        page.setList(nongchanqiugouList);
        return R.ok().put("data", page);
    }







}
