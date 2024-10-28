package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NongchanqiugouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NongchanqiugouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NongchanqiugouView;


/**
 * 农产求购
 *
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface NongchanqiugouService extends IService<NongchanqiugouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongchanqiugouVO> selectListVO(Wrapper<NongchanqiugouEntity> wrapper);
   	
   	NongchanqiugouVO selectVO(@Param("ew") Wrapper<NongchanqiugouEntity> wrapper);
   	
   	List<NongchanqiugouView> selectListView(Wrapper<NongchanqiugouEntity> wrapper);
   	
   	NongchanqiugouView selectView(@Param("ew") Wrapper<NongchanqiugouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongchanqiugouEntity> wrapper);
   	

}

