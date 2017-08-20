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
 * @Description: 省代码
 * @author onlineGenerator
 * @date 2016-11-06 02:35:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_s_province", schema = "")
@SuppressWarnings("serial")
public class EweProvinceEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**provinceid*/
	@Excel(name="provinceid")
	private java.lang.Integer provinceid;
	/**province*/
	@Excel(name="province")
	private java.lang.String province;
	
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
	 *@return: java.lang.Integer  provinceid
	 */
	@Column(name ="PROVINCEID",nullable=false,length=10)
	public java.lang.Integer getProvinceid(){
		return this.provinceid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  provinceid
	 */
	public void setProvinceid(java.lang.Integer provinceid){
		this.provinceid = provinceid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  province
	 */
	@Column(name ="PROVINCE",nullable=false,length=20)
	public java.lang.String getProvince(){
		return this.province;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  province
	 */
	public void setProvince(java.lang.String province){
		this.province = province;
	}
}
