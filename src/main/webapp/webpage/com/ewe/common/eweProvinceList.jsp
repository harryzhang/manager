<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eweProvinceList" checkbox="true" fitColumns="false" title="省代码" actionUrl="eweProvinceController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="provinceid"  field="provinceid"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="province"  field="province"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="eweProvinceController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="eweProvinceController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="eweProvinceController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="eweProvinceController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="eweProvinceController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/ewe/common/eweProvinceList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'eweProvinceController.do?upload', "eweProvinceList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eweProvinceController.do?exportXls","eweProvinceList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eweProvinceController.do?exportXlsByT","eweProvinceList");
}
 </script>