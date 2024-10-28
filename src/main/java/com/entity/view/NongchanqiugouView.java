package com.entity.view;

import com.entity.NongchanqiugouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 农产求购
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
@TableName("nongchanqiugou")
public class NongchanqiugouView  extends NongchanqiugouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public NongchanqiugouView(){
	}
 
 	public NongchanqiugouView(NongchanqiugouEntity nongchanqiugouEntity){
 	try {
			BeanUtils.copyProperties(this, nongchanqiugouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
