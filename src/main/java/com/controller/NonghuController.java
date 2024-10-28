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

import com.entity.NonghuEntity;
import com.entity.view.NonghuView;

import com.service.NonghuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.SmsregistercodeService;
import com.entity.SmsregistercodeEntity;

/**
 * 农户
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
@RestController
@RequestMapping("/nonghu")
public class NonghuController {
    @Autowired
    private NonghuService nonghuService;
    @Autowired
    private SmsregistercodeService smsregistercodeService;


    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		NonghuEntity u = nonghuService.selectOne(new EntityWrapper<NonghuEntity>().eq("nonghuhao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}
		
		String token = tokenService.generateToken(u.getId(), username,"nonghu",  "农户" );
		return R.ok().put("token", token);
	}

	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody NonghuEntity nonghu, @RequestParam(required = false) String smscode){
    	//ValidatorUtils.validateEntity(nonghu);
    	NonghuEntity u = nonghuService.selectOne(new EntityWrapper<NonghuEntity>().eq("nonghuhao", nonghu.getNonghuhao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //校验短信验证码
        u =nonghuService.selectOne(new EntityWrapper<NonghuEntity>().eq("mobile", nonghu.getMobile()));
        if(u!=null) {
            return R.error("手机已被注册");
        }
        List<SmsregistercodeEntity> smsregistercodeList = smsregistercodeService.selectList(
                                        new EntityWrapper<SmsregistercodeEntity>().eq("role", "农户")
                                        .eq("mobile", nonghu.getMobile()).orderBy("addtime", false));
        boolean smsValidate = false;
        if(smsregistercodeList!=null && smsregistercodeList.size()>0) {
            if(smsregistercodeList.get(0).getCode().equals(smscode)) {
                smsValidate = true;
            }
        }
        if(!smsValidate) return R.error("短信验证码不正确");
		Long uId = new Date().getTime();
		nonghu.setId(uId);
        nonghuService.insert(nonghu);
        return R.ok();
    }

    /**
     * 发送短信
     */
    @IgnoreAuth
    @RequestMapping("/sendsms")
    public R sendemail(@RequestParam String mobile){
        String code = CommonUtil.getRandomNumber(6);
        SmsregistercodeEntity smsregistercode = new SmsregistercodeEntity();
        smsregistercode.setCode(code);
        smsregistercode.setRole("农户");
        smsregistercode.setMobile(mobile);
        smsregistercodeService.insert(smsregistercode);
        CommonUtil.sendSMS(mobile, code);
        return R.ok().put("data", code);
    }
	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        NonghuEntity u = nonghuService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	NonghuEntity u = nonghuService.selectOne(new EntityWrapper<NonghuEntity>().eq("nonghuhao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        nonghuService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NonghuEntity nonghu,
		HttpServletRequest request){
        EntityWrapper<NonghuEntity> ew = new EntityWrapper<NonghuEntity>();

		PageUtils page = nonghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nonghu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NonghuEntity nonghu, 
		HttpServletRequest request){
        EntityWrapper<NonghuEntity> ew = new EntityWrapper<NonghuEntity>();

		PageUtils page = nonghuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nonghu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NonghuEntity nonghu){
       	EntityWrapper<NonghuEntity> ew = new EntityWrapper<NonghuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nonghu, "nonghu")); 
        return R.ok().put("data", nonghuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NonghuEntity nonghu){
        EntityWrapper< NonghuEntity> ew = new EntityWrapper< NonghuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nonghu, "nonghu")); 
		NonghuView nonghuView =  nonghuService.selectView(ew);
		return R.ok("查询农户成功").put("data", nonghuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NonghuEntity nonghu = nonghuService.selectById(id);
        return R.ok().put("data", nonghu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NonghuEntity nonghu = nonghuService.selectById(id);
        return R.ok().put("data", nonghu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody NonghuEntity nonghu, HttpServletRequest request){
    	nonghu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nonghu);
    	NonghuEntity u = nonghuService.selectOne(new EntityWrapper<NonghuEntity>().eq("nonghuhao", nonghu.getNonghuhao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		nonghu.setId(new Date().getTime());
        nonghuService.insert(nonghu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody NonghuEntity nonghu, HttpServletRequest request){
    	nonghu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(nonghu);
    	NonghuEntity u = nonghuService.selectOne(new EntityWrapper<NonghuEntity>().eq("nonghuhao", nonghu.getNonghuhao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		nonghu.setId(new Date().getTime());
        nonghuService.insert(nonghu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody NonghuEntity nonghu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nonghu);
        nonghuService.updateById(nonghu);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        nonghuService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<NonghuEntity> wrapper = new EntityWrapper<NonghuEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = nonghuService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
