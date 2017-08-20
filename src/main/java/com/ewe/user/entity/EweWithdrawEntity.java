package com.ewe.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: Entity
 * @Description: 提现列表
 * @author onlineGenerator
 * @date 2016-11-07 14:54:21
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_withdraw", schema = "")
@SuppressWarnings("serial")
public class EweWithdrawEntity implements java.io.Serializable {
	/**提现ID*/
	private java.lang.Integer withdrawid;
	/**提现号*/
	@Excel(name="提现号")
	private java.lang.String withdrawcode;
	/**用户ID*/
//	private java.lang.Integer userid;
	private EweUserEntity user;
	/**提现金额*/
	@Excel(name="提现金额")
	private java.math.BigDecimal amount;
	/**提现手述费*/
	@Excel(name="提现手述费")
	private java.math.BigDecimal charge;
	/**支付金额*/
	@Excel(name="支付金额")
	private java.math.BigDecimal payamount;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private java.util.Date createtime;
	/**提现单状态*/
	@Excel(name="提现单状态")
	private java.lang.Integer withdrawstatus;
	/**付款状态*/
	@Excel(name="付款状态")
	private java.lang.Integer paystatus;
	/**提现确定时间*/
	@Excel(name="提现确定时间",format = "yyyy-MM-dd")
	private java.util.Date paytime;
	
	@Excel(name="用户名")
	private String name;
	@Excel(name="用户手机")
	private String userName;
	@Excel(name="用户支付定")
	private String zfb;
	@Excel(name="用户微信")
	private String weixin;
	
	private String bankUser;
	private String bankName;
	private String bankNo;
	
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  提现ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="WITHDRAWID",nullable=false,length=19)
	public java.lang.Integer getWithdrawid(){
		return this.withdrawid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  提现ID
	 */
	public void setWithdrawid(java.lang.Integer withdrawid){
		this.withdrawid = withdrawid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  提现号
	 */
	@Column(name ="WITHDRAWCODE",nullable=true,length=19)
	public java.lang.String getWithdrawcode(){
		return this.withdrawcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  提现号
	 */
	public void setWithdrawcode(java.lang.String withdrawcode){
		this.withdrawcode = withdrawcode;
	}
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="USERID",nullable=true)
	public EweUserEntity getUser() {
		return user;
	}

	public void setUser(EweUserEntity user) {
		this.user = user;
	}

	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  提现金额
	 */
	@Column(name ="AMOUNT",nullable=true,scale=2,length=12)
	public java.math.BigDecimal getAmount(){
		return this.amount;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  提现金额
	 */
	public void setAmount(java.math.BigDecimal amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  提现手述费
	 */
	@Column(name ="CHARGE",nullable=true,scale=2,length=12)
	public java.math.BigDecimal getCharge(){
		return this.charge;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  提现手述费
	 */
	public void setCharge(java.math.BigDecimal charge){
		this.charge = charge;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  支付金额
	 */
	@Column(name ="PAYAMOUNT",nullable=true,scale=2,length=12)
	public java.math.BigDecimal getPayamount(){
		return this.payamount;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  支付金额
	 */
	public void setPayamount(java.math.BigDecimal payamount){
		this.payamount = payamount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATETIME",nullable=true)
	public java.util.Date getCreatetime(){
		return this.createtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreatetime(java.util.Date createtime){
		this.createtime = createtime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  提现单状态
	 */
	@Column(name ="WITHDRAWSTATUS",nullable=true,length=10)
	public java.lang.Integer getWithdrawstatus(){
		return this.withdrawstatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  提现单状态
	 */
	public void setWithdrawstatus(java.lang.Integer withdrawstatus){
		this.withdrawstatus = withdrawstatus;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  付款状态
	 */
	@Column(name ="PAYSTATUS",nullable=true,length=10)
	public java.lang.Integer getPaystatus(){
		return this.paystatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  付款状态
	 */
	public void setPaystatus(java.lang.Integer paystatus){
		this.paystatus = paystatus;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  提现确定时间
	 */
	@Column(name ="PAYTIME",nullable=true)
	public java.util.Date getPaytime(){
		return this.paytime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  提现确定时间
	 */
	public void setPaytime(java.util.Date paytime){
		this.paytime = paytime;
	}

	@Transient
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Transient
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Transient
	public String getZfb() {
		return zfb;
	}

	public void setZfb(String zfb) {
		this.zfb = zfb;
	}

	@Transient
	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	@Column(name ="BANKUSER",nullable=true,length=100)
	public String getBankUser() {
		return bankUser;
	}

	public void setBankUser(String bankUser) {
		this.bankUser = bankUser;
	}

	@Column(name ="BANKNAME",nullable=true,length=100)
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name ="BANKNO",nullable=true,length=100)
	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	
	
	
}
