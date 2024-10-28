package com.dao;

import com.entity.ShangjiaweiyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShangjiaweiyueVO;
import com.entity.view.ShangjiaweiyueView;


/**
 * 商家违约
 * 
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface ShangjiaweiyueDao extends BaseMapper<ShangjiaweiyueEntity> {
	
	List<ShangjiaweiyueVO> selectListVO(@Param("ew") Wrapper<ShangjiaweiyueEntity> wrapper);
	
	ShangjiaweiyueVO selectVO(@Param("ew") Wrapper<ShangjiaweiyueEntity> wrapper);
	
	List<ShangjiaweiyueView> selectListView(@Param("ew") Wrapper<ShangjiaweiyueEntity> wrapper);

	List<ShangjiaweiyueView> selectListView(Pagination page,@Param("ew") Wrapper<ShangjiaweiyueEntity> wrapper);
	
	ShangjiaweiyueView selectView(@Param("ew") Wrapper<ShangjiaweiyueEntity> wrapper);
	

}
