package com.dao;

import com.entity.YushouweikuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YushouweikuanVO;
import com.entity.view.YushouweikuanView;


/**
 * 预售尾款
 * 
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface YushouweikuanDao extends BaseMapper<YushouweikuanEntity> {
	
	List<YushouweikuanVO> selectListVO(@Param("ew") Wrapper<YushouweikuanEntity> wrapper);
	
	YushouweikuanVO selectVO(@Param("ew") Wrapper<YushouweikuanEntity> wrapper);
	
	List<YushouweikuanView> selectListView(@Param("ew") Wrapper<YushouweikuanEntity> wrapper);

	List<YushouweikuanView> selectListView(Pagination page,@Param("ew") Wrapper<YushouweikuanEntity> wrapper);
	
	YushouweikuanView selectView(@Param("ew") Wrapper<YushouweikuanEntity> wrapper);
	

}
