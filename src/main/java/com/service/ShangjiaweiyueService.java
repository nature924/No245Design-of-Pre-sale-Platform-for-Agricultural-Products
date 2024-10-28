package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShangjiaweiyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShangjiaweiyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangjiaweiyueView;


/**
 * 商家违约
 *
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface ShangjiaweiyueService extends IService<ShangjiaweiyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShangjiaweiyueVO> selectListVO(Wrapper<ShangjiaweiyueEntity> wrapper);
   	
   	ShangjiaweiyueVO selectVO(@Param("ew") Wrapper<ShangjiaweiyueEntity> wrapper);
   	
   	List<ShangjiaweiyueView> selectListView(Wrapper<ShangjiaweiyueEntity> wrapper);
   	
   	ShangjiaweiyueView selectView(@Param("ew") Wrapper<ShangjiaweiyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShangjiaweiyueEntity> wrapper);
   	

}

