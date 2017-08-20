package com.ewe.common.entity;

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
 * @Description: t_s_city
 * @author onlineGenerator
 * @date 2016-11-06 02:37:29
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_city", schema = "")
@SuppressWarnings("serial")
public class EweCityEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**cityid*/
	@Excel(name="cityid")
	private java.lang.Integer cityid;
	/**city*/
	@Excel(name="city")
	private java.lang.String city;
	/**fatherid*/
	@Excel(name="fatherid")
	private java.lang.Integer fatherid;
	
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
	 *@return: java.lang.Integer  cityid
	 */
	@Column(name ="CITYID",nullable=false,length=10)
	public java.lang.Integer getCityid(){
		return this.cityid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  cityid
	 */
	public void setCityid(java.lang.Integer cityid){
		this.cityid = cityid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  city
	 */
	@Column(name ="CITY",nullable=false,length=20)
	public java.lang.String getCity(){
		return this.city;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  city
	 */
	public void setCity(java.lang.String city){
		this.city = city;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  fatherid
	 */
	@Column(name ="FATHERID",nullable=false,length=10)
	public java.lang.Integer getFatherid(){
		return this.fatherid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  fatherid
	 */
	public void setFatherid(java.lang.Integer fatherid){
		this.fatherid = fatherid;
	}
}
