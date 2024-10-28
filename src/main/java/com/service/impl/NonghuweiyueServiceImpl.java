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


import com.dao.NonghuweiyueDao;
import com.entity.NonghuweiyueEntity;
import com.service.NonghuweiyueService;
import com.entity.vo.NonghuweiyueVO;
import com.entity.view.NonghuweiyueView;

@Service("nonghuweiyueService")
public class NonghuweiyueServiceImpl extends ServiceImpl<NonghuweiyueDao, NonghuweiyueEntity> implements NonghuweiyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NonghuweiyueEntity> page = this.selectPage(
                new Query<NonghuweiyueEntity>(params).getPage(),
                new EntityWrapper<NonghuweiyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NonghuweiyueEntity> wrapper) {
		  Page<NonghuweiyueView> page =new Query<NonghuweiyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NonghuweiyueVO> selectListVO(Wrapper<NonghuweiyueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NonghuweiyueVO selectVO(Wrapper<NonghuweiyueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NonghuweiyueView> selectListView(Wrapper<NonghuweiyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NonghuweiyueView selectView(Wrapper<NonghuweiyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
