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


import com.dao.QiugouweikuanDao;
import com.entity.QiugouweikuanEntity;
import com.service.QiugouweikuanService;
import com.entity.vo.QiugouweikuanVO;
import com.entity.view.QiugouweikuanView;

@Service("qiugouweikuanService")
public class QiugouweikuanServiceImpl extends ServiceImpl<QiugouweikuanDao, QiugouweikuanEntity> implements QiugouweikuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QiugouweikuanEntity> page = this.selectPage(
                new Query<QiugouweikuanEntity>(params).getPage(),
                new EntityWrapper<QiugouweikuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QiugouweikuanEntity> wrapper) {
		  Page<QiugouweikuanView> page =new Query<QiugouweikuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QiugouweikuanVO> selectListVO(Wrapper<QiugouweikuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QiugouweikuanVO selectVO(Wrapper<QiugouweikuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QiugouweikuanView> selectListView(Wrapper<QiugouweikuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QiugouweikuanView selectView(Wrapper<QiugouweikuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
