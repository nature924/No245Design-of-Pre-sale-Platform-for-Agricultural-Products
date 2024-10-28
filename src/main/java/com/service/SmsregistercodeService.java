package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.SmsregistercodeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.SmsregistercodeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.SmsregistercodeView;


/**
 * 短信验证码
 *
 * @author 
 * @email 
 * @date 2023-02-28 15:58:18
 */
public interface SmsregistercodeService extends IService<SmsregistercodeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SmsregistercodeVO> selectListVO(Wrapper<SmsregistercodeEntity> wrapper);
   	
   	SmsregistercodeVO selectVO(@Param("ew") Wrapper<SmsregistercodeEntity> wrapper);
   	
   	List<SmsregistercodeView> selectListView(Wrapper<SmsregistercodeEntity> wrapper);
   	
   	SmsregistercodeView selectView(@Param("ew") Wrapper<SmsregistercodeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SmsregistercodeEntity> wrapper);
   	

}

