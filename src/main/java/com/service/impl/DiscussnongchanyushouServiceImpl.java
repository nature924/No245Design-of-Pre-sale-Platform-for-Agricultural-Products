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


import com.dao.DiscussnongchanyushouDao;
import com.entity.DiscussnongchanyushouEntity;
import com.service.DiscussnongchanyushouService;
import com.entity.vo.DiscussnongchanyushouVO;
import com.entity.view.DiscussnongchanyushouView;

@Service("discussnongchanyushouService")
public class DiscussnongchanyushouServiceImpl extends ServiceImpl<DiscussnongchanyushouDao, DiscussnongchanyushouEntity> implements DiscussnongchanyushouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussnongchanyushouEntity> page = this.selectPage(
                new Query<DiscussnongchanyushouEntity>(params).getPage(),
                new EntityWrapper<DiscussnongchanyushouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussnongchanyushouEntity> wrapper) {
		  Page<DiscussnongchanyushouView> page =new Query<DiscussnongchanyushouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussnongchanyushouVO> selectListVO(Wrapper<DiscussnongchanyushouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussnongchanyushouVO selectVO(Wrapper<DiscussnongchanyushouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussnongchanyushouView> selectListView(Wrapper<DiscussnongchanyushouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussnongchanyushouView selectView(Wrapper<DiscussnongchanyushouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
