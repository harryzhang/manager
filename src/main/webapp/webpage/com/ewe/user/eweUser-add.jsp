<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户列表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eweUserController.do?doAdd" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${eweUserPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户名:
						</label>
					</td>
					<td class="value">
					     	 <input id="username" name="username" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户名</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							用户密码:
						</label>
					</td>
					<td class="value">
					     	 <input id="password" name="password" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户密码</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							二级密码:
						</label>
					</td>
					<td class="value">
					     	 <input id="passwordtwo" name="passwordtwo" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">二级密码</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							当前等级:
						</label>
					</td>
					<td class="value">
					     	 <input id="grade" name="grade" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">当前等级</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							组织机构:
						</label>
					</td>
					<td class="value">
					     	 <input id="organ" name="organ" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">组织机构</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							状态:
						</label>
					</td>
					<td class="value">
					     	 <input id="enabled" name="enabled" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							推荐人编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="referrerid" name="referrerid" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">推荐人编号</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							接点人编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="parentid" name="parentid" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">接点人编号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							业务方向:
						</label>
					</td>
					<td class="value">
					     	 <input id="treenode" name="treenode" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">业务方向</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建时间:
						</label>
					</td>
					<td class="value">
							   <input id="creatortime" name="creatortime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							修改时间:
						</label>
					</td>
					<td class="value">
							   <input id="updatetime" name="updatetime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							name:
						</label>
					</td>
					<td class="value">
					     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">name</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							积分:
						</label>
					</td>
					<td class="value">
					     	 <input id="bonus" name="bonus" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">积分</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							status:
						</label>
					</td>
					<td class="value">
					     	 <input id="status" name="status" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">status</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							joinmoney:
						</label>
					</td>
					<td class="value">
					     	 <input id="joinmoney" name="joinmoney" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">joinmoney</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							optuserid:
						</label>
					</td>
					<td class="value">
					     	 <input id="optuserid" name="optuserid" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">optuserid</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							isbackmoney:
						</label>
					</td>
					<td class="value">
					     	 <input id="isbackmoney" name="isbackmoney" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">isbackmoney</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							optremark:
						</label>
					</td>
					<td class="value">
					     	 <input id="optremark" name="optremark" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">optremark</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							iszengsong:
						</label>
					</td>
					<td class="value">
					     	 <input id="iszengsong" name="iszengsong" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">iszengsong</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							weixin:
						</label>
					</td>
					<td class="value">
					     	 <input id="weixin" name="weixin" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">weixin</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							zhifubao:
						</label>
					</td>
					<td class="value">
					     	 <input id="zhifubao" name="zhifubao" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">zhifubao</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							usercode:
						</label>
					</td>
					<td class="value">
					     	 <input id="usercode" name="usercode" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">usercode</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							openid:
						</label>
					</td>
					<td class="value">
					     	 <input id="openid" name="openid" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">openid</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/user/eweUser.js"></script>		
