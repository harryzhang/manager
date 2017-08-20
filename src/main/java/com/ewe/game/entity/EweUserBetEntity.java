package com.ewe.game.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 竞猜下注列表
 * @author onlineGenerator
 * @date 2016-10-12 19:51:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_user_bet", schema = "")
@SuppressWarnings("serial")
public class EweUserBetEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**用户ID*/
	@Excel(name="用户ID")
	private java.lang.Integer userid;
	/**期数*/
	@Excel(name="期数")
	private java.lang.Integer periods;
	/**投注时间*/
	@Excel(name="投注时间",format = "yyyy-MM-dd")
	private java.util.Date bettime;
	/**投注金额*/
	@Excel(name="投注金额")
	private java.math.BigDecimal amount;
	/**状态*/
	@Excel(name="状态")
	private java.lang.String status;
	/**投注号码*/
	@Excel(name="投注号码")
	private java.lang.String betnumber;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID",nullable=false,length=10)
	public java.lang.Integer getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  id
	 */
	public void setId(java.lang.Integer id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  用户ID
	 */
	@Column(name ="USERID",nullable=true,length=10)
	public java.lang.Integer getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  用户ID
	 */
	public void setUserid(java.lang.Integer userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  期数
	 */
	@Column(name ="PERIODS",nullable=true,length=10)
	public java.lang.Integer getPeriods(){
		return this.periods;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  期数
	 */
	public void setPeriods(java.lang.Integer periods){
		this.periods = periods;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  投注时间
	 */
	@Column(name ="BETTIME",nullable=true)
	public java.util.Date getBettime(){
		return this.bettime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  投注时间
	 */
	public void setBettime(java.util.Date bettime){
		this.bettime = bettime;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  投注金额
	 */
	@Column(name ="AMOUNT",nullable=true,scale=2,length=12)
	public java.math.BigDecimal getAmount(){
		return this.amount;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  投注金额
	 */
	public void setAmount(java.math.BigDecimal amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	@Column(name ="STATUS",nullable=true,length=10)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投注号码
	 */
	@Column(name ="BETNUMBER",nullable=true,length=30)
	public java.lang.String getBetnumber(){
		return this.betnumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投注号码
	 */
	public void setBetnumber(java.lang.String betnumber){
		this.betnumber = betnumber;
	}
}
