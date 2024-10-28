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


import com.dao.NongchandengjiDao;
import com.entity.NongchandengjiEntity;
import com.service.NongchandengjiService;
import com.entity.vo.NongchandengjiVO;
import com.entity.view.NongchandengjiView;

@Service("nongchandengjiService")
public class NongchandengjiServiceImpl extends ServiceImpl<NongchandengjiDao, NongchandengjiEntity> implements NongchandengjiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongchandengjiEntity> page = this.selectPage(
                new Query<NongchandengjiEntity>(params).getPage(),
                new EntityWrapper<NongchandengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongchandengjiEntity> wrapper) {
		  Page<NongchandengjiView> page =new Query<NongchandengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<NongchandengjiVO> selectListVO(Wrapper<NongchandengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NongchandengjiVO selectVO(Wrapper<NongchandengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NongchandengjiView> selectListView(Wrapper<NongchandengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongchandengjiView selectView(Wrapper<NongchandengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
