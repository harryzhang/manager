<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户基本资料</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eweUserInfoController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${eweUserInfoPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								用户id:
							</label>
						</td>
						<td class="value">
						     	 <input id="userid" name="userid" type="text" style="width: 150px" readOnly="true" class="inputxt" datatype="*" value='${eweUserInfoPage.userid}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户id</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								真实姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="realname" name="realname" type="text" style="width: 150px" class="inputxt"  value='${eweUserInfoPage.realname}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">真实姓名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								身份证号:
							</label>
						</td>
						<td class="value">
						     	 <input id="idcardno" name="idcardno" type="text" style="width: 150px" class="inputxt"  value='${eweUserInfoPage.idcardno}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">身份证号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								性别:
							</label>
						</td>
						<td class="value">
						     	 <input id="sex" name="sex" type="text" style="width: 150px" class="inputxt"  value='${eweUserInfoPage.sex}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">性别</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								联系地址:
							</label>
						</td>
						<td class="value">
						     	 <input id="contactaddress" name="contactaddress" type="text" style="width: 150px" class="inputxt"  value='${eweUserInfoPage.contactaddress}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">联系地址</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								手机号码:
							</label>
						</td>
						<td class="value">
						     	 <input id="mobile" name="mobile" type="text" style="width: 150px" class="inputxt"  value='${eweUserInfoPage.mobile}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">手机号码</label>
						</td>
					</tr>
					<tr>
						
						<td align="right">
							<label class="Validform_label">
								微信号:
							</label>
						</td>
						<td class="value">
						     	 <input id="weixinumber" name="weixinumber" type="text" style="width: 150px" class="inputxt"  value='${eweUserInfoPage.weixinumber}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">微信号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								支付宝:
							</label>
						</td>
						<td class="value">
						     	 <input id="zfbnumber" name="zfbnumber" type="text" style="width: 150px" class="inputxt"  value='${eweUserInfoPage.zfbnumber}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">支付宝</label>
						</td>
					</tr>
					
					<tr>
						<td align="right">
							<label class="Validform_label">
								开户省份:
							</label>
						</td>
						<td class="value">
						     	 <input id="province" name="province" type="text" style="width: 150px" class="inputxt"  value='${eweUserInfoPage.province}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开户省份</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								开户市区:
							</label>
						</td>
						<td class="value">
						     	 <input id="city" name="city" type="text" style="width: 150px" class="inputxt"  value='${eweUserInfoPage.city}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开户市区</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								银行支行:
							</label>
						</td>
						<td class="value">
						     	 <input id="banksubbranch" name="banksubbranch" type="text" style="width: 150px" class="inputxt"  value='${eweUserInfoPage.banksubbranch}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">银行支行</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								银行账号:
							</label>
						</td>
						<td class="value">
						     	 <input id="bankaccount" name="bankaccount" type="text" style="width: 150px" class="inputxt"  value='${eweUserInfoPage.bankaccount}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">银行账号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								开户姓名:
							</label>
						</td>
						<td class="value">
						     	 <input id="openaccount" name="openaccount" type="text" style="width: 150px" class="inputxt"  value='${eweUserInfoPage.openaccount}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开户姓名</label>
						</td>
				
						<td align="right">
							<label class="Validform_label">
								开户银行:
							</label>
						</td>
						<td class="value">
						     	 <input id="bankname" name="bankname" type="text" style="width: 150px" class="inputxt"  value='${eweUserInfoPage.bankname}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开户银行</label>
						</td>
					</tr>
					
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/user/eweUserInfo.js"></script>		
