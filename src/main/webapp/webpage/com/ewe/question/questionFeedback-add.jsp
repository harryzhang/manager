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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="questionFeedbackController.do?doAdd" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${questionFeedbackPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							留言Id:
						</label>
					</td>
					<td class="value">
					     	 <input id="qusetionId" name="qusetionId" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">留言Id</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户ID:
						</label>
					</td>
					<td class="value">
					     	 <input id="userId" name="userId" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户ID</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							反馈内容:
						</label>
					</td>
					<td class="value">
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="content" name="content"></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">反馈内容</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							反馈时间:
						</label>
					</td>
					<td class="value">
							   <input id="createTime" name="createTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">反馈时间</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/question/questionFeedback.js"></script>		
