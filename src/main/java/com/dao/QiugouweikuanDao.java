package com.dao;

import com.entity.QiugouweikuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QiugouweikuanVO;
import com.entity.view.QiugouweikuanView;


/**
 * 求购尾款
 * 
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface QiugouweikuanDao extends BaseMapper<QiugouweikuanEntity> {
	
	List<QiugouweikuanVO> selectListVO(@Param("ew") Wrapper<QiugouweikuanEntity> wrapper);
	
	QiugouweikuanVO selectVO(@Param("ew") Wrapper<QiugouweikuanEntity> wrapper);
	
	List<QiugouweikuanView> selectListView(@Param("ew") Wrapper<QiugouweikuanEntity> wrapper);

	List<QiugouweikuanView> selectListView(Pagination page,@Param("ew") Wrapper<QiugouweikuanEntity> wrapper);
	
	QiugouweikuanView selectView(@Param("ew") Wrapper<QiugouweikuanEntity> wrapper);
	

}
