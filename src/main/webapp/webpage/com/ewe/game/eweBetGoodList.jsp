<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eweBetGoodList" checkbox="true" fitColumns="false" title="中奖号码" actionUrl="eweBetGoodController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="期数"  field="periods"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="号码"  field="betnumber"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人"  field="createName"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createDate" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="eweBetGoodController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="eweBetGoodController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="eweBetGoodController.do?goUpdate" funname="update"></t:dgToolBar>
   <%-- <t:dgToolBar title="批量删除"  icon="icon-remove" url="eweBetGoodController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="eweBetGoodController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/ewe/game/eweBetGoodList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#eweBetGoodListtb").find("input[name='createDate_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#eweBetGoodListtb").find("input[name='createDate_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'eweBetGoodController.do?upload', "eweBetGoodList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eweBetGoodController.do?exportXls","eweBetGoodList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eweBetGoodController.do?exportXlsByT","eweBetGoodList");
}
 </script>