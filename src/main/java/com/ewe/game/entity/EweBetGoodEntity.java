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
 * @Description: 中奖号码
 * @author onlineGenerator
 * @date 2016-10-12 20:24:52
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_bet_good", schema = "")
@SuppressWarnings("serial")
public class EweBetGoodEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**期数*/
	@Excel(name="期数")
	private java.lang.Integer periods;
	/**号码*/
	@Excel(name="号码")
	private java.lang.String betnumber;
	/**创建人*/
	private java.lang.String createName;
	/**创建时间*/
	private java.util.Date createDate;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  号码
	 */
	@Column(name ="BETNUMBER",nullable=true,length=10)
	public java.lang.String getBetnumber(){
		return this.betnumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  号码
	 */
	public void setBetnumber(java.lang.String betnumber){
		this.betnumber = betnumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人
	 */
	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public java.lang.String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人
	 */
	public void setCreateName(java.lang.String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_DATE",nullable=true)
	public java.util.Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
}
