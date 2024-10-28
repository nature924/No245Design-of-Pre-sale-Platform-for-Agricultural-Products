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


import com.dao.NongchanqiugouDao;
import com.entity.NongchanqiugouEntity;
import com.service.NongchanqiugouService;
import com.entity.vo.NongchanqiugouVO;
import com.entity.view.NongchanqiugouView;

@Service("nongchanqiugouService")
public class NongchanqiugouServiceImpl extends ServiceImpl<NongchanqiugouDao, NongchanqiugouEntity> implements NongchanqiugouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongchanqiugouEntity> page = this.selectPage(
                new Query<NongchanqiugouEntity>(params).getPage(),
                new EntityWrapper<NongchanqiugouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongchanqiugouEntity> wrapper) {
		  Page<NongchanqiugouView> page =new Query<NongchanqiugouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NongchanqiugouVO> selectListVO(Wrapper<NongchanqiugouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NongchanqiugouVO selectVO(Wrapper<NongchanqiugouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NongchanqiugouView> selectListView(Wrapper<NongchanqiugouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongchanqiugouView selectView(Wrapper<NongchanqiugouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
