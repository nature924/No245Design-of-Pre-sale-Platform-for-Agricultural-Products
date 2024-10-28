package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YudingnongchanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YudingnongchanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YudingnongchanView;


/**
 * 预订农产
 *
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface YudingnongchanService extends IService<YudingnongchanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YudingnongchanVO> selectListVO(Wrapper<YudingnongchanEntity> wrapper);
   	
   	YudingnongchanVO selectVO(@Param("ew") Wrapper<YudingnongchanEntity> wrapper);
   	
   	List<YudingnongchanView> selectListView(Wrapper<YudingnongchanEntity> wrapper);
   	
   	YudingnongchanView selectView(@Param("ew") Wrapper<YudingnongchanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YudingnongchanEntity> wrapper);
   	

}

