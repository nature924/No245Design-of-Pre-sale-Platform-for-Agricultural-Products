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


import com.dao.ShangjiaweiyueDao;
import com.entity.ShangjiaweiyueEntity;
import com.service.ShangjiaweiyueService;
import com.entity.vo.ShangjiaweiyueVO;
import com.entity.view.ShangjiaweiyueView;

@Service("shangjiaweiyueService")
public class ShangjiaweiyueServiceImpl extends ServiceImpl<ShangjiaweiyueDao, ShangjiaweiyueEntity> implements ShangjiaweiyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShangjiaweiyueEntity> page = this.selectPage(
                new Query<ShangjiaweiyueEntity>(params).getPage(),
                new EntityWrapper<ShangjiaweiyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShangjiaweiyueEntity> wrapper) {
		  Page<ShangjiaweiyueView> page =new Query<ShangjiaweiyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShangjiaweiyueVO> selectListVO(Wrapper<ShangjiaweiyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShangjiaweiyueVO selectVO(Wrapper<ShangjiaweiyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShangjiaweiyueView> selectListView(Wrapper<ShangjiaweiyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShangjiaweiyueView selectView(Wrapper<ShangjiaweiyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
