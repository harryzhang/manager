<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>提现列表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  		<form name="form2" action="${serverUrl}" method="post">	
<br/>
<table class="table_box" width="50%"><tr><td style="padding-left:20px;">
	<table class="table_box">
	   <tr><td colspan="2">提交地址：${serverUrl}</td></tr>
	   <tr class="tit_bar">
	      <td colspan="2" class="tit_bar">报文参数</td>
	   </tr>
<%-- 	   <tr><td width="10%">1</td> <td>编码: ${inputCharset}</td> --%>
<!-- 	   </tr>   -->
<%-- 	   <tr><td>2</td>  <td>取货地址: ${pickupUrl}</td> --%>
<!-- 	   </tr> -->
<%-- 	   <tr><td>3</td>  <td>商户系统通知地址: ${receiveUrl}</td> --%>
<!-- 	   </tr> -->
<%-- 	   <tr><td>4</td>  <td>报文版本号: ${version}</td> --%>
<!-- 	   </tr> -->
<%-- 	   <tr><td>5</td>  <td>语言: ${language }</td>  --%>
<!-- 	   </tr> -->
<%-- 	   <tr><td>6</td>  <td>签名方式: ${signType}</td></tr>  --%>
<%-- 		<tr><td>7</td> <td>商户号: ${merchantId}</td></tr> --%>
		<tr><td>1</td> <td>付款人名称: ${payerName}</td></tr>	
<%-- 		<tr><td>9</td> <td>付款人联系email: ${payerEmail}</td></tr>	 --%>
<%-- 		<tr><td>10</td> <td>付款人电话: ${payerTelephone}</td></tr> --%>
		<tr><td>2</td>  <td>商户系统订单号: ${orderNo }</td></tr>	
		<tr><td>3</td>  <td>订单金额(精确到分): ${orderAmount}</td></tr>
<%-- 		<tr><td>13</td>  <td>金额币种: ${orderCurrency }</td></tr> --%>
		<tr><td>4</td>  <td>商户的订单创建时间: ${orderDatetime}</td></tr>
<%-- 		<tr><td>15</td>  <td>订单过期时间: ${orderExpireDatetime}</td></tr> --%>
		<tr><td>5</td>  <td>商品名称: ${productName}</td></tr>
		<tr><td>6</td>  <td>商品单价: ${productPrice}</td></tr>
<%-- 		<tr><td>18</td>  <td>商品数量: ${productNum }</td></tr>	 --%>
<%-- 		<tr><td>19</td>  <td>商品代码: ${productId}</td></tr> --%>
<%-- 		<tr><td>20</td>  <td>商品描述: ${productDesc}</td></tr> --%>
<%-- 		<tr><td>21</td>  <td>附加参数1: ${ext1 }</td></tr> --%>
<%-- 		<tr><td>22</td>  <td>附加参数2: ${ext2 }</td></tr> --%>
<%-- 		<tr><td>23</td>  <td>业务扩展: ${extTL}</td></tr> --%>
<%-- 	    <tr><td>24</td>  <td>支付方式: ${payType}</td></tr>	 --%>
<%-- 		<tr><td>25</td>  <td>发卡行机构号: ${issuerId}</td></tr> --%>
<%-- 		<tr><td colspan="2" >报文签名后内容: ${sign }</td></tr> --%>
<%-- 		<tr><td colspan="2" >签名原串：${ signSrc }</td></tr>	 --%>
		<tr><td colspan="2" >
	    
	    	<input type="submit" name="确认支付" value="信息正确，确认付款"/>
	    	
		</td>
		</tr>
	</table>	
</td>
</tr>
</table>	
		<input type="hidden" name="inputCharset" id="inputCharset" value="${inputCharset}"/>
		<input type="hidden" name="inputCharset" value="${inputCharset}"/>
		<input type="hidden" name="pickupUrl" value="${pickupUrl}"/>
		<input type="hidden" name="receiveUrl" value="${receiveUrl}" />
		<input type="hidden" name="version" value="${version }"/>
		<input type="hidden" name="language" value="${language }" />
		<input type="hidden" name="signType" value="${signType}"/>
		<input type="hidden" name="merchantId" value="${merchantId}" />
		<input type="hidden" name="payerName" value="${payerName}"/>
		<input type="hidden" name="payerEmail" value="${payerEmail}" />
		<input type="hidden" name="payerTelephone" value="${payerTelephone }" />
		<input type="hidden" name="orderNo" value="${orderNo}" />
		<input type="hidden" name="orderAmount" value="${orderAmount }"/>
		<input type="hidden" name="orderCurrency" value="${orderCurrency}" />
		<input type="hidden" name="orderDatetime" value="${orderDatetime}" />
		<input type="hidden" name="orderExpireDatetime" value="${orderExpireDatetime }"/>
		<input type="hidden" name="productName" value="${productName}" />
		<input type="hidden" name="productPrice" value="${productPrice}" />
		<input type="hidden" name="productNum" value="${productNum }"/>
		<input type="hidden" name="productId" value="${productId}" />
		<input type="hidden" name="productDesc" value="${productDesc}" />
		<input type="hidden" name="ext1" value="${ext1}" />
		<input type="hidden" name="ext2" value="${ext2}" />
		<input type="hidden" name="extTL" value="${extTL}" />
		<input type="hidden" name="payType" value="${payType}" />
		<input type="hidden" name="issuerId" value="${issuerId}" />
		<input type="hidden" name="signMsg" value="${sign }" />
	 </form>
 </body>
</html>