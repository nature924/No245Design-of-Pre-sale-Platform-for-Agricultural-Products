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


import com.dao.YushouweikuanDao;
import com.entity.YushouweikuanEntity;
import com.service.YushouweikuanService;
import com.entity.vo.YushouweikuanVO;
import com.entity.view.YushouweikuanView;

@Service("yushouweikuanService")
public class YushouweikuanServiceImpl extends ServiceImpl<YushouweikuanDao, YushouweikuanEntity> implements YushouweikuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YushouweikuanEntity> page = this.selectPage(
                new Query<YushouweikuanEntity>(params).getPage(),
                new EntityWrapper<YushouweikuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YushouweikuanEntity> wrapper) {
		  Page<YushouweikuanView> page =new Query<YushouweikuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YushouweikuanVO> selectListVO(Wrapper<YushouweikuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YushouweikuanVO selectVO(Wrapper<YushouweikuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YushouweikuanView> selectListView(Wrapper<YushouweikuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YushouweikuanView selectView(Wrapper<YushouweikuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
