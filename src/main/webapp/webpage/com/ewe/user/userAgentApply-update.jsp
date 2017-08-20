<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户省市审核</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="userAgentApplyController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${userAgentApplyPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								userid:
							</label>
						</td>
						<td class="value">
						     	 <input id="userid" name="userid" type="text" style="width: 150px" class="inputxt" datatype="*" value='${userAgentApplyPage.userid}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">userid</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								agenttype:
							</label>
						</td>
						<td class="value">
						     	 <input id="agenttype" name="agenttype" type="text" style="width: 150px" class="inputxt"  value='${userAgentApplyPage.agenttype}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">agenttype</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								province:
							</label>
						</td>
						<td class="value">
						     	 <input id="province" name="province" type="text" style="width: 150px" class="inputxt"  value='${userAgentApplyPage.province}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">province</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								city:
							</label>
						</td>
						<td class="value">
						     	 <input id="city" name="city" type="text" style="width: 150px" class="inputxt"  value='${userAgentApplyPage.city}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">city</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								status:
							</label>
						</td>
						<td class="value">
						     	 <input id="status" name="status" type="text" style="width: 150px" class="inputxt"  value='${userAgentApplyPage.status}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">status</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								createtime:
							</label>
						</td>
						<td class="value">
									  <input id="createtime" name="createtime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${userAgentApplyPage.createtime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">createtime</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								approvtime:
							</label>
						</td>
						<td class="value">
									  <input id="approvtime" name="approvtime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${userAgentApplyPage.approvtime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">approvtime</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/user/userAgentApply.js"></script>		
