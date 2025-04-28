package com.entity.model;

import com.entity.JingsaibaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 竞赛报名
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-04-26 08:22:47
 */
public class JingsaibaomingModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 竞赛类别
	 */
	
	private String jingsaileibie;
		
	/**
	 * 竞赛封面
	 */
	
	private String jingsaifengmian;
		
	/**
	 * 报名类型
	 */
	
	private String baomingleixing;
		
	/**
	 * 队伍名称
	 */
	
	private String duiwumingcheng;
		
	/**
	 * 报名资料
	 */
	
	private String baomingziliao;
		
	/**
	 * 报名说明
	 */
	
	private String baomingshuoming;
		
	/**
	 * 报名时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date baomingshijian;
		
	/**
	 * 学号
	 */
	
	private String xuehao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 手机
	 */
	
	private String shouji;
		
	/**
	 * 工号
	 */
	
	private String gonghao;
		
	/**
	 * 跨表用户id
	 */
	
	private Long crossuserid;
		
	/**
	 * 跨表主键id
	 */
	
	private Long crossrefid;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：竞赛类别
	 */
	 
	public void setJingsaileibie(String jingsaileibie) {
		this.jingsaileibie = jingsaileibie;
	}
	
	/**
	 * 获取：竞赛类别
	 */
	public String getJingsaileibie() {
		return jingsaileibie;
	}
				
	
	/**
	 * 设置：竞赛封面
	 */
	 
	public void setJingsaifengmian(String jingsaifengmian) {
		this.jingsaifengmian = jingsaifengmian;
	}
	
	/**
	 * 获取：竞赛封面
	 */
	public String getJingsaifengmian() {
		return jingsaifengmian;
	}
				
	
	/**
	 * 设置：报名类型
	 */
	 
	public void setBaomingleixing(String baomingleixing) {
		this.baomingleixing = baomingleixing;
	}
	
	/**
	 * 获取：报名类型
	 */
	public String getBaomingleixing() {
		return baomingleixing;
	}
				
	
	/**
	 * 设置：队伍名称
	 */
	 
	public void setDuiwumingcheng(String duiwumingcheng) {
		this.duiwumingcheng = duiwumingcheng;
	}
	
	/**
	 * 获取：队伍名称
	 */
	public String getDuiwumingcheng() {
		return duiwumingcheng;
	}
				
	
	/**
	 * 设置：报名资料
	 */
	 
	public void setBaomingziliao(String baomingziliao) {
		this.baomingziliao = baomingziliao;
	}
	
	/**
	 * 获取：报名资料
	 */
	public String getBaomingziliao() {
		return baomingziliao;
	}
				
	
	/**
	 * 设置：报名说明
	 */
	 
	public void setBaomingshuoming(String baomingshuoming) {
		this.baomingshuoming = baomingshuoming;
	}
	
	/**
	 * 获取：报名说明
	 */
	public String getBaomingshuoming() {
		return baomingshuoming;
	}
				
	
	/**
	 * 设置：报名时间
	 */
	 
	public void setBaomingshijian(Date baomingshijian) {
		this.baomingshijian = baomingshijian;
	}
	
	/**
	 * 获取：报名时间
	 */
	public Date getBaomingshijian() {
		return baomingshijian;
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
	 * 设置：手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
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
	 * 设置：跨表用户id
	 */
	 
	public void setCrossuserid(Long crossuserid) {
		this.crossuserid = crossuserid;
	}
	
	/**
	 * 获取：跨表用户id
	 */
	public Long getCrossuserid() {
		return crossuserid;
	}
				
	
	/**
	 * 设置：跨表主键id
	 */
	 
	public void setCrossrefid(Long crossrefid) {
		this.crossrefid = crossrefid;
	}
	
	/**
	 * 获取：跨表主键id
	 */
	public Long getCrossrefid() {
		return crossrefid;
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
