<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eweUserOptList" checkbox="true" fitColumns="false" title="用户积分操记录" actionUrl="eweUserOptController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作人"  field="createName"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="登录名称"  field="createBy"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称" field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"    field="updateDate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"   field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"   field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作用户"  field="user.name"   query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户手机"  field="user.userName"     queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作积分"  field="pointType"    replace="现金_rmb,积分_point,证券数_security,激活豆_pet,分红金额_reffer" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="变更金额"  field="amount"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remark"    queryMode="single"  width="120"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt title="删除" url="eweUserOptController.do?doDel&id={id}" /> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="eweUserOptController.do?goAdd" funname="add"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="编辑" icon="icon-edit" url="eweUserOptController.do?goUpdate" funname="update"></t:dgToolBar> --%>
   <%-- <t:dgToolBar operationCode="delete" title="批量删除"  icon="icon-remove" url="eweUserOptController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="eweUserOptController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/ewe/setting/eweUserOptList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#eweUserOptListtb").find("input[name='createDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#eweUserOptListtb").find("input[name='updateDate']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'eweUserOptController.do?upload', "eweUserOptList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eweUserOptController.do?exportXls","eweUserOptList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eweUserOptController.do?exportXlsByT","eweUserOptList");
}
 </script>