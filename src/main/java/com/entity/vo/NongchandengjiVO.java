package com.entity.vo;

import com.entity.NongchandengjiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 农产登记
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-02-28 15:58:17
 */
public class NongchandengjiVO  implements Serializable {
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
	 * 产品图片
	 */
	
	private String chanpintupian;
		
	/**
	 * 采摘日期
	 */
	
	private String caizhairiqi;
		
	/**
	 * 提供数量
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
	 * 规格
	 */
	
	private String guige;
		
	/**
	 * 保质期
	 */
	
	private String baozhiqi;
		
	/**
	 * 商家号
	 */
	
	private String shangjiahao;
		
	/**
	 * 商家名称
	 */
	
	private String shangjiamingcheng;
		
	/**
	 * 农户名
	 */
	
	private String nonghuming;
		
	/**
	 * 农户号
	 */
	
	private String nonghuhao;
		
	/**
	 * 联系方式
	 */
	
	private String lianxifangshi;
		
	/**
	 * 登记时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date dengjishijian;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
		
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
	 * 设置：提供数量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：提供数量
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
	 * 设置：农户名
	 */
	 
	public void setNonghuming(String nonghuming) {
		this.nonghuming = nonghuming;
	}
	
	/**
	 * 获取：农户名
	 */
	public String getNonghuming() {
		return nonghuming;
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
	 * 设置：联系方式
	 */
	 
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
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
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
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
