package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YushouweikuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YushouweikuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YushouweikuanView;


/**
 * 预售尾款
 *
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface YushouweikuanService extends IService<YushouweikuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YushouweikuanVO> selectListVO(Wrapper<YushouweikuanEntity> wrapper);
   	
   	YushouweikuanVO selectVO(@Param("ew") Wrapper<YushouweikuanEntity> wrapper);
   	
   	List<YushouweikuanView> selectListView(Wrapper<YushouweikuanEntity> wrapper);
   	
   	YushouweikuanView selectView(@Param("ew") Wrapper<YushouweikuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YushouweikuanEntity> wrapper);
   	

}

