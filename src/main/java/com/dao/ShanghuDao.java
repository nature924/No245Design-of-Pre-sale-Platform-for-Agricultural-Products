package com.dao;

import com.entity.ShanghuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShanghuVO;
import com.entity.view.ShanghuView;


/**
 * 商户
 * 
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface ShanghuDao extends BaseMapper<ShanghuEntity> {
	
	List<ShanghuVO> selectListVO(@Param("ew") Wrapper<ShanghuEntity> wrapper);
	
	ShanghuVO selectVO(@Param("ew") Wrapper<ShanghuEntity> wrapper);
	
	List<ShanghuView> selectListView(@Param("ew") Wrapper<ShanghuEntity> wrapper);

	List<ShanghuView> selectListView(Pagination page,@Param("ew") Wrapper<ShanghuEntity> wrapper);
	
	ShanghuView selectView(@Param("ew") Wrapper<ShanghuEntity> wrapper);
	

}
