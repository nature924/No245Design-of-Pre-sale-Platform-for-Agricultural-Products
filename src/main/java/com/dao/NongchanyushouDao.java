package com.dao;

import com.entity.NongchanyushouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NongchanyushouVO;
import com.entity.view.NongchanyushouView;


/**
 * 农产预售
 * 
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface NongchanyushouDao extends BaseMapper<NongchanyushouEntity> {
	
	List<NongchanyushouVO> selectListVO(@Param("ew") Wrapper<NongchanyushouEntity> wrapper);
	
	NongchanyushouVO selectVO(@Param("ew") Wrapper<NongchanyushouEntity> wrapper);
	
	List<NongchanyushouView> selectListView(@Param("ew") Wrapper<NongchanyushouEntity> wrapper);

	List<NongchanyushouView> selectListView(Pagination page,@Param("ew") Wrapper<NongchanyushouEntity> wrapper);
	
	NongchanyushouView selectView(@Param("ew") Wrapper<NongchanyushouEntity> wrapper);
	

}
