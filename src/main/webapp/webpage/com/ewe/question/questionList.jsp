<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="questionList" checkbox="true"  fitColumns="false" sortName="createTime" sortOrder="desc" title="问题反馈" actionUrl="questionController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户手机"  field="user.userName"  query="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户名"  field="user.name"    queryMode="group"  width="120"></t:dgCol>
<%--    <t:dgCol title="主题"  field="theme"   hidden="true" queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="内容"  field="content"    queryMode="group"  width="450"></t:dgCol>
   <t:dgCol title="是否反馈"  field="theme"   queryMode="group"  width="120"></t:dgCol> 
   <t:dgCol title="创建时间"  field="createTime"   formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   
<%--   <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="questionController.do?doDel&id={id}" /> --%>
   <t:dgToolBar title="留言反馈、查看" icon="icon-add" url="questionFeedbackController.do?goUpdate" funname="update"></t:dgToolBar>
<%--    <t:dgToolBar title="留言查看" icon="icon-search" url="questionFeedbackController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="questionController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="questionController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="questionController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/ewe/question/questionList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#questionListtb").find("input[name='createTime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#questionListtb").find("input[name='createTime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'questionController.do?upload', "questionList");
}

//导出
function ExportXls() {
	JeecgExcelExport("questionController.do?exportXls","questionList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("questionController.do?exportXlsByT","questionList");
}
 </script>