<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="eweGoodsList" checkbox="true" fitColumns="false" title="商品信息表" actionUrl="eweGoodsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="商品ID"  field="goodsid" hidden="true"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="商品名称"  field="gname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="商品描述"  field="gdesc"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="status" hidden="true"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="商品代码"  field="gcode"  dictionary="gCode"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="品类"  field="gcate"  dictionary="gCate"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="gunite"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="价格"  field="price"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="类别"  field="gkind"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建时间"  field="createtime" formatter="yyyy-MM-dd"   queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="列表图"  field="imagesrc"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="大图"  field="bigimagesrc"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="品牌名"  field="bandname"    queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="id"  field="id" hidden="true"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="eweGoodsController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="eweGoodsController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="eweGoodsController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="eweGoodsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="eweGoodsController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/ewe/goods/eweGoodsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#eweGoodsListtb").find("input[name='createtime_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#eweGoodsListtb").find("input[name='createtime_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'eweGoodsController.do?upload', "eweGoodsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("eweGoodsController.do?exportXls","eweGoodsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("eweGoodsController.do?exportXlsByT","eweGoodsList");
}
 </script>