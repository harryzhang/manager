<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eweUserBetList" checkbox="true" fitColumns="false" title="竞猜下注列表" actionUrl="eweUserBetController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
<%--    <t:dgCol title="用户ID"  field="userid"    queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="期数"  field="periods"  query="true"  queryMode="single"  width="120"></t:dgCol>
<%--    <t:dgCol title="投注时间"  field="bettime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="投注金额"  field="amount"    queryMode="group"  width="120"></t:dgCol>
<%--    <t:dgCol title="状态"  field="status"    queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="投注号码"  field="betnumber"    queryMode="group"  width="120"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="eweUserBetController.do?doDel&id={id}" /> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="eweUserBetController.do?goAdd" funname="add"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="编辑" icon="icon-edit" url="eweUserBetController.do?goUpdate" funname="update"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="eweUserBetController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="eweUserBetController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/ewe/game/eweUserBetList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#eweUserBetListtb").find("input[name='bettime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#eweUserBetListtb").find("input[name='bettime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'eweUserBetController.do?upload', "eweUserBetList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eweUserBetController.do?exportXls","eweUserBetList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eweUserBetController.do?exportXlsByT","eweUserBetList");
}
 </script>