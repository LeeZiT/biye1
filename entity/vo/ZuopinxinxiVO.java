package com.entity.vo;

import com.entity.ZuopinxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 作品信息
 * @author 
 * @email 
 * @date 2025-04-26 08:22:48
 */
public class ZuopinxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 作品名称
	 */
	
	private String zuopinmingcheng;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 作品文件
	 */
	
	private String zuopinwenjian;
		
	/**
	 * 作品简介
	 */
	
	private String zuopinjianjie;
		
	/**
	 * 作品详情
	 */
	
	private String zuopinxiangqing;
		
	/**
	 * 学号
	 */
	
	private String xuehao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 工号
	 */
	
	private String gonghao;
		
	/**
	 * 提交时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date tijiaoshijian;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：作品名称
	 */
	 
	public void setZuopinmingcheng(String zuopinmingcheng) {
		this.zuopinmingcheng = zuopinmingcheng;
	}
	
	/**
	 * 获取：作品名称
	 */
	public String getZuopinmingcheng() {
		return zuopinmingcheng;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：作品文件
	 */
	 
	public void setZuopinwenjian(String zuopinwenjian) {
		this.zuopinwenjian = zuopinwenjian;
	}
	
	/**
	 * 获取：作品文件
	 */
	public String getZuopinwenjian() {
		return zuopinwenjian;
	}
				
	
	/**
	 * 设置：作品简介
	 */
	 
	public void setZuopinjianjie(String zuopinjianjie) {
		this.zuopinjianjie = zuopinjianjie;
	}
	
	/**
	 * 获取：作品简介
	 */
	public String getZuopinjianjie() {
		return zuopinjianjie;
	}
				
	
	/**
	 * 设置：作品详情
	 */
	 
	public void setZuopinxiangqing(String zuopinxiangqing) {
		this.zuopinxiangqing = zuopinxiangqing;
	}
	
	/**
	 * 获取：作品详情
	 */
	public String getZuopinxiangqing() {
		return zuopinxiangqing;
	}
				
	
	/**
	 * 设置：学号
	 */
	 
	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}
	
	/**
	 * 获取：学号
	 */
	public String getXuehao() {
		return xuehao;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：工号
	 */
	 
	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}
	
	/**
	 * 获取：工号
	 */
	public String getGonghao() {
		return gonghao;
	}
				
	
	/**
	 * 设置：提交时间
	 */
	 
	public void setTijiaoshijian(Date tijiaoshijian) {
		this.tijiaoshijian = tijiaoshijian;
	}
	
	/**
	 * 获取：提交时间
	 */
	public Date getTijiaoshijian() {
		return tijiaoshijian;
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
			
}
