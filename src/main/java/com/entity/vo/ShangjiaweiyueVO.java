package com.entity.vo;

import com.entity.ShangjiaweiyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 商家违约
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public class ShangjiaweiyueVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 产品名称
	 */
	
	private String chanpinmingcheng;
		
	/**
	 * 产品类型
	 */
	
	private String chanpinleixing;
		
	/**
	 * 采摘日期
	 */
	
	private String caizhairiqi;
		
	/**
	 * 预订数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 价格
	 */
	
	private Integer jiage;
		
	/**
	 * 预付比例
	 */
	
	private Float yufubili;
		
	/**
	 * 预付款
	 */
	
	private Float yufukuan;
		
	/**
	 * 违约金额
	 */
	
	private String weiyuejine;
		
	/**
	 * 规格
	 */
	
	private String guige;
		
	/**
	 * 保质期
	 */
	
	private String baozhiqi;
		
	/**
	 * 农户号
	 */
	
	private String nonghuhao;
		
	/**
	 * 商家号
	 */
	
	private String shangjiahao;
		
	/**
	 * 商家名称
	 */
	
	private String shangjiamingcheng;
		
	/**
	 * 电话
	 */
	
	private String dianhua;
		
	/**
	 * 登记时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjishijian;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
	/**
	 * 设置：产品名称
	 */
	 
	public void setChanpinmingcheng(String chanpinmingcheng) {
		this.chanpinmingcheng = chanpinmingcheng;
	}
	
	/**
	 * 获取：产品名称
	 */
	public String getChanpinmingcheng() {
		return chanpinmingcheng;
	}
				
	
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
	 * 设置：采摘日期
	 */
	 
	public void setCaizhairiqi(String caizhairiqi) {
		this.caizhairiqi = caizhairiqi;
	}
	
	/**
	 * 获取：采摘日期
	 */
	public String getCaizhairiqi() {
		return caizhairiqi;
	}
				
	
	/**
	 * 设置：预订数量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：预订数量
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
	 * 设置：预付比例
	 */
	 
	public void setYufubili(Float yufubili) {
		this.yufubili = yufubili;
	}
	
	/**
	 * 获取：预付比例
	 */
	public Float getYufubili() {
		return yufubili;
	}
				
	
	/**
	 * 设置：预付款
	 */
	 
	public void setYufukuan(Float yufukuan) {
		this.yufukuan = yufukuan;
	}
	
	/**
	 * 获取：预付款
	 */
	public Float getYufukuan() {
		return yufukuan;
	}
				
	
	/**
	 * 设置：违约金额
	 */
	 
	public void setWeiyuejine(String weiyuejine) {
		this.weiyuejine = weiyuejine;
	}
	
	/**
	 * 获取：违约金额
	 */
	public String getWeiyuejine() {
		return weiyuejine;
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
	 * 设置：商家号
	 */
	 
	public void setShangjiahao(String shangjiahao) {
		this.shangjiahao = shangjiahao;
	}
	
	/**
	 * 获取：商家号
	 */
	public String getShangjiahao() {
		return shangjiahao;
	}
				
	
	/**
	 * 设置：商家名称
	 */
	 
	public void setShangjiamingcheng(String shangjiamingcheng) {
		this.shangjiamingcheng = shangjiamingcheng;
	}
	
	/**
	 * 获取：商家名称
	 */
	public String getShangjiamingcheng() {
		return shangjiamingcheng;
	}
				
	
	/**
	 * 设置：电话
	 */
	 
	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}
	
	/**
	 * 获取：电话
	 */
	public String getDianhua() {
		return dianhua;
	}
				
	
	/**
	 * 设置：登记时间
	 */
	 
	public void setDengjishijian(Date dengjishijian) {
		this.dengjishijian = dengjishijian;
	}
	
	/**
	 * 获取：登记时间
	 */
	public Date getDengjishijian() {
		return dengjishijian;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
