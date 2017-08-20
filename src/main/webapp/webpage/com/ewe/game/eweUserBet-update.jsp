<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>竞猜下注列表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eweUserBetController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${eweUserBetPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								用户ID:
							</label>
						</td>
						<td class="value">
						     	 <input id="userid" name="userid" type="text" style="width: 150px" class="inputxt"  value='${eweUserBetPage.userid}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								期数:
							</label>
						</td>
						<td class="value">
						     	 <input id="periods" name="periods" type="text" style="width: 150px" class="inputxt"  value='${eweUserBetPage.periods}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">期数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								投注时间:
							</label>
						</td>
						<td class="value">
									  <input id="bettime" name="bettime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${eweUserBetPage.bettime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">投注时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								投注金额:
							</label>
						</td>
						<td class="value">
						     	 <input id="amount" name="amount" type="text" style="width: 150px" class="inputxt"  value='${eweUserBetPage.amount}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">投注金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								状态:
							</label>
						</td>
						<td class="value">
						     	 <input id="status" name="status" type="text" style="width: 150px" class="inputxt"  value='${eweUserBetPage.status}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								投注号码:
							</label>
						</td>
						<td class="value">
						     	 <input id="betnumber" name="betnumber" type="text" style="width: 150px" class="inputxt"  value='${eweUserBetPage.betnumber}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">投注号码</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/game/eweUserBet.js"></script>		
