<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eweWithdrawList" checkbox="true" fitColumns="false" title="提现列表" actionUrl="eweWithdrawController.do?datagrid&withdrawstatus=1" idField="withdrawid" fit="true" queryMode="group">
   <t:dgCol title="提现ID"  field="withdrawid"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
  <t:dgCol title="用户"  field="user.name" query="true"   queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="用户手机"  field="user.userName"  query="true"  queryMode="single"  width="80"></t:dgCol>
<%--     <t:dgCol title="提现积分"  field="withdrawcode" dictionary="acctype"   query="true" queryMode="single"  width="120"></t:dgCol> --%>
   <t:dgCol title="提现金额"  field="amount"    queryMode="group"  width="80"></t:dgCol>
   <t:dgCol title="提现比例"  field="charge"    queryMode="group"  width="80"></t:dgCol>
   <t:dgCol title="支付金额"  field="payamount"    queryMode="group"  width="80"></t:dgCol>
<%--    <t:dgCol title="用户支付宝"  field="user.userInfo.zfbnumber"    queryMode="group"  width="100"></t:dgCol> --%>
<%--    <t:dgCol title="用户微信"  field="user.userInfo.weixinNumber"    queryMode="group"  width="100"></t:dgCol> --%>
   <t:dgCol title="用户"  field="bankUser"    queryMode="group"  width="100"></t:dgCol>
   <t:dgCol title="用户银行"  field="bankName"    queryMode="group"  width="100"></t:dgCol>
<%--    <t:dgCol title="用户支行"  field="user.userInfo.bankSubbranch"    queryMode="group"  width="100"></t:dgCol> --%>
   <t:dgCol title="用户账号"  field="bankNo"    queryMode="group"  width="100"></t:dgCol>
    <t:dgCol title="创建时间"  field="createtime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="提现单状态"  field="withdrawstatus" replace="退本_2,提现_1,作废_0"   queryMode="group"  width="80"></t:dgCol>
   <t:dgCol title="付款状态"  field="paystatus" replace="已付款_1,待付_0"   queryMode="group"  width="80"></t:dgCol>
   <t:dgCol title="提现确定时间"  field="paytime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgDelOpt operationCode="delete" title="删除" url="eweWithdrawController.do?doDel&id={id}" /> --%>
   <t:dgToolBar operationCode="audit"  title="付款审核" icon="icon-add" url="eweWithdrawController.do?doUpdate&paystatus=1" funname="audit"></t:dgToolBar>
   <t:dgToolBar operationCode="pay"  title="在线支付" icon="icon-edit" url="eweWithdrawController.do?doPay" funname="pay"></t:dgToolBar>
   <t:dgToolBar operationCode="cz" title="帐户充值" icon="icon-edit" url="eweWithdrawController.do?goChongChi" funname="add" width="1024" height="600" ></t:dgToolBar>
   <%--<t:dgToolBar operationCode="delete" title="批量删除"  icon="icon-remove" url="eweWithdrawController.do?doBatchDel" funname="deleteALLSelectW"></t:dgToolBar>--%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="eweWithdrawController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/ewe/user/eweWithdrawList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#eweWithdrawListtb").find("input[name='createtime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#eweWithdrawListtb").find("input[name='createtime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#eweWithdrawListtb").find("input[name='paytime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#eweWithdrawListtb").find("input[name='paytime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
function audit(title,url){
	
	var rowsData = $('#eweWithdrawList').datagrid('getSelections');
//	if (rowData.id == '') {
//		tip('请选择查看项目');
//		return;
//	}
	
	if (!rowsData || rowsData.length == 0) {
		tip('请选择审核项目');
		return;
	}
	if (rowsData.length > 1) {
		tip('请选择一条记录再审核');
		return;
	}
    url += '&withdrawid='+rowsData[0].withdrawid;
	// 普通询问操作调用函数
	confirm(url, "审核此付款?","eweWithdrawList");
		
	
}
function pay(title,url){
	
	var rowsData = $('#eweWithdrawList').datagrid('getSelections');
	
	if (!rowsData || rowsData.length == 0) {
		tip('请选择付款项目');
		return;
	}
	if (rowsData.length > 1) {
		tip('请选择一条记录再付款');
		return;
	}
	//if (rowsData[0].paystatus == 1) {
	//	tip('当前记录已付款');
	//	return;
	//}
    url += '&withdrawid='+rowsData[0].withdrawid;
	// 普通询问操作调用函数
	confirm(url, "在线支付此笔付款?","eweWithdrawList");
		
	
}
function deleteALLSelectW(title,url,gname) {
	gridname=gname;
    var ids = [];
    var rows = $("#"+gname).datagrid('getSelections');
    if (rows.length > 0) {
    	$.dialog.setting.zIndex = getzIndex(true);
    	$.dialog.confirm('你确定永久删除该数据吗?', function(r) {
		   if (r) {
				for ( var i = 0; i < rows.length; i++) {
					ids.push(rows[i].withdrawid);
				}
				$.ajax({
					url : url,
					type : 'post',
					data : {
						ids : ids.join(',')
					},
					cache : false,
					success : function(data) {
						var d = $.parseJSON(data);
						if (d.success) {
							var msg = d.msg;
							tip(msg);
							reloadTable();
							$("#"+gname).datagrid('unselectAll');
							ids='';
						}
					}
				});
			}
		});
	} else {
		tip("请选择需要删除的数据");
	}
}
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'eweWithdrawController.do?upload', "eweWithdrawList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eweWithdrawController.do?exportXls","eweWithdrawList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eweWithdrawController.do?exportXlsByT","eweWithdrawList");
}
 </script>