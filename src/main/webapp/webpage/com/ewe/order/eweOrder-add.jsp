<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>积分订单列表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eweOrderController.do?doAdd" tiptype="1" >
					<input id="orderid" name="orderid" type="hidden" value="${eweOrderPage.orderid }">
					<input id="paystatus" name="paystatus" type="hidden" value="${eweOrderPage.paystatus }">
					<input id="paytime" name="paytime" type="hidden" value="${eweOrderPage.paytime }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							订单号:
						</label>
					</td>
					<td class="value">
					     	 <input id="ordercode" name="ordercode" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">订单号</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户ID:
						</label>
					</td>
					<td class="value">
					     	 <input id="userid" name="userid" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户ID</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							商品ID:
						</label>
					</td>
					<td class="value">
					     	 <input id="goodsid" name="goodsid" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品ID</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							商品数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="qty" name="qty" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品数量</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							商品单价:
						</label>
					</td>
					<td class="value">
					     	 <input id="price" name="price" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品单价</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							商品总价格:
						</label>
					</td>
					<td class="value">
					     	 <input id="totalprice" name="totalprice" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品总价格</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							收货地址:
						</label>
					</td>
					<td class="value">
					     	 <input id="recaddress" name="recaddress" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收货地址</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							创建时间:
						</label>
					</td>
					<td class="value">
							   <input id="createtime" name="createtime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							订单状态:
						</label>
					</td>
					<td class="value">
					     	 <input id="orderstatus" name="orderstatus" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">订单状态</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							订单类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="ordertype" name="ordertype" type="text" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">订单类型</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/order/eweOrder.js"></script>		
