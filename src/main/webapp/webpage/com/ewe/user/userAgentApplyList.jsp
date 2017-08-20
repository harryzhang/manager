<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="userAgentApplyList" checkbox="true" fitColumns="false" title="用户省市审核" actionUrl="userAgentApplyController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户名"  field="user.name"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="手机"  field="user.userName"  query="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请类型"  field="agenttype" replace="省府_province,市区_city"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="省府"   field="province.province"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="市区"  field="city.city"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="status" replace="未审核_F,审核通过_T"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="申请时间"  field="createtime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="审核时间"  field="approvtime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="userAgentApplyController.do?doDel&id={id}" />
<%--    <t:dgToolBar title="录入" icon="icon-add" url="userAgentApplyController.do?goAdd" funname="add"></t:dgToolBar> --%>
   <t:dgToolBar title="审核" icon="icon-edit" url="userAgentApplyController.do?doUpdate&status=T" funname="updateStatus"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="userAgentApplyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="userAgentApplyController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/ewe/user/userAgentApplyList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#userAgentApplyListtb").find("input[name='createtime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#userAgentApplyListtb").find("input[name='createtime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#userAgentApplyListtb").find("input[name='approvtime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#userAgentApplyListtb").find("input[name='approvtime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'userAgentApplyController.do?upload', "userAgentApplyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("userAgentApplyController.do?exportXls","userAgentApplyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("userAgentApplyController.do?exportXlsByT","userAgentApplyList");
}
 </script>