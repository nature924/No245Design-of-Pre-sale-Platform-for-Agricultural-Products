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


import com.dao.YudingnongchanDao;
import com.entity.YudingnongchanEntity;
import com.service.YudingnongchanService;
import com.entity.vo.YudingnongchanVO;
import com.entity.view.YudingnongchanView;

@Service("yudingnongchanService")
public class YudingnongchanServiceImpl extends ServiceImpl<YudingnongchanDao, YudingnongchanEntity> implements YudingnongchanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YudingnongchanEntity> page = this.selectPage(
                new Query<YudingnongchanEntity>(params).getPage(),
                new EntityWrapper<YudingnongchanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YudingnongchanEntity> wrapper) {
		  Page<YudingnongchanView> page =new Query<YudingnongchanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YudingnongchanVO> selectListVO(Wrapper<YudingnongchanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YudingnongchanVO selectVO(Wrapper<YudingnongchanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YudingnongchanView> selectListView(Wrapper<YudingnongchanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YudingnongchanView selectView(Wrapper<YudingnongchanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
