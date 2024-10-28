package com.entity.view;

import com.entity.NonghuweiyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 农户违约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
@TableName("nonghuweiyue")
public class NonghuweiyueView  extends NonghuweiyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public NonghuweiyueView(){
	}
 
 	public NonghuweiyueView(NonghuweiyueEntity nonghuweiyueEntity){
 	try {
			BeanUtils.copyProperties(this, nonghuweiyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
