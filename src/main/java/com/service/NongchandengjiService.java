package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NongchandengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NongchandengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NongchandengjiView;


/**
 * 农产登记
 *
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface NongchandengjiService extends IService<NongchandengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongchandengjiVO> selectListVO(Wrapper<NongchandengjiEntity> wrapper);
   	
   	NongchandengjiVO selectVO(@Param("ew") Wrapper<NongchandengjiEntity> wrapper);
   	
   	List<NongchandengjiView> selectListView(Wrapper<NongchandengjiEntity> wrapper);
   	
   	NongchandengjiView selectView(@Param("ew") Wrapper<NongchandengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongchandengjiEntity> wrapper);
   	

}

