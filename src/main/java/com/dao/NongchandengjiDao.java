package com.dao;

import com.entity.NongchandengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NongchandengjiVO;
import com.entity.view.NongchandengjiView;


/**
 * 农产登记
 * 
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface NongchandengjiDao extends BaseMapper<NongchandengjiEntity> {
	
	List<NongchandengjiVO> selectListVO(@Param("ew") Wrapper<NongchandengjiEntity> wrapper);
	
	NongchandengjiVO selectVO(@Param("ew") Wrapper<NongchandengjiEntity> wrapper);
	
	List<NongchandengjiView> selectListView(@Param("ew") Wrapper<NongchandengjiEntity> wrapper);

	List<NongchandengjiView> selectListView(Pagination page,@Param("ew") Wrapper<NongchandengjiEntity> wrapper);
	
	NongchandengjiView selectView(@Param("ew") Wrapper<NongchandengjiEntity> wrapper);
	

}
