<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户账户</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eweUserAccountController.do?doAdd" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${eweUserAccountPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户ID:
						</label>
					</td>
					<td class="value">
					     	 <input id="userid" name="userid" type="text" style="width: 150px" class="inputxt"  datatype="*">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户ID</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							帐户金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="amount" name="amount" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">帐户金额</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							账户类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="accounttype" name="accounttype" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">账户类型</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							累计支出金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="totalconsumeamount" name="totalconsumeamount" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">累计支出金额</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							累计收入金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="totalinocmeamount" name="totalinocmeamount" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">累计收入金额</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							冻结金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="frozendeposit" name="frozendeposit" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">冻结金额</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							当天收益金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="incomeamount" name="incomeamount" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">当天收益金额</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							当天支出金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="consueamount" name="consueamount" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">当天支出金额</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							更新时间:
						</label>
					</td>
					<td class="value">
							   <input id="updatetime" name="updatetime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">更新时间</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							累计提现金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="withdrawtotaldeposit" name="withdrawtotaldeposit" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">累计提现金额</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/user/eweUserAccount.js"></script>		
