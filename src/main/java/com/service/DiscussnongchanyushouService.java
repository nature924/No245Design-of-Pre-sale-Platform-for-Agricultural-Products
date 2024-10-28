package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussnongchanyushouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussnongchanyushouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussnongchanyushouView;


/**
 * 农产预售评论表
 *
 * @author 
 * @email 
 * @date 2023-02-28 15:58:18
 */
public interface DiscussnongchanyushouService extends IService<DiscussnongchanyushouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussnongchanyushouVO> selectListVO(Wrapper<DiscussnongchanyushouEntity> wrapper);
   	
   	DiscussnongchanyushouVO selectVO(@Param("ew") Wrapper<DiscussnongchanyushouEntity> wrapper);
   	
   	List<DiscussnongchanyushouView> selectListView(Wrapper<DiscussnongchanyushouEntity> wrapper);
   	
   	DiscussnongchanyushouView selectView(@Param("ew") Wrapper<DiscussnongchanyushouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussnongchanyushouEntity> wrapper);
   	

}

