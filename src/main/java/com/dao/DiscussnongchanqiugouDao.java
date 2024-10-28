package com.dao;

import com.entity.DiscussnongchanqiugouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussnongchanqiugouVO;
import com.entity.view.DiscussnongchanqiugouView;


/**
 * 农产求购评论表
 * 
 * @author 
 * @email 
 * @date 2023-02-28 15:58:18
 */
public interface DiscussnongchanqiugouDao extends BaseMapper<DiscussnongchanqiugouEntity> {
	
	List<DiscussnongchanqiugouVO> selectListVO(@Param("ew") Wrapper<DiscussnongchanqiugouEntity> wrapper);
	
	DiscussnongchanqiugouVO selectVO(@Param("ew") Wrapper<DiscussnongchanqiugouEntity> wrapper);
	
	List<DiscussnongchanqiugouView> selectListView(@Param("ew") Wrapper<DiscussnongchanqiugouEntity> wrapper);

	List<DiscussnongchanqiugouView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussnongchanqiugouEntity> wrapper);
	
	DiscussnongchanqiugouView selectView(@Param("ew") Wrapper<DiscussnongchanqiugouEntity> wrapper);
	

}
