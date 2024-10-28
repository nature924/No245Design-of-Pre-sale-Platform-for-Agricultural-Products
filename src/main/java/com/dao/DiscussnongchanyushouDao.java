package com.dao;

import com.entity.DiscussnongchanyushouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussnongchanyushouVO;
import com.entity.view.DiscussnongchanyushouView;


/**
 * 农产预售评论表
 * 
 * @author 
 * @email 
 * @date 2023-02-28 15:58:18
 */
public interface DiscussnongchanyushouDao extends BaseMapper<DiscussnongchanyushouEntity> {
	
	List<DiscussnongchanyushouVO> selectListVO(@Param("ew") Wrapper<DiscussnongchanyushouEntity> wrapper);
	
	DiscussnongchanyushouVO selectVO(@Param("ew") Wrapper<DiscussnongchanyushouEntity> wrapper);
	
	List<DiscussnongchanyushouView> selectListView(@Param("ew") Wrapper<DiscussnongchanyushouEntity> wrapper);

	List<DiscussnongchanyushouView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussnongchanyushouEntity> wrapper);
	
	DiscussnongchanyushouView selectView(@Param("ew") Wrapper<DiscussnongchanyushouEntity> wrapper);
	

}
