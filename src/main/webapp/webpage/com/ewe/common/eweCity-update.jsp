<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>t_s_city</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eweCityController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${eweCityPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								cityid:
							</label>
						</td>
						<td class="value">
						     	 <input id="cityid" name="cityid" type="text" style="width: 150px" class="inputxt" datatype="*" value='${eweCityPage.cityid}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">cityid</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								city:
							</label>
						</td>
						<td class="value">
						     	 <input id="city" name="city" type="text" style="width: 150px" class="inputxt" datatype="*" value='${eweCityPage.city}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">city</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								fatherid:
							</label>
						</td>
						<td class="value">
						     	 <input id="fatherid" name="fatherid" type="text" style="width: 150px" class="inputxt" datatype="*" value='${eweCityPage.fatherid}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">fatherid</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/common/eweCity.js"></script>		
