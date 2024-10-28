package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QiugouweikuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QiugouweikuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QiugouweikuanView;


/**
 * 求购尾款
 *
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface QiugouweikuanService extends IService<QiugouweikuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QiugouweikuanVO> selectListVO(Wrapper<QiugouweikuanEntity> wrapper);
   	
   	QiugouweikuanVO selectVO(@Param("ew") Wrapper<QiugouweikuanEntity> wrapper);
   	
   	List<QiugouweikuanView> selectListView(Wrapper<QiugouweikuanEntity> wrapper);
   	
   	QiugouweikuanView selectView(@Param("ew") Wrapper<QiugouweikuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QiugouweikuanEntity> wrapper);
   	

}

