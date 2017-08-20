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
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 用户基本资料
 * @author onlineGenerator
 * @date 2016-10-11 23:59:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_user_info", schema = "")
@SuppressWarnings("serial")
public class EweUserInfoEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**用户id*/
	@Excel(name="用户id")
	private java.lang.Integer userid;
	/**真实姓名*/
	@Excel(name="真实姓名")
	private java.lang.String realname;
	/**身份证号*/
	@Excel(name="身份证号")
	private java.lang.String idcardno;
	/**性别*/
	@Excel(name="性别")
	private java.lang.String sex;
	/**联系地址*/
	@Excel(name="联系地址")
	private java.lang.String contactaddress;
	/**手机号码*/
	@Excel(name="手机号码")
	private java.lang.String mobile;
	/**用户邮箱*/
	@Excel(name="用户邮箱")
	private java.lang.String email;
	/**微信号*/
	@Excel(name="微信号")
	private java.lang.String weixinumber;
	/**QQ号*/
	@Excel(name="QQ号")
	private java.lang.String qqnumber;
	/**支付宝*/
	@Excel(name="支付宝")
	private java.lang.String zfbnumber;
	/**财付通*/
	@Excel(name="财付通")
	private java.lang.String cftnumber;
	/**开户银行*/
	@Excel(name="开户银行")
	private java.lang.String bankname;
	/**开户省份*/
	@Excel(name="开户省份")
	private java.lang.String province;
	/**开户市区*/
	@Excel(name="开户市区")
	private java.lang.String city;
	/**银行支行*/
	@Excel(name="银行支行")
	private java.lang.String banksubbranch;
	/**银行账号*/
	@Excel(name="银行账号")
	private java.lang.String bankaccount;
	/**开户姓名*/
	@Excel(name="开户姓名")
	private java.lang.String openaccount;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID",nullable=false,length=19)
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
	 *@return: java.lang.Integer  用户id
	 */
	@Column(name ="USERID",nullable=false,length=19)
	public java.lang.Integer getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  用户id
	 */
	public void setUserid(java.lang.Integer userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  真实姓名
	 */
	@Column(name ="REALNAME",nullable=true,length=50)
	public java.lang.String getRealname(){
		return this.realname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  真实姓名
	 */
	public void setRealname(java.lang.String realname){
		this.realname = realname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="IDCARDNO",nullable=true,length=25)
	public java.lang.String getIdcardno(){
		return this.idcardno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdcardno(java.lang.String idcardno){
		this.idcardno = idcardno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="SEX",nullable=true,length=10)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系地址
	 */
	@Column(name ="CONTACTADDRESS",nullable=true,length=200)
	public java.lang.String getContactaddress(){
		return this.contactaddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系地址
	 */
	public void setContactaddress(java.lang.String contactaddress){
		this.contactaddress = contactaddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号码
	 */
	@Column(name ="MOBILE",nullable=true,length=20)
	public java.lang.String getMobile(){
		return this.mobile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号码
	 */
	public void setMobile(java.lang.String mobile){
		this.mobile = mobile;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户邮箱
	 */
	@Column(name ="EMAIL",nullable=true,length=50)
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户邮箱
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信号
	 */
	@Column(name ="WEIXINUMBER",nullable=true,length=20)
	public java.lang.String getWeixinumber(){
		return this.weixinumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信号
	 */
	public void setWeixinumber(java.lang.String weixinumber){
		this.weixinumber = weixinumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  QQ号
	 */
	@Column(name ="QQNUMBER",nullable=true,length=20)
	public java.lang.String getQqnumber(){
		return this.qqnumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  QQ号
	 */
	public void setQqnumber(java.lang.String qqnumber){
		this.qqnumber = qqnumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付宝
	 */
	@Column(name ="ZFBNUMBER",nullable=true,length=30)
	public java.lang.String getZfbnumber(){
		return this.zfbnumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付宝
	 */
	public void setZfbnumber(java.lang.String zfbnumber){
		this.zfbnumber = zfbnumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  财付通
	 */
	@Column(name ="CFTNUMBER",nullable=true,length=30)
	public java.lang.String getCftnumber(){
		return this.cftnumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  财付通
	 */
	public void setCftnumber(java.lang.String cftnumber){
		this.cftnumber = cftnumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户银行
	 */
	@Column(name ="BANKNAME",nullable=true,length=100)
	public java.lang.String getBankname(){
		return this.bankname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户银行
	 */
	public void setBankname(java.lang.String bankname){
		this.bankname = bankname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户省份
	 */
	@Column(name ="PROVINCE",nullable=true,length=50)
	public java.lang.String getProvince(){
		return this.province;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户省份
	 */
	public void setProvince(java.lang.String province){
		this.province = province;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户市区
	 */
	@Column(name ="CITY",nullable=true,length=50)
	public java.lang.String getCity(){
		return this.city;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户市区
	 */
	public void setCity(java.lang.String city){
		this.city = city;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  银行支行
	 */
	@Column(name ="BANKSUBBRANCH",nullable=true,length=100)
	public java.lang.String getBanksubbranch(){
		return this.banksubbranch;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  银行支行
	 */
	public void setBanksubbranch(java.lang.String banksubbranch){
		this.banksubbranch = banksubbranch;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  银行账号
	 */
	@Column(name ="BANKACCOUNT",nullable=true,length=50)
	public java.lang.String getBankaccount(){
		return this.bankaccount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  银行账号
	 */
	public void setBankaccount(java.lang.String bankaccount){
		this.bankaccount = bankaccount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户姓名
	 */
	@Column(name ="OPENACCOUNT",nullable=true,length=20)
	public java.lang.String getOpenaccount(){
		return this.openaccount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户姓名
	 */
	public void setOpenaccount(java.lang.String openaccount){
		this.openaccount = openaccount;
	}
}
