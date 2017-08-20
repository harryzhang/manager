<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>中奖号码</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eweBetGoodController.do?doAdd" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${eweBetGoodPage.id }">
					<input id="createName" name="createName" type="hidden" value="${eweBetGoodPage.createName }">
					<input id="createDate" name="createDate" type="hidden" value="${eweBetGoodPage.createDate }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							期数:
						</label>
					</td>
					<td class="value">
					     	 <input id="periods" name="periods" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">期数</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							号码:
						</label>
					</td>
					<td class="value">
					     	 <input id="betnumber" name="betnumber" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">号码</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/game/eweBetGood.js"></script>		
