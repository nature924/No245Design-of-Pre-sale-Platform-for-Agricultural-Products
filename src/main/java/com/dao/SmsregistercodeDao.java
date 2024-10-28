package com.dao;

import com.entity.SmsregistercodeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.SmsregistercodeVO;
import com.entity.view.SmsregistercodeView;


/**
 * 短信验证码
 * 
 * @author 
 * @email 
 * @date 2023-02-28 15:58:18
 */
public interface SmsregistercodeDao extends BaseMapper<SmsregistercodeEntity> {
	
	List<SmsregistercodeVO> selectListVO(@Param("ew") Wrapper<SmsregistercodeEntity> wrapper);
	
	SmsregistercodeVO selectVO(@Param("ew") Wrapper<SmsregistercodeEntity> wrapper);
	
	List<SmsregistercodeView> selectListView(@Param("ew") Wrapper<SmsregistercodeEntity> wrapper);

	List<SmsregistercodeView> selectListView(Pagination page,@Param("ew") Wrapper<SmsregistercodeEntity> wrapper);
	
	SmsregistercodeView selectView(@Param("ew") Wrapper<SmsregistercodeEntity> wrapper);
	

}
