package com.ewe.question.entity;

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

import com.ewe.user.entity.EweUserEntity;

/**   
 * @Title: Entity
 * @Description: 问题反馈
 * @author onlineGenerator
 * @date 2017-01-14 00:35:41
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_question", schema = "")
@SuppressWarnings("serial")
public class QuestionEntity implements java.io.Serializable {
	/**id*/
	private java.lang.Integer id;
	/**主题*/
	@Excel(name="主题")
	private java.lang.String theme;
	/**内容*/
	@Excel(name="内容")
	private java.lang.String content;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private java.util.Date createTime;
	/**userId*/
	@Excel(name="userId")
//	private java.lang.Integer userId;
	private EweUserEntity user;
	
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主题
	 */
	@Column(name ="THEME",nullable=true,length=200)
	public java.lang.String getTheme(){
		return this.theme;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主题
	 */
	public void setTheme(java.lang.String theme){
		this.theme = theme;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容
	 */
	@Column(name ="CONTENT",nullable=true,length=3000)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  userId
	 */

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name ="USER_ID",nullable=true)
	public EweUserEntity getUser() {
		return user;
	}

	public void setUser(EweUserEntity user) {
		this.user = user;
	}
	
	
}
