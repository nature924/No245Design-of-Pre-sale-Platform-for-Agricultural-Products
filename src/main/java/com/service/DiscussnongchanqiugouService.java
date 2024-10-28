package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussnongchanqiugouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussnongchanqiugouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussnongchanqiugouView;


/**
 * 农产求购评论表
 *
 * @author 
 * @email 
 * @date 2023-02-28 15:58:18
 */
public interface DiscussnongchanqiugouService extends IService<DiscussnongchanqiugouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussnongchanqiugouVO> selectListVO(Wrapper<DiscussnongchanqiugouEntity> wrapper);
   	
   	DiscussnongchanqiugouVO selectVO(@Param("ew") Wrapper<DiscussnongchanqiugouEntity> wrapper);
   	
   	List<DiscussnongchanqiugouView> selectListView(Wrapper<DiscussnongchanqiugouEntity> wrapper);
   	
   	DiscussnongchanqiugouView selectView(@Param("ew") Wrapper<DiscussnongchanqiugouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussnongchanqiugouEntity> wrapper);
   	

}

