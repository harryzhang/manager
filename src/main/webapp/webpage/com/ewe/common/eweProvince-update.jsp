<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>省代码</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eweProvinceController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${eweProvincePage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								provinceid:
							</label>
						</td>
						<td class="value">
						     	 <input id="provinceid" name="provinceid" type="text" style="width: 150px" class="inputxt" datatype="*" value='${eweProvincePage.provinceid}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">provinceid</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								province:
							</label>
						</td>
						<td class="value">
						     	 <input id="province" name="province" type="text" style="width: 150px" class="inputxt" datatype="*" value='${eweProvincePage.province}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">province</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/common/eweProvince.js"></script>		
