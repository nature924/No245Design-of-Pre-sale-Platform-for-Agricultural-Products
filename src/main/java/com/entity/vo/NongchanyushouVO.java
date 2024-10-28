package com.entity.vo;

import com.entity.NongchanyushouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 农产预售
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public class NongchanyushouVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 产品类型
	 */
	
	private String chanpinleixing;
		
	/**
	 * 产品图片
	 */
	
	private String chanpintupian;
		
	/**
	 * 采摘日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date caizhairiqi;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 价格
	 */
	
	private Integer jiage;
		
	/**
	 * 规格
	 */
	
	private String guige;
		
	/**
	 * 违约说明
	 */
	
	private String weiyueshuoming;
		
	/**
	 * 保质期
	 */
	
	private String baozhiqi;
		
	/**
	 * 详情描述
	 */
	
	private String xiangqingmiaoshu;
		
	/**
	 * 农户号
	 */
	
	private String nonghuhao;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
				
	
	/**
	 * 设置：产品类型
	 */
	 
	public void setChanpinleixing(String chanpinleixing) {
		this.chanpinleixing = chanpinleixing;
	}
	
	/**
	 * 获取：产品类型
	 */
	public String getChanpinleixing() {
		return chanpinleixing;
	}
				
	
	/**
	 * 设置：产品图片
	 */
	 
	public void setChanpintupian(String chanpintupian) {
		this.chanpintupian = chanpintupian;
	}
	
	/**
	 * 获取：产品图片
	 */
	public String getChanpintupian() {
		return chanpintupian;
	}
				
	
	/**
	 * 设置：采摘日期
	 */
	 
	public void setCaizhairiqi(Date caizhairiqi) {
		this.caizhairiqi = caizhairiqi;
	}
	
	/**
	 * 获取：采摘日期
	 */
	public Date getCaizhairiqi() {
		return caizhairiqi;
	}
				
	
	/**
	 * 设置：数量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setJiage(Integer jiage) {
		this.jiage = jiage;
	}
	
	/**
	 * 获取：价格
	 */
	public Integer getJiage() {
		return jiage;
	}
				
	
	/**
	 * 设置：规格
	 */
	 
	public void setGuige(String guige) {
		this.guige = guige;
	}
	
	/**
	 * 获取：规格
	 */
	public String getGuige() {
		return guige;
	}
				
	
	/**
	 * 设置：违约说明
	 */
	 
	public void setWeiyueshuoming(String weiyueshuoming) {
		this.weiyueshuoming = weiyueshuoming;
	}
	
	/**
	 * 获取：违约说明
	 */
	public String getWeiyueshuoming() {
		return weiyueshuoming;
	}
				
	
	/**
	 * 设置：保质期
	 */
	 
	public void setBaozhiqi(String baozhiqi) {
		this.baozhiqi = baozhiqi;
	}
	
	/**
	 * 获取：保质期
	 */
	public String getBaozhiqi() {
		return baozhiqi;
	}
				
	
	/**
	 * 设置：详情描述
	 */
	 
	public void setXiangqingmiaoshu(String xiangqingmiaoshu) {
		this.xiangqingmiaoshu = xiangqingmiaoshu;
	}
	
	/**
	 * 获取：详情描述
	 */
	public String getXiangqingmiaoshu() {
		return xiangqingmiaoshu;
	}
				
	
	/**
	 * 设置：农户号
	 */
	 
	public void setNonghuhao(String nonghuhao) {
		this.nonghuhao = nonghuhao;
	}
	
	/**
	 * 获取：农户号
	 */
	public String getNonghuhao() {
		return nonghuhao;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
			
}
