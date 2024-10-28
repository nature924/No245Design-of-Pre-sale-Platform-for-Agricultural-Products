package com.entity.view;

import com.entity.NongchandengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 农产登记
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
@TableName("nongchandengji")
public class NongchandengjiView  extends NongchandengjiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public NongchandengjiView(){
	}
 
 	public NongchandengjiView(NongchandengjiEntity nongchandengjiEntity){
 	try {
			BeanUtils.copyProperties(this, nongchandengjiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
