package com.dao;

import com.entity.YudingnongchanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YudingnongchanVO;
import com.entity.view.YudingnongchanView;


/**
 * 预订农产
 * 
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface YudingnongchanDao extends BaseMapper<YudingnongchanEntity> {
	
	List<YudingnongchanVO> selectListVO(@Param("ew") Wrapper<YudingnongchanEntity> wrapper);
	
	YudingnongchanVO selectVO(@Param("ew") Wrapper<YudingnongchanEntity> wrapper);
	
	List<YudingnongchanView> selectListView(@Param("ew") Wrapper<YudingnongchanEntity> wrapper);

	List<YudingnongchanView> selectListView(Pagination page,@Param("ew") Wrapper<YudingnongchanEntity> wrapper);
	
	YudingnongchanView selectView(@Param("ew") Wrapper<YudingnongchanEntity> wrapper);
	

}
