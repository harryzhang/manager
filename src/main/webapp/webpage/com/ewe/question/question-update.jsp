<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>问题反馈</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="questionController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${questionPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								主题:
							</label>
						</td>
						<td class="value">
						     	 <input id="theme" name="theme" type="text" style="width: 150px" class="inputxt"  value='${questionPage.theme}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">主题</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								内容:
							</label>
						</td>
						<td class="value">
						  	 	<textarea id="content" style="width:600px;" class="inputxt" rows="6" name="content">${questionPage.content}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">内容</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建时间:
							</label>
						</td>
						<td class="value">
									  <input id="createTime" name="createTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${questionPage.createTime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								用户:
							</label>
						</td>
						<td class="value">
						     	 <input id="userId" name="userId" type="text" style="width: 150px" class="inputxt"  value='${questionPage.user.name}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">userId</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/question/question.js"></script>		
