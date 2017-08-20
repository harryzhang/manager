<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>提现</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eweWithdrawController.do?doUpdate" tiptype="1" >
					<input id="withdrawid" name="withdrawid" type="hidden" value="${eweWithdrawPage.withdrawid }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								提现号:
							</label>
						</td>
						<td class="value">
						     	 <input id="withdrawcode" name="withdrawcode" type="text" style="width: 150px" class="inputxt"  value='${eweWithdrawPage.withdrawcode}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提现号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								用户ID:
							</label>
						</td>
						<td class="value">
						     	 <input id="userid" name="userid" type="text" style="width: 150px" class="inputxt"  value='${eweWithdrawPage.userid}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								提现金额:
							</label>
						</td>
						<td class="value">
						     	 <input id="amount" name="amount" type="text" style="width: 150px" class="inputxt"  value='${eweWithdrawPage.amount}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提现金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								提现手述费:
							</label>
						</td>
						<td class="value">
						     	 <input id="charge" name="charge" type="text" style="width: 150px" class="inputxt"  value='${eweWithdrawPage.charge}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提现手述费</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								支付金额:
							</label>
						</td>
						<td class="value">
						     	 <input id="payamount" name="payamount" type="text" style="width: 150px" class="inputxt"  value='${eweWithdrawPage.payamount}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">支付金额</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建时间:
							</label>
						</td>
						<td class="value">
									  <input id="createtime" name="createtime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${eweWithdrawPage.createtime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								提现单状态:
							</label>
						</td>
						<td class="value">
						     	 <input id="withdrawstatus" name="withdrawstatus" type="text" style="width: 150px" class="inputxt"  value='${eweWithdrawPage.withdrawstatus}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提现单状态</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								付款状态:
							</label>
						</td>
						<td class="value">
						     	 <input id="paystatus" name="paystatus" type="text" style="width: 150px" class="inputxt"  value='${eweWithdrawPage.paystatus}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">付款状态</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								提现确定时间:
							</label>
						</td>
						<td class="value">
									  <input id="paytime" name="paytime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${eweWithdrawPage.paytime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提现确定时间</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/user/eweWithdraw.js"></script>		
