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


import com.dao.NonghuDao;
import com.entity.NonghuEntity;
import com.service.NonghuService;
import com.entity.vo.NonghuVO;
import com.entity.view.NonghuView;

@Service("nonghuService")
public class NonghuServiceImpl extends ServiceImpl<NonghuDao, NonghuEntity> implements NonghuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NonghuEntity> page = this.selectPage(
                new Query<NonghuEntity>(params).getPage(),
                new EntityWrapper<NonghuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NonghuEntity> wrapper) {
		  Page<NonghuView> page =new Query<NonghuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NonghuVO> selectListVO(Wrapper<NonghuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NonghuVO selectVO(Wrapper<NonghuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NonghuView> selectListView(Wrapper<NonghuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NonghuView selectView(Wrapper<NonghuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
