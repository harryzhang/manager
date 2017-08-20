<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eweUserAccountList" checkbox="true" fitColumns="false" title="用户账户" actionUrl="eweUserAccountController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户名"  field="user.name"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户手机"  field="user.username"   query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="帐户金额"  field="amount"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="账户类型"  field="accounttype"  replace="现金_rmb,积分_point,证券数_security,激活豆_pet,分红金额_reffer" query="true" queryMode="single"  width="120"></t:dgCol>
<%--    <t:dgCol title="累计支出金额"  field="totalconsumeamount"    queryMode="group"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="累计收入金额"  field="totalinocmeamount"    queryMode="group"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="冻结金额"  field="frozendeposit"    queryMode="group"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="当天收益金额"  field="incomeamount"    queryMode="group"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="当天支出金额"  field="consueamount"    queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="更新时间"  field="updatetime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="累计提现金额"  field="withdrawtotaldeposit"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
<%--    <t:dgDelOpt title="删除" url="eweUserAccountController.do?doDel&id={id}" /> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="eweUserAccountController.do?goAdd" funname="add"></t:dgToolBar> --%>
   <t:dgToolBar operationCode="edit" title="编辑" icon="icon-edit" url="eweUserAccountController.do?goUpdate" funname="update"></t:dgToolBar>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="eweUserAccountController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
   <t:dgToolBar title="查看" icon="icon-search" url="eweUserAccountController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/ewe/user/eweUserAccountList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#eweUserAccountListtb").find("input[name='updatetime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#eweUserAccountListtb").find("input[name='updatetime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'eweUserAccountController.do?upload', "eweUserAccountList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eweUserAccountController.do?exportXls","eweUserAccountList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eweUserAccountController.do?exportXlsByT","eweUserAccountList");
}
 </script>