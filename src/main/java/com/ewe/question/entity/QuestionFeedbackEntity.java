package com.ewe.question.entity;

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
 * @Description: 留言反馈
 * @author onlineGenerator
 * @date 2017-01-22 23:39:44
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_question_feedback", schema = "")
@SuppressWarnings("serial")
public class QuestionFeedbackEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**留言Id*/
	@Excel(name="留言Id")
	private java.lang.Integer qusetionId;
	/**用户ID*/
	@Excel(name="用户ID")
	private java.lang.Integer userId;
	/**反馈内容*/
	@Excel(name="反馈内容")
	private java.lang.String content;
	/**反馈时间*/
	@Excel(name="反馈时间",format = "yyyy-MM-dd")
	private java.util.Date createTime;
	
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
	 *@return: java.lang.Integer  留言Id
	 */
	@Column(name ="QUSETION_ID",nullable=true,length=10)
	public java.lang.Integer getQusetionId(){
		return this.qusetionId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  留言Id
	 */
	public void setQusetionId(java.lang.Integer qusetionId){
		this.qusetionId = qusetionId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  用户ID
	 */
	@Column(name ="USER_ID",nullable=true,length=10)
	public java.lang.Integer getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  用户ID
	 */
	public void setUserId(java.lang.Integer userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  反馈内容
	 */
	@Column(name ="CONTENT",nullable=true,length=65535)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  反馈内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  反馈时间
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  反馈时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
}
