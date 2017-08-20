package com.ewe.goods.entity;

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
 * @Description: 商品信息表
 * @author onlineGenerator
 * @date 2016-10-28 16:49:31
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_goods", schema = "")
@SuppressWarnings("serial")
public class EweGoodsEntity implements java.io.Serializable {
	/**商品ID*/
	private java.lang.Integer goodsid;
	/**商品名称*/
	@Excel(name="商品名称")
	private java.lang.String gname;
	/**商品描述*/
	@Excel(name="商品描述")
	private java.lang.String gdesc;
	/**状态*/
	@Excel(name="状态")
	private java.lang.String status;
	/**商品代码*/
	@Excel(name="商品代码")
	private java.lang.String gcode;
	/**品类*/
	@Excel(name="品类")
	private java.lang.String gcate;
	/**单位*/
	@Excel(name="单位")
	private java.lang.String gunite;
	/**价格*/
	@Excel(name="价格")
	private java.lang.String price;
	/**类别*/
	@Excel(name="类别")
	private java.lang.String gkind;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private java.util.Date createtime;
	/**imagesrc*/
	@Excel(name="imagesrc")
	private java.lang.String imagesrc;
	/**bigimagesrc*/
	@Excel(name="bigimagesrc")
	private java.lang.String bigimagesrc;
	/**bandname*/
	@Excel(name="bandname")
	private java.lang.String bandname;
	/**id*/
	@Excel(name="id")
	private java.lang.Integer id;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  商品ID
	 */
	@Column(name ="GOODSID",nullable=true,length=19)
	public java.lang.Integer getGoodsid(){
		return this.goodsid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  商品ID
	 */
	public void setGoodsid(java.lang.Integer goodsid){
		this.goodsid = goodsid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品名称
	 */
	@Column(name ="GNAME",nullable=true,length=50)
	public java.lang.String getGname(){
		return this.gname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品名称
	 */
	public void setGname(java.lang.String gname){
		this.gname = gname;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品描述
	 */
	@Column(name ="GDESC",nullable=true,length=500)
	public java.lang.String getGdesc(){
		return this.gdesc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品描述
	 */
	public void setGdesc(java.lang.String gdesc){
		this.gdesc = gdesc;
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
	 *@return: java.lang.String  商品代码
	 */
	@Column(name ="GCODE",nullable=true,length=20)
	public java.lang.String getGcode(){
		return this.gcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品代码
	 */
	public void setGcode(java.lang.String gcode){
		this.gcode = gcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  品类
	 */
	@Column(name ="GCATE",nullable=true,length=50)
	public java.lang.String getGcate(){
		return this.gcate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  品类
	 */
	public void setGcate(java.lang.String gcate){
		this.gcate = gcate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位
	 */
	@Column(name ="GUNITE",nullable=true,length=20)
	public java.lang.String getGunite(){
		return this.gunite;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位
	 */
	public void setGunite(java.lang.String gunite){
		this.gunite = gunite;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  价格
	 */
	@Column(name ="PRICE",nullable=true,scale=2,length=12)
	public java.lang.String getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  价格
	 */
	public void setPrice(java.lang.String price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  类别
	 */
	@Column(name ="GKIND",nullable=true,length=10)
	public java.lang.String getGkind(){
		return this.gkind;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  类别
	 */
	public void setGkind(java.lang.String gkind){
		this.gkind = gkind;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  imagesrc
	 */
	@Column(name ="IMAGESRC",nullable=true,length=100)
	public java.lang.String getImagesrc(){
		return this.imagesrc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  imagesrc
	 */
	public void setImagesrc(java.lang.String imagesrc){
		this.imagesrc = imagesrc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  bigimagesrc
	 */
	@Column(name ="BIGIMAGESRC",nullable=true,length=100)
	public java.lang.String getBigimagesrc(){
		return this.bigimagesrc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  bigimagesrc
	 */
	public void setBigimagesrc(java.lang.String bigimagesrc){
		this.bigimagesrc = bigimagesrc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  bandname
	 */
	@Column(name ="BANDNAME",nullable=true,length=50)
	public java.lang.String getBandname(){
		return this.bandname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  bandname
	 */
	public void setBandname(java.lang.String bandname){
		this.bandname = bandname;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ID",nullable=false,length=32)
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
}
