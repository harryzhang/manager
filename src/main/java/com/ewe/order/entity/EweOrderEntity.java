package com.ewe.order.entity;

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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import com.ewe.goods.entity.EweGoodsEntity;
import com.ewe.user.entity.EweUserEntity;

/**   
 * @Title: Entity
 * @Description: 积分订单列表
 * @author onlineGenerator
 * @date 2016-11-12 23:46:29
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_order", schema = "")
@SuppressWarnings("serial")
public class EweOrderEntity implements java.io.Serializable {
	/**订单ID*/
	private java.lang.Integer orderid;
	/**订单号*/
	@Excel(name="订单号")
	private java.lang.String ordercode;
	/**用户ID*/
	@Excel(name="用户ID")
//	private java.lang.Integer userid;
	private EweUserEntity user;
	/**商品ID*/
	@Excel(name="商品ID")
//	private java.lang.Integer goodsid;
	private EweGoodsEntity goods;
	/**商品数量*/
	@Excel(name="商品数量")
	private java.lang.Integer qty;
	/**商品单价*/
	@Excel(name="商品单价")
	private java.lang.String price;
	/**商品总价格*/
	@Excel(name="商品总价格")
	private java.lang.String totalprice;
	/**收货地址*/
	@Excel(name="收货地址")
	private java.lang.String recaddress;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private java.util.Date createtime;
	/**订单状态*/
	@Excel(name="订单状态")
	private java.lang.Integer orderstatus;
	/**付款状态*/
	private java.lang.Integer paystatus;
	/**付款确定时间*/
	private java.util.Date paytime;
	/**订单类型*/
	@Excel(name="订单类型")
	private java.lang.Integer ordertype;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  订单ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ORDERID",nullable=false,length=19)
	public java.lang.Integer getOrderid(){
		return this.orderid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  订单ID
	 */
	public void setOrderid(java.lang.Integer orderid){
		this.orderid = orderid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单号
	 */
	@Column(name ="ORDERCODE",nullable=true,length=50)
	public java.lang.String getOrdercode(){
		return this.ordercode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单号
	 */
	public void setOrdercode(java.lang.String ordercode){
		this.ordercode = ordercode;
	}
	
	
	@OneToOne
	@JoinColumn(name ="USERID",nullable=true)
	public EweUserEntity getUser() {
		return user;
	}

	public void setUser(EweUserEntity user) {
		this.user = user;
	}

	@OneToOne
	@JoinColumn(name ="GOODSID",nullable=true)
	public EweGoodsEntity getGoods() {
		return goods;
	}

	public void setGoods(EweGoodsEntity goods) {
		this.goods = goods;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  商品数量
	 */
	@Column(name ="QTY",nullable=true,length=19)
	public java.lang.Integer getQty(){
		return this.qty;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  商品数量
	 */
	public void setQty(java.lang.Integer qty){
		this.qty = qty;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品单价
	 */
	@Column(name ="PRICE",nullable=true,scale=2,length=12)
	public java.lang.String getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品单价
	 */
	public void setPrice(java.lang.String price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品总价格
	 */
	@Column(name ="TOTALPRICE",nullable=true,scale=2,length=12)
	public java.lang.String getTotalprice(){
		return this.totalprice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品总价格
	 */
	public void setTotalprice(java.lang.String totalprice){
		this.totalprice = totalprice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收货地址
	 */
	@Column(name ="RECADDRESS",nullable=true,length=200)
	public java.lang.String getRecaddress(){
		return this.recaddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收货地址
	 */
	public void setRecaddress(java.lang.String recaddress){
		this.recaddress = recaddress;
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
	 *@return: java.lang.Integer  订单状态
	 */
	@Column(name ="ORDERSTATUS",nullable=true,length=10)
	public java.lang.Integer getOrderstatus(){
		return this.orderstatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  订单状态
	 */
	public void setOrderstatus(java.lang.Integer orderstatus){
		this.orderstatus = orderstatus;
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
	 *@return: java.util.Date  付款确定时间
	 */
	@Column(name ="PAYTIME",nullable=true)
	public java.util.Date getPaytime(){
		return this.paytime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  付款确定时间
	 */
	public void setPaytime(java.util.Date paytime){
		this.paytime = paytime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  订单类型
	 */
	@Column(name ="ORDERTYPE",nullable=true,length=10)
	public java.lang.Integer getOrdertype(){
		return this.ordertype;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  订单类型
	 */
	public void setOrdertype(java.lang.Integer ordertype){
		this.ordertype = ordertype;
	}
}
