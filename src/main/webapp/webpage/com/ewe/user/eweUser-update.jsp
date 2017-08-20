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
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eweUserController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${eweUserPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								用户名:
							</label>
						</td>
						<td class="value">
						     	 <input id="username" name="username" type="text" style="width: 150px" class="inputxt"  value='${eweUserPage.username}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								当前等级:
							</label>
						</td>
						<td class="value">
<%-- 						     	 <input id="grade" name="grade" type="text" style="width: 150px" class="inputxt"  value='${eweUserPage.grade}'> --%>
							
							<t:dictSelect field="enabled" typeGroupCode="uGrade" title="用户等级" hasLabel="false" defaultVal="${eweUserPage.enabled}"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">当前等级</label>
						</td>
					</tr>
					
					<tr>
						<td align="right">
							<label class="Validform_label">
								用户名:
							</label>
						</td>
						<td class="value">
						     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  value='${eweUserPage.name}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">name</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								推荐人编号:
							</label>
						</td>
						<td class="value">
						     	 <input id="referrerid" name="referrerid" type="text" style="width: 150px" class="inputxt"  value='${eweUserPage.referrerid}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">推荐人编号</label>
						</td>
					</tr>
					
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建时间:
							</label>
						</td>
						<td class="value">
									  <input id="creatortime" name="creatortime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${eweUserPage.creatortime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								修改时间:
							</label>
						</td>
						<td class="value">
									  <input id="updatetime" name="updatetime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${eweUserPage.updatetime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改时间</label>
						</td>
					</tr>
					
					<tr>
						<td align="right">
							<label class="Validform_label">
								状态:
							</label>
						</td>
						<td class="value">
						     	 <input id="status" name="status" type="text" style="width: 150px" class="inputxt"  value='${eweUserPage.status}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">status</label>
						</td>
					
						<td align="right">
							<label class="Validform_label">
								报单中心:
							</label>
						</td>
						<td class="value">
<%-- 						     	 <input id="usercode" name="usercode" type="text" style="width: 150px" class="inputxt"  value='${eweUserPage.usercode}'> --%>
								<t:dictSelect field="organ" typeGroupCode="uCenter"  hasLabel="false" defaultVal="${eweUserPage.organ}"></t:dictSelect>
							
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">usercode</label>
						</td>
						
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/user/eweUser.js"></script>		
