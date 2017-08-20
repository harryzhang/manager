package com.ewe.setting.entity;

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
 * @Description: 参数设置
 * @author onlineGenerator
 * @date 2016-10-12 19:21:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "fx_param", schema = "")
@SuppressWarnings("serial")
public class EweParamEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**参数名*/
	@Excel(name="参数名")
	private java.lang.String paramName;
	/**参数值*/
	@Excel(name="参数值")
	private java.lang.String paramValue;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String remark;
	
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
	 *@return: java.lang.String  参数名
	 */
	@Column(name ="PARAM_NAME",nullable=true,length=100)
	public java.lang.String getParamName(){
		return this.paramName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参数名
	 */
	public void setParamName(java.lang.String paramName){
		this.paramName = paramName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参数值
	 */
	@Column(name ="PARAM_VALUE",nullable=true,length=100)
	public java.lang.String getParamValue(){
		return this.paramValue;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参数值
	 */
	public void setParamValue(java.lang.String paramValue){
		this.paramValue = paramValue;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=200)
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
}
