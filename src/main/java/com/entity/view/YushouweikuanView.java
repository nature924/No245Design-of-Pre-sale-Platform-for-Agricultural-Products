package com.entity.view;

import com.entity.YushouweikuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 预售尾款
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
@TableName("yushouweikuan")
public class YushouweikuanView  extends YushouweikuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YushouweikuanView(){
	}
 
 	public YushouweikuanView(YushouweikuanEntity yushouweikuanEntity){
 	try {
			BeanUtils.copyProperties(this, yushouweikuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
