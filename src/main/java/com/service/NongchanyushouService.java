package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NongchanyushouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NongchanyushouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NongchanyushouView;


/**
 * 农产预售
 *
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface NongchanyushouService extends IService<NongchanyushouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongchanyushouVO> selectListVO(Wrapper<NongchanyushouEntity> wrapper);
   	
   	NongchanyushouVO selectVO(@Param("ew") Wrapper<NongchanyushouEntity> wrapper);
   	
   	List<NongchanyushouView> selectListView(Wrapper<NongchanyushouEntity> wrapper);
   	
   	NongchanyushouView selectView(@Param("ew") Wrapper<NongchanyushouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongchanyushouEntity> wrapper);
   	

}

