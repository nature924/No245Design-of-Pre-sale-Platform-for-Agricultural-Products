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


import com.dao.NongchanyushouDao;
import com.entity.NongchanyushouEntity;
import com.service.NongchanyushouService;
import com.entity.vo.NongchanyushouVO;
import com.entity.view.NongchanyushouView;

@Service("nongchanyushouService")
public class NongchanyushouServiceImpl extends ServiceImpl<NongchanyushouDao, NongchanyushouEntity> implements NongchanyushouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongchanyushouEntity> page = this.selectPage(
                new Query<NongchanyushouEntity>(params).getPage(),
                new EntityWrapper<NongchanyushouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongchanyushouEntity> wrapper) {
		  Page<NongchanyushouView> page =new Query<NongchanyushouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NongchanyushouVO> selectListVO(Wrapper<NongchanyushouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NongchanyushouVO selectVO(Wrapper<NongchanyushouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NongchanyushouView> selectListView(Wrapper<NongchanyushouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongchanyushouView selectView(Wrapper<NongchanyushouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
