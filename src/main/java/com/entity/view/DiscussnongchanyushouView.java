package com.entity.view;

import com.entity.DiscussnongchanyushouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 农产预售评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-28 15:58:18
 */
@TableName("discussnongchanyushou")
public class DiscussnongchanyushouView  extends DiscussnongchanyushouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussnongchanyushouView(){
	}
 
 	public DiscussnongchanyushouView(DiscussnongchanyushouEntity discussnongchanyushouEntity){
 	try {
			BeanUtils.copyProperties(this, discussnongchanyushouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
