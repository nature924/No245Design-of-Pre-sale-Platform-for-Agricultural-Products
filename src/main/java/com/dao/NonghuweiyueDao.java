package com.dao;

import com.entity.NonghuweiyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NonghuweiyueVO;
import com.entity.view.NonghuweiyueView;


/**
 * 农户违约
 * 
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface NonghuweiyueDao extends BaseMapper<NonghuweiyueEntity> {
	
	List<NonghuweiyueVO> selectListVO(@Param("ew") Wrapper<NonghuweiyueEntity> wrapper);
	
	NonghuweiyueVO selectVO(@Param("ew") Wrapper<NonghuweiyueEntity> wrapper);
	
	List<NonghuweiyueView> selectListView(@Param("ew") Wrapper<NonghuweiyueEntity> wrapper);

	List<NonghuweiyueView> selectListView(Pagination page,@Param("ew") Wrapper<NonghuweiyueEntity> wrapper);
	
	NonghuweiyueView selectView(@Param("ew") Wrapper<NonghuweiyueEntity> wrapper);
	

}
