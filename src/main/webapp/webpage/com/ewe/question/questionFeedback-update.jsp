<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>留言反馈</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="questionFeedbackController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${questionFeedbackPage.id }">
					<input id="userId" name="userId" type="hidden" value="${questionFeedbackPage.userId }">
					<input id="qusetionId" name="qusetionId" type="hidden" value="${questionFeedbackPage.qusetionId }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								反馈内容:
							</label>
						</td>
						<td class="value">
						  	 	<textarea id="content" style="width:600px;height: 80px" class="inputxt" rows="10" name="content">${questionFeedbackPage.content}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">反馈内容</label>
						</td>
					</tr>
					
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/question/questionFeedback.js"></script>		
