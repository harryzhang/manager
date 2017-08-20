<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eweUserInfoList" checkbox="true" fitColumns="false" title="用户基本资料" actionUrl="eweUserInfoController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="60"></t:dgCol>
   <t:dgCol title="用户id"  field="userid"    queryMode="group"  width="100"></t:dgCol>
   <t:dgCol title="真实姓名"  field="realname"  query="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="身份证号"  field="idcardno"    queryMode="group"  width="160"></t:dgCol>
   <t:dgCol title="性别"  field="sex"    queryMode="group"  width="60"></t:dgCol>
   <t:dgCol title="联系地址"  field="contactaddress"    queryMode="group"  width="220"></t:dgCol>
   <t:dgCol title="手机号码"  field="mobile"  query="true"  queryMode="single"  width="120"></t:dgCol>
<%--    <t:dgCol title="用户邮箱"  field="email"    queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="微信号"  field="weixinumber"    queryMode="group"  width="120"></t:dgCol>
<%--    <t:dgCol title="QQ号"  field="qqnumber"    queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="支付宝"  field="zfbnumber"    queryMode="group"  width="120"></t:dgCol>
<%--    <t:dgCol title="财付通"  field="cftnumber"    queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="开户银行"  field="bankname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开户省份"  field="province"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开户市区"  field="city"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="银行支行"  field="banksubbranch"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="银行账号"  field="bankaccount"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开户姓名"  field="openaccount"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
<%--    <t:dgDelOpt title="删除" url="eweUserInfoController.do?doDel&id={id}" /> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="eweUserInfoController.do?goAdd" funname="add"></t:dgToolBar> --%>
   <t:dgToolBar operationCode="edit" title="编辑" icon="icon-edit" url="eweUserInfoController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar operationCode="delete" title="批量删除"  icon="icon-remove" url="eweUserInfoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar  title="查看" icon="icon-search" url="eweUserInfoController.do?goUpdate" funname="detail"></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/ewe/user/eweUserInfoList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'eweUserInfoController.do?upload', "eweUserInfoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eweUserInfoController.do?exportXls","eweUserInfoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eweUserInfoController.do?exportXlsByT","eweUserInfoList");
}
 </script>