package com.ewe.jingpai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.jeecgframework.poi.excel.annotation.Excel;

import com.ewe.goods.entity.EweGoodsEntity;

/**   
 * @Title: Entity
 * @Description: 竞拍管理
 * @author onlineGenerator
 * @date 2017-01-22 02:10:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_jingpai", schema = "")
@SuppressWarnings("serial")
public class JingpaiEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**商品ID*/
	@Excel(name="商品ID")
//	private java.lang.Integer goodsid;
	
	private EweGoodsEntity goods;
	/**竞拍开始时间*/
	@Excel(name="竞拍开始时间",format = "yyyy-MM-dd")
	private java.util.Date starttime;
	/**竞拍结束时间*/
	@Excel(name="竞拍结束时间",format = "yyyy-MM-dd")
	private java.util.Date endtime;
	/**竞拍开始价格*/
	@Excel(name="竞拍开始价格")
	private java.math.BigDecimal startprice;
	/**竞拍当前价格*/
	@Excel(name="竞拍当前价格")
	private java.math.BigDecimal endprice;
	/**最后竞拍人*/
	@Excel(name="最后竞拍人")
	private java.lang.String lastuser;
	/**最后竞拍时间*/
	@Excel(name="最后竞拍时间",format = "yyyy-MM-dd")
	private java.util.Date usertime;
	/**竞拍底价*/
	@Excel(name="竞拍底价")
	private java.math.BigDecimal lastprice;
	/**竞拍状态*/
	@Excel(name="竞拍状态")
	private java.lang.Integer status;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private java.util.Date createtime;
	/**userid*/
	@Excel(name="userid")
	private java.lang.Integer userid;
	
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
	 *@return: java.lang.Integer  商品ID
	 */
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GOODSID" ,nullable=true)
	public EweGoodsEntity getGoods() {
		return goods;
	}

	public void setGoods(EweGoodsEntity goods) {
		this.goods = goods;
	}

	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  竞拍开始时间
	 */
	@Column(name ="STARTTIME",nullable=true)
	public java.util.Date getStarttime(){
		return this.starttime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  竞拍开始时间
	 */
	public void setStarttime(java.util.Date starttime){
		this.starttime = starttime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  竞拍结束时间
	 */
	@Column(name ="ENDTIME",nullable=true)
	public java.util.Date getEndtime(){
		return this.endtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  竞拍结束时间
	 */
	public void setEndtime(java.util.Date endtime){
		this.endtime = endtime;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  竞拍开始价格
	 */
	@Column(name ="STARTPRICE",nullable=true,scale=2,length=12)
	public java.math.BigDecimal getStartprice(){
		return this.startprice;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  竞拍开始价格
	 */
	public void setStartprice(java.math.BigDecimal startprice){
		this.startprice = startprice;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  竞拍当前价格
	 */
	@Column(name ="ENDPRICE",nullable=true,scale=2,length=12)
	public java.math.BigDecimal getEndprice(){
		return this.endprice;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  竞拍当前价格
	 */
	public void setEndprice(java.math.BigDecimal endprice){
		this.endprice = endprice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  最后竞拍人
	 */
	@Column(name ="LASTUSER",nullable=true,length=200)
	public java.lang.String getLastuser(){
		return this.lastuser;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  最后竞拍人
	 */
	public void setLastuser(java.lang.String lastuser){
		this.lastuser = lastuser;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  最后竞拍时间
	 */
	@Column(name ="USERTIME",nullable=true)
	public java.util.Date getUsertime(){
		return this.usertime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  最后竞拍时间
	 */
	public void setUsertime(java.util.Date usertime){
		this.usertime = usertime;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  竞拍底价
	 */
	@Column(name ="LASTPRICE",nullable=true,scale=2,length=12)
	public java.math.BigDecimal getLastprice(){
		return this.lastprice;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  竞拍底价
	 */
	public void setLastprice(java.math.BigDecimal lastprice){
		this.lastprice = lastprice;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  竞拍状态
	 */
	@Column(name ="STATUS",nullable=true,length=10)
	public java.lang.Integer getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  竞拍状态
	 */
	public void setStatus(java.lang.Integer status){
		this.status = status;
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
	 *@return: java.lang.Integer  userid
	 */
	@Column(name ="USERID",nullable=true,length=10)
	public java.lang.Integer getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  userid
	 */
	public void setUserid(java.lang.Integer userid){
		this.userid = userid;
	}
}
