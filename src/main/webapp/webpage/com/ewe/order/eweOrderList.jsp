<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eweOrderList" checkbox="true" fitColumns="false" title="积分订单列表" actionUrl="eweOrderController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="订单ID"  field="orderid"    queryMode="group"  width="80"></t:dgCol>
   <t:dgCol title="订单号"  field="ordercode"    queryMode="group"  width="150"></t:dgCol>
   <t:dgCol title="用户名" query="true"  field="user.name"    queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="用户手机" query="true" field="user.userName"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="发货地址"  field="user.userInfo.contactaddress"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="商品名"  field="goods.gname"    queryMode="group"  width="150"></t:dgCol>
   <t:dgCol title="商品数量"  field="qty"    queryMode="group"  width="80"></t:dgCol>
   <t:dgCol title="商品单价"  field="price"    queryMode="group"  width="80"></t:dgCol>
   <t:dgCol title="商品总价格"  field="totalprice"    queryMode="group"  width="80"></t:dgCol>
<%--    <t:dgCol title="收货地址"  field="recaddress"    queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="创建时间"  field="createtime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单状态"  field="orderstatus"  replace="正常_1,作废_0"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="发货状态"  field="paystatus"  replace="已发货_1,待发货_0"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="付款确定时间"  field="paytime" formatter="yyyy-MM-dd" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="订单类型"  field="ordertype"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="eweOrderController.do?doDel&id={id}" /> --%>
   <t:dgToolBar title="发货确认" icon="icon-add" url="eweOrderController.do?doUpdate&paystatus=1" funname="audit"></t:dgToolBar>
<%--    <t:dgToolBar title="编辑" icon="icon-edit" url="eweOrderController.do?Update" funname="update"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="eweOrderController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="eweOrderController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/ewe/order/eweOrderList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#eweOrderListtb").find("input[name='createtime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#eweOrderListtb").find("input[name='createtime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#eweOrderListtb").find("input[name='paytime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#eweOrderListtb").find("input[name='paytime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
 function audit(title,url){
		
		var rowsData = $('#eweOrderList').datagrid('getSelections');
//		if (rowData.id == '') {
//			tip('请选择查看项目');
//			return;
//		}
		
		if (!rowsData || rowsData.length == 0) {
			tip('确认发货');
			return;
		}
		if (rowsData.length > 1) {
			tip('请选择一条记录再确认');
			return;
		}
	    url += '&orderid='+rowsData[0].orderid;
		// 普通询问操作调用函数
		confirm(url, "确认发货?","eweOrderList");
			
 }
		
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'eweOrderController.do?upload', "eweOrderList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eweOrderController.do?exportXls","eweOrderList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eweOrderController.do?exportXlsByT","eweOrderList");
}
 </script>