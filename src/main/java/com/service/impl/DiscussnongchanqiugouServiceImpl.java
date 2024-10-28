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


import com.dao.DiscussnongchanqiugouDao;
import com.entity.DiscussnongchanqiugouEntity;
import com.service.DiscussnongchanqiugouService;
import com.entity.vo.DiscussnongchanqiugouVO;
import com.entity.view.DiscussnongchanqiugouView;

@Service("discussnongchanqiugouService")
public class DiscussnongchanqiugouServiceImpl extends ServiceImpl<DiscussnongchanqiugouDao, DiscussnongchanqiugouEntity> implements DiscussnongchanqiugouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussnongchanqiugouEntity> page = this.selectPage(
                new Query<DiscussnongchanqiugouEntity>(params).getPage(),
                new EntityWrapper<DiscussnongchanqiugouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussnongchanqiugouEntity> wrapper) {
		  Page<DiscussnongchanqiugouView> page =new Query<DiscussnongchanqiugouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussnongchanqiugouVO> selectListVO(Wrapper<DiscussnongchanqiugouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussnongchanqiugouVO selectVO(Wrapper<DiscussnongchanqiugouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussnongchanqiugouView> selectListView(Wrapper<DiscussnongchanqiugouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussnongchanqiugouView selectView(Wrapper<DiscussnongchanqiugouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
