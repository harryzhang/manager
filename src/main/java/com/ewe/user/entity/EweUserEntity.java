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
import javax.persistence.FetchType;
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
 * @Description: 用户列表
 * @author onlineGenerator
 * @date 2016-10-11 23:44:05
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_user", schema = "")
@SuppressWarnings("serial")
public class EweUserEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**用户名*/
	@Excel(name="用户名")
	private java.lang.String username;
	/**用户密码*/
	@Excel(name="用户密码")
	private java.lang.String password;
	/**二级密码*/
	@Excel(name="二级密码")
	private java.lang.String passwordtwo;
	/**当前等级*/
	@Excel(name="当前等级")
	private java.lang.Integer grade;
	/**组织机构*/
	@Excel(name="组织机构")
	private java.lang.String organ;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String remark;
	/**状态*/
	@Excel(name="状态")
	private java.lang.String enabled;
	/**推荐人编号*/
	@Excel(name="推荐人编号")
	private java.lang.Integer referrerid;
	/**接点人编号*/
	@Excel(name="接点人编号")
	private java.lang.Integer parentid;
	/**业务方向*/
	@Excel(name="业务方向")
	private java.lang.String treenode;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private java.util.Date creatortime;
	/**修改时间*/
	@Excel(name="修改时间",format = "yyyy-MM-dd")
	private java.util.Date updatetime;
	/**name*/
	@Excel(name="name")
	private java.lang.String name;
	/**积分*/
	@Excel(name="积分")
	private java.lang.String bonus;
	/**status*/
	@Excel(name="status")
	private java.lang.Integer status;
	/**joinmoney*/
	@Excel(name="joinmoney")
	private java.lang.String joinmoney;
	/**optuserid*/
	@Excel(name="optuserid")
	private java.lang.Integer optuserid;
	/**isbackmoney*/
	@Excel(name="isbackmoney")
	private java.lang.String isbackmoney;
	/**optremark*/
	@Excel(name="optremark")
	private java.lang.String optremark;
	/**iszengsong*/
	@Excel(name="iszengsong")
	private java.lang.String iszengsong;
	/**weixin*/
	@Excel(name="weixin")
	private java.lang.String weixin;
	/**zhifubao*/
	@Excel(name="zhifubao")
	private java.lang.String zhifubao;
	/**usercode*/
	@Excel(name="usercode")
	private java.lang.String usercode;
	/**openid*/
	@Excel(name="openid")
	private java.lang.String openid;
	
	private EweUserInfoEntity userInfo;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户名
	 */
	@Column(name ="USERNAME",nullable=true,length=50)
	public java.lang.String getUsername(){
		return this.username;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户名
	 */
	public void setUsername(java.lang.String username){
		this.username = username;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户密码
	 */
	@Column(name ="PASSWORD",nullable=true,length=50)
	public java.lang.String getPassword(){
		return this.password;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户密码
	 */
	public void setPassword(java.lang.String password){
		this.password = password;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  二级密码
	 */
	@Column(name ="PASSWORDTWO",nullable=true,length=50)
	public java.lang.String getPasswordtwo(){
		return this.passwordtwo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  二级密码
	 */
	public void setPasswordtwo(java.lang.String passwordtwo){
		this.passwordtwo = passwordtwo;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  当前等级
	 */
	@Column(name ="GRADE",nullable=true,length=19)
	public java.lang.Integer getGrade(){
		return this.grade;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  当前等级
	 */
	public void setGrade(java.lang.Integer grade){
		this.grade = grade;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组织机构
	 */
	@Column(name ="ORGAN",nullable=true,length=10)
	public java.lang.String getOrgan(){
		return this.organ;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组织机构
	 */
	public void setOrgan(java.lang.String organ){
		this.organ = organ;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=100)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	@Column(name ="ENABLED",nullable=true,length=10)
	public java.lang.String getEnabled(){
		return this.enabled;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setEnabled(java.lang.String enabled){
		this.enabled = enabled;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  推荐人编号
	 */
	@Column(name ="REFERRERID",nullable=true,length=19)
	public java.lang.Integer getReferrerid(){
		return this.referrerid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  推荐人编号
	 */
	public void setReferrerid(java.lang.Integer referrerid){
		this.referrerid = referrerid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  接点人编号
	 */
	@Column(name ="PARENTID",nullable=true,length=19)
	public java.lang.Integer getParentid(){
		return this.parentid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  接点人编号
	 */
	public void setParentid(java.lang.Integer parentid){
		this.parentid = parentid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务方向
	 */
	@Column(name ="TREENODE",nullable=true,length=20)
	public java.lang.String getTreenode(){
		return this.treenode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务方向
	 */
	public void setTreenode(java.lang.String treenode){
		this.treenode = treenode;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATORTIME",nullable=true)
	public java.util.Date getCreatortime(){
		return this.creatortime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreatortime(java.util.Date creatortime){
		this.creatortime = creatortime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  修改时间
	 */
	@Column(name ="UPDATETIME",nullable=true)
	public java.util.Date getUpdatetime(){
		return this.updatetime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
	 */
	public void setUpdatetime(java.util.Date updatetime){
		this.updatetime = updatetime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  name
	 */
	@Column(name ="NAME",nullable=true,length=50)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  name
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  积分
	 */
	@Column(name ="BONUS",nullable=true,length=12)
	public java.lang.String getBonus(){
		return this.bonus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  积分
	 */
	public void setBonus(java.lang.String bonus){
		this.bonus = bonus;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  status
	 */
	@Column(name ="STATUS",nullable=true,length=10)
	public java.lang.Integer getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  status
	 */
	public void setStatus(java.lang.Integer status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  joinmoney
	 */
	@Column(name ="JOINMONEY",nullable=true,scale=2,length=12)
	public java.lang.String getJoinmoney(){
		return this.joinmoney;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  joinmoney
	 */
	public void setJoinmoney(java.lang.String joinmoney){
		this.joinmoney = joinmoney;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  optuserid
	 */
	@Column(name ="OPTUSERID",nullable=true,length=19)
	public java.lang.Integer getOptuserid(){
		return this.optuserid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  optuserid
	 */
	public void setOptuserid(java.lang.Integer optuserid){
		this.optuserid = optuserid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  isbackmoney
	 */
	@Column(name ="ISBACKMONEY",nullable=true,length=10)
	public java.lang.String getIsbackmoney(){
		return this.isbackmoney;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  isbackmoney
	 */
	public void setIsbackmoney(java.lang.String isbackmoney){
		this.isbackmoney = isbackmoney;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  optremark
	 */
	@Column(name ="OPTREMARK",nullable=true,length=200)
	public java.lang.String getOptremark(){
		return this.optremark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  optremark
	 */
	public void setOptremark(java.lang.String optremark){
		this.optremark = optremark;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  iszengsong
	 */
	@Column(name ="ISZENGSONG",nullable=true,length=10)
	public java.lang.String getIszengsong(){
		return this.iszengsong;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  iszengsong
	 */
	public void setIszengsong(java.lang.String iszengsong){
		this.iszengsong = iszengsong;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  weixin
	 */
	@Column(name ="WEIXIN",nullable=true,length=50)
	public java.lang.String getWeixin(){
		return this.weixin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  weixin
	 */
	public void setWeixin(java.lang.String weixin){
		this.weixin = weixin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  zhifubao
	 */
	@Column(name ="ZHIFUBAO",nullable=true,length=50)
	public java.lang.String getZhifubao(){
		return this.zhifubao;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  zhifubao
	 */
	public void setZhifubao(java.lang.String zhifubao){
		this.zhifubao = zhifubao;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  usercode
	 */
	@Column(name ="USERCODE",nullable=true,length=10)
	public java.lang.String getUsercode(){
		return this.usercode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  usercode
	 */
	public void setUsercode(java.lang.String usercode){
		this.usercode = usercode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  openid
	 */
	@Column(name ="OPENID",nullable=true,length=50)
	public java.lang.String getOpenid(){
		return this.openid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  openid
	 */
	public void setOpenid(java.lang.String openid){
		this.openid = openid;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id",referencedColumnName="userid",nullable=true,insertable=false,updatable=false)
	public EweUserInfoEntity getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(EweUserInfoEntity userInfo) {
		this.userInfo = userInfo;
	}
	
	
}
