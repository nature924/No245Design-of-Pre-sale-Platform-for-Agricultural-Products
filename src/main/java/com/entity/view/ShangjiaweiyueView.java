package com.entity.view;

import com.entity.ShangjiaweiyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 商家违约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
@TableName("shangjiaweiyue")
public class ShangjiaweiyueView  extends ShangjiaweiyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShangjiaweiyueView(){
	}
 
 	public ShangjiaweiyueView(ShangjiaweiyueEntity shangjiaweiyueEntity){
 	try {
			BeanUtils.copyProperties(this, shangjiaweiyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
