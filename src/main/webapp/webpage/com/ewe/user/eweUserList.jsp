<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eweUserList" checkbox="true" fitColumns="false" title="用户列表" actionUrl="eweUserController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"   queryMode="group"  width="80"></t:dgCol>
   <t:dgCol title="用户名"  field="username"  query="true"  queryMode="single"  width="120"></t:dgCol>
     <t:dgCol title="名称"  field="name"  query="true"  queryMode="single"  width="100"></t:dgCol>
  
<%--    <t:dgCol title="用户密码"  field="password"    queryMode="group"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="二级密码"  field="passwordtwo"    queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="当前等级"  field="grade"  replace="普通_0,一级_1,二级_2,三级_3,四级_4,五级_5,六级_6,"  query="true" queryMode="single"  width="60"></t:dgCol>
<%--    <t:dgCol title="组织机构"  field="organ"    queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="备注"  field="remark"    queryMode="group"  width="120"></t:dgCol>
<%--    <t:dgCol title="状态"  field="enabled"    queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="推荐人编号"  field="referrerid"    queryMode="group"  width="80"></t:dgCol>
   <t:dgCol title="推人数量"  field="parentid"    queryMode="group"  width="60"></t:dgCol>
<%--    <t:dgCol title="业务方向"  field="treenode"    queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="创建时间"  field="creatortime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="修改时间"  field="updatetime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
<%--   <t:dgCol title="积分"  field="bonus"    queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="状态"  field="status"  replace="正常_1,系统用户_4"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户级别"  field="enabled"  replace="总监_1,董事_2"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="报单中心"  field="organ"  replace="报单中心_3"   queryMode="group"  width="120"></t:dgCol>
<%--    <t:dgCol title="joinmoney"  field="joinmoney"    queryMode="group"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="optuserid"  field="optuserid"    queryMode="group"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="isbackmoney"  field="isbackmoney"    queryMode="group"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="optremark"  field="optremark"    queryMode="group"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="iszengsong"  field="iszengsong"    queryMode="group"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="weixin"  field="weixin"    queryMode="group"  width="120"></t:dgCol> --%>
<%--    <t:dgCol title="zhifubao"  field="zhifubao"    queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="用户编码"  field="usercode"    queryMode="group"  width="120"></t:dgCol>
<%--    <t:dgCol title="openid"  field="openid"    queryMode="group"  width="120"></t:dgCol> --%>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="eweUserController.do?doDel&id={id}" />
   <t:dgToolBar operationCode="one" title="一级股东" icon="icon-add" url="eweUserController.do?doUpdate&grade=1" funname="updateStatus"></t:dgToolBar>
   <t:dgToolBar operationCode="two" title="二级股东" icon="icon-edit" url="eweUserController.do?doUpdate&grade=2" funname="updateStatus"></t:dgToolBar>
   <t:dgToolBar operationCode="three"  title="三级股东" icon="icon-edit" url="eweUserController.do?doUpdate&grade=3" funname="updateStatus"></t:dgToolBar>
   <t:dgToolBar operationCode="four" title="四级股东" icon="icon-edit" url="eweUserController.do?doUpdate&grade=4" funname="updateStatus"></t:dgToolBar>
   <t:dgToolBar operationCode="five" title="五级股东" icon="icon-edit" url="eweUserController.do?doUpdate&grade=5" funname="updateStatus"></t:dgToolBar>
   <t:dgToolBar operationCode="six" title="六级股东" icon="icon-edit" url="eweUserController.do?doUpdate&grade=6" funname="updateStatus"></t:dgToolBar>
   <t:dgToolBar operationCode="delete" title="批量删除"  icon="icon-remove" url="eweUserController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="eweUserController.do?goUpdate" funname="detail" ></t:dgToolBar>
   <t:dgToolBar title="用户结构树" icon="icon-search" url="http://www.skwuas.top/member/userManager.html?uid=100" funname="detail" width="500" height="550" ></t:dgToolBar>
<%--   <t:dgToolBar title="编辑" icon="icon-edit" url="eweUserController.do?goUpdate" funname="update"></t:dgToolBar> --%>
      <t:dgToolBar operationCode="edit" title="编辑" icon="icon-edit" url="eweUserController.do?goUpdate" funname="update"></t:dgToolBar>
   
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/ewe/user/eweUserList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#eweUserListtb").find("input[name='creatortime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#eweUserListtb").find("input[name='creatortime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#eweUserListtb").find("input[name='updatetime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#eweUserListtb").find("input[name='updatetime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'eweUserController.do?upload', "eweUserList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eweUserController.do?exportXls","eweUserList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eweUserController.do?exportXlsByT","eweUserList");
}
 </script>