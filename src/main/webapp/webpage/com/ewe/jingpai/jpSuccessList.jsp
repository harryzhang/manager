<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="jingpaiList" checkbox="true" fitColumns="false" title="竞拍管理" actionUrl="jingpaiController.do?successDatagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="商品"  field="gName"    queryMode="group"  width="120"></t:dgCol>
<%--    <t:dgCol title="竞拍开始时间"  field="starttime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="竞拍结束时间"  field="endtime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="竞拍开始价格"  field="startprice"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="竞拍底价"  field="lastprice"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="竞拍当前价格"  field="endprice"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="最后竞拍人"  field="lastuser"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="最后竞拍时间"  field="usertime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="竞拍状态"  field="status"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createtime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="userid"  field="userid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
<%--    <t:dgDelOpt title="删除" url="jingpaiController.do?doDel&id={id}" /> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="jingpaiController.do?goAdd" funname="add"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="编辑" icon="icon-edit" url="jingpaiController.do?goUpdate" funname="update"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="jingpaiController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="jingpaiController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/ewe/jingpai/jingpaiList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#jingpaiListtb").find("input[name='starttime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#jingpaiListtb").find("input[name='starttime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#jingpaiListtb").find("input[name='endtime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#jingpaiListtb").find("input[name='endtime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#jingpaiListtb").find("input[name='usertime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#jingpaiListtb").find("input[name='usertime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#jingpaiListtb").find("input[name='createtime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#jingpaiListtb").find("input[name='createtime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'jingpaiController.do?upload', "jingpaiList");
}

//导出
function ExportXls() {
	JeecgExcelExport("jingpaiController.do?exportXls","jingpaiList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("jingpaiController.do?exportXlsByT","jingpaiList");
}
 </script>