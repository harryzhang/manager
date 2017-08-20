<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户积分操记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eweUserOptController.do?doAdd" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${eweUserOptPage.id }">
					<input id="createName" name="createName" type="hidden" value="${eweUserOptPage.createName }">
					<input id="createBy" name="createBy" type="hidden" value="${eweUserOptPage.createBy }">
					<input id="createDate" name="createDate" type="hidden" value="${eweUserOptPage.createDate }">
					<input id="updateName" name="updateName" type="hidden" value="${eweUserOptPage.updateName }">
					<input id="updateBy" name="updateBy" type="hidden" value="${eweUserOptPage.updateBy }">
					<input id="updateDate" name="updateDate" type="hidden" value="${eweUserOptPage.updateDate }">
					<input id="sysOrgCode" name="sysOrgCode" type="hidden" value="${eweUserOptPage.sysOrgCode }">
					<input id="sysCompanyCode" name="sysCompanyCode" type="hidden" value="${eweUserOptPage.sysCompanyCode }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							操作对像:
						</label>
					</td>
					<td class="value">
					     	 <input id="userId" name="userId" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">操作对像</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							操作积分:
						</label>
					</td>
					<td class="value">
					     	 <input id="pointType" name="pointType" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">操作积分</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							积分金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="amount" name="amount" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">积分金额</label>
						</td>
				<tr>
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
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/setting/eweUserOpt.js"></script>		
