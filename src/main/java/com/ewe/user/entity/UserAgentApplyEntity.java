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

import com.ewe.common.entity.EweCityEntity;
import com.ewe.common.entity.EweProvinceEntity;

/**   
 * @Title: Entity
 * @Description: 用户省市审核
 * @author onlineGenerator
 * @date 2016-11-06 02:30:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_user_agent_apply", schema = "")
@SuppressWarnings("serial")
public class UserAgentApplyEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**userid*/
	@Excel(name="userid")
	private EweUserEntity user;
	
	/**agenttype*/
	@Excel(name="agenttype")
	private java.lang.String agenttype;
	/**province*/
	@Excel(name="province")
//	private java.lang.String province;
	private EweProvinceEntity province;
	/**city*/
	@Excel(name="city")
//	private java.lang.String city;
	private EweCityEntity city;
	/**status*/
	@Excel(name="status")
	private java.lang.String status;
	/**createtime*/
	@Excel(name="createtime",format = "yyyy-MM-dd")
	private java.util.Date createtime;
	/**approvtime*/
	@Excel(name="approvtime",format = "yyyy-MM-dd")
	private java.util.Date approvtime;
	
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
	
	public void setProvince(EweProvinceEntity province) {
		this.province = province;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  agenttype
	 */
	@Column(name ="AGENTTYPE",nullable=true,length=20)
	public java.lang.String getAgenttype(){
		return this.agenttype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  agenttype
	 */
	public void setAgenttype(java.lang.String agenttype){
		this.agenttype = agenttype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  province
	 */


	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="USERID",nullable=true)
	public EweUserEntity getUser() {
		return user;
	}

	public void setUser(EweUserEntity user) {
		this.user = user;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="CITY",referencedColumnName="CITYID",nullable=true)
	public EweCityEntity getCity() {
		return city;
	}

	public void setCity(EweCityEntity city) {
		this.city = city;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="PROVINCE",referencedColumnName="PROVINCEID",nullable=true)
	public EweProvinceEntity getProvince() {
		return province;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  status
	 */
	@Column(name ="STATUS",nullable=true,length=1)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  status
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createtime
	 */
	@Column(name ="CREATETIME",nullable=true)
	public java.util.Date getCreatetime(){
		return this.createtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  createtime
	 */
	public void setCreatetime(java.util.Date createtime){
		this.createtime = createtime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  approvtime
	 */
	@Column(name ="APPROVTIME",nullable=true)
	public java.util.Date getApprovtime(){
		return this.approvtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  approvtime
	 */
	public void setApprovtime(java.util.Date approvtime){
		this.approvtime = approvtime;
	}
}
