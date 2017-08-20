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
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eweUserAccountController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${eweUserAccountPage.id }">
					<input id="user.id" name="user.id" type="hidden" value="${eweUserAccountPage.user.id }">
					<input id="accounttype" name="accounttype" type="hidden" value="${eweUserAccountPage.accounttype }">
					<input id="totalconsumeamount" name="totalconsumeamount" type="hidden" value="${eweUserAccountPage.totalconsumeamount }">
					<input id="totalinocmeamount" name="totalinocmeamount" type="hidden" value="${eweUserAccountPage.totalinocmeamount }">
					<input id="frozendeposit" name="frozendeposit" type="hidden" value="${eweUserAccountPage.frozendeposit }">
					<input id="incomeamount" name="incomeamount" type="hidden" value="${eweUserAccountPage.incomeamount }">
					<input id="consueamount" name="consueamount" type="hidden" value="${eweUserAccountPage.consueamount }">
					<input id="withdrawtotaldeposit" name="withdrawtotaldeposit" type="hidden" value="${eweUserAccountPage.withdrawtotaldeposit }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								用户:
							</label>
						</td>
						<td class="value">
						     	 <input id="username" name="username" type="text" style="width: 150px" class="inputxt" datatype="*" value='${eweUserAccountPage.user.name}'>
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
						     	 <input id="amount" name="amount" type="text" style="width: 150px" class="inputxt"  value='${eweUserAccountPage.amount}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">帐户金额</label>
						</td>
					</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/user/eweUserAccount.js"></script>		
