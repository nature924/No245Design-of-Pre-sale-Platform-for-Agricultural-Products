package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NonghuweiyueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NonghuweiyueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NonghuweiyueView;


/**
 * 农户违约
 *
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public interface NonghuweiyueService extends IService<NonghuweiyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NonghuweiyueVO> selectListVO(Wrapper<NonghuweiyueEntity> wrapper);
   	
   	NonghuweiyueVO selectVO(@Param("ew") Wrapper<NonghuweiyueEntity> wrapper);
   	
   	List<NonghuweiyueView> selectListView(Wrapper<NonghuweiyueEntity> wrapper);
   	
   	NonghuweiyueView selectView(@Param("ew") Wrapper<NonghuweiyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NonghuweiyueEntity> wrapper);
   	

}

