package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.SmsregistercodeDao;
import com.entity.SmsregistercodeEntity;
import com.service.SmsregistercodeService;
import com.entity.vo.SmsregistercodeVO;
import com.entity.view.SmsregistercodeView;

@Service("smsregistercodeService")
public class SmsregistercodeServiceImpl extends ServiceImpl<SmsregistercodeDao, SmsregistercodeEntity> implements SmsregistercodeService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SmsregistercodeEntity> page = this.selectPage(
                new Query<SmsregistercodeEntity>(params).getPage(),
                new EntityWrapper<SmsregistercodeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<SmsregistercodeEntity> wrapper) {
		  Page<SmsregistercodeView> page =new Query<SmsregistercodeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<SmsregistercodeVO> selectListVO(Wrapper<SmsregistercodeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public SmsregistercodeVO selectVO(Wrapper<SmsregistercodeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<SmsregistercodeView> selectListView(Wrapper<SmsregistercodeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public SmsregistercodeView selectView(Wrapper<SmsregistercodeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
