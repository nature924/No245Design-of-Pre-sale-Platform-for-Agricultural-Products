package com.dao;

import com.entity.NongchanqiugouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NongchanqiugouVO;
import com.entity.view.NongchanqiugouView;


/**
 * 农产求购
 * 
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface NongchanqiugouDao extends BaseMapper<NongchanqiugouEntity> {
	
	List<NongchanqiugouVO> selectListVO(@Param("ew") Wrapper<NongchanqiugouEntity> wrapper);
	
	NongchanqiugouVO selectVO(@Param("ew") Wrapper<NongchanqiugouEntity> wrapper);
	
	List<NongchanqiugouView> selectListView(@Param("ew") Wrapper<NongchanqiugouEntity> wrapper);

	List<NongchanqiugouView> selectListView(Pagination page,@Param("ew") Wrapper<NongchanqiugouEntity> wrapper);
	
	NongchanqiugouView selectView(@Param("ew") Wrapper<NongchanqiugouEntity> wrapper);
	

}
