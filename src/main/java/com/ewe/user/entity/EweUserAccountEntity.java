package com.ewe.user.entity;

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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 用户账户
 * @author onlineGenerator
 * @date 2017-01-01 22:41:50
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_user_account", schema = "")
@SuppressWarnings("serial")
public class EweUserAccountEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**用户ID*/
	@Excel(name="用户ID")
//	private java.lang.Integer userid;
	private EweUserEntity user;
	/**帐户金额*/
	@Excel(name="帐户金额")
	private java.lang.String amount;
	/**账户类型*/
	@Excel(name="账户类型")
	private java.lang.String accounttype;
	/**累计支出金额*/
	@Excel(name="累计支出金额")
	private java.lang.String totalconsumeamount;
	/**累计收入金额*/
	@Excel(name="累计收入金额")
	private java.lang.String totalinocmeamount;
	/**冻结金额*/
	@Excel(name="冻结金额")
	private java.lang.String frozendeposit;
	/**当天收益金额*/
	@Excel(name="当天收益金额")
	private java.lang.String incomeamount;
	/**当天支出金额*/
	@Excel(name="当天支出金额")
	private java.lang.String consueamount;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private java.util.Date updatetime;
	/**累计提现金额*/
	@Excel(name="累计提现金额")
	private java.lang.String withdrawtotaldeposit;
	
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
	
	
	@OneToOne
	@JoinColumn(name ="USERID",nullable=false)
	public EweUserEntity getUser() {
		return user;
	}

	public void setUser(EweUserEntity user) {
		this.user = user;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  帐户金额
	 */
	@Column(name ="AMOUNT",nullable=true,length=12)
	public java.lang.String getAmount(){
		return this.amount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  帐户金额
	 */
	public void setAmount(java.lang.String amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账户类型
	 */
	@Column(name ="ACCOUNTTYPE",nullable=true,length=30)
	public java.lang.String getAccounttype(){
		return this.accounttype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账户类型
	 */
	public void setAccounttype(java.lang.String accounttype){
		this.accounttype = accounttype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  累计支出金额
	 */
	@Column(name ="TOTALCONSUMEAMOUNT",nullable=true,length=12)
	public java.lang.String getTotalconsumeamount(){
		return this.totalconsumeamount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  累计支出金额
	 */
	public void setTotalconsumeamount(java.lang.String totalconsumeamount){
		this.totalconsumeamount = totalconsumeamount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  累计收入金额
	 */
	@Column(name ="TOTALINOCMEAMOUNT",nullable=true,length=12)
	public java.lang.String getTotalinocmeamount(){
		return this.totalinocmeamount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  累计收入金额
	 */
	public void setTotalinocmeamount(java.lang.String totalinocmeamount){
		this.totalinocmeamount = totalinocmeamount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  冻结金额
	 */
	@Column(name ="FROZENDEPOSIT",nullable=true,length=12)
	public java.lang.String getFrozendeposit(){
		return this.frozendeposit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  冻结金额
	 */
	public void setFrozendeposit(java.lang.String frozendeposit){
		this.frozendeposit = frozendeposit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  当天收益金额
	 */
	@Column(name ="INCOMEAMOUNT",nullable=true,length=12)
	public java.lang.String getIncomeamount(){
		return this.incomeamount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  当天收益金额
	 */
	public void setIncomeamount(java.lang.String incomeamount){
		this.incomeamount = incomeamount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  当天支出金额
	 */
	@Column(name ="CONSUEAMOUNT",nullable=true,length=12)
	public java.lang.String getConsueamount(){
		return this.consueamount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  当天支出金额
	 */
	public void setConsueamount(java.lang.String consueamount){
		this.consueamount = consueamount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATETIME",nullable=true)
	public java.util.Date getUpdatetime(){
		return this.updatetime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdatetime(java.util.Date updatetime){
		this.updatetime = updatetime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  累计提现金额
	 */
	@Column(name ="WITHDRAWTOTALDEPOSIT",nullable=true,length=12)
	public java.lang.String getWithdrawtotaldeposit(){
		return this.withdrawtotaldeposit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  累计提现金额
	 */
	public void setWithdrawtotaldeposit(java.lang.String withdrawtotaldeposit){
		this.withdrawtotaldeposit = withdrawtotaldeposit;
	}
}
