<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>商品信息表</title>
  <t:base type="ckfinder,ckeditor,jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="eweGoodsController.do?doUpdate" tiptype="1" >
					<input id="goodsid" name="goodsid" type="hidden" value="${eweGoodsPage.goodsid }">
					<input id="id" name="id" type="hidden" value="${eweGoodsPage.id }">
					<input id="status" name="status" type="hidden" value="${eweGoodsPage.status }">
					<input id="gunite" name="gunite" type="hidden" value="${eweGoodsPage.gunite }">
					<input id="gkind" name="gkind" type="hidden" value="${eweGoodsPage.gkind }">
					<input id="createtime" name="createtime" type="hidden" value="${eweGoodsPage.createtime }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								商品名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="gname" name="gname" type="text" style="width: 150px" class="inputxt"  value='${eweGoodsPage.gname}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								商品描述:
							</label>
						</td>
						<td class="value">
						     	 <input id="gdesc" name="gdesc" type="text" style="width: 150px" class="inputxt"  value='${eweGoodsPage.gdesc}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品描述</label>
						</td>
					</tr>
					<tr>
					<td align="right">
						<label class="Validform_label">
							价格:
						</label>
					</td>
					<td class="value">
					     	 <input id="price" name="price" type="text" value="${eweGoodsPage.price}" datatype="d" style="width: 150px" class="inputxt" >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">价格</label>
						</td>
						<td align="right">
						<label class="Validform_label">
							品牌:
						</label>
					</td>
					<td class="value">
					     	 <input id="bandname" name="bandname" type="text" style="width: 150px" class="inputxt" value='${eweGoodsPage.bandname}' >
						
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">bandname</label>
						</td>
<!-- 						<td align="right"> -->
<!-- 						<label class="Validform_label"> -->
<!-- 							状态: -->
<!-- 						</label> -->
<!-- 					</td> -->
<!-- 					<td class="value"> -->
<!-- 					     	 <input id="status" name="status" type="text" style="width: 150px" class="inputxt" > -->
<!-- 							<span class="Validform_checktip"></span> -->
<!-- 							<label class="Validform_label" style="display: none;">状态</label> -->
<!-- 						</td> -->
				<tr>
					<td align="right">
						<label class="Validform_label">
							品类:
						</label>
					</td>
					<td class="value">
<!-- 					     	 <input id="gcate" name="gcate" type="text" style="width: 150px" class="inputxt" > -->
								<t:dictSelect field="gcate" typeGroupCode="gCate"  hasLabel="false" defaultVal="${eweGoodsPage.gcate}"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">品类</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							属性:
						</label>
					</td>
					<td class="value">
<!-- 					     	 <input id="gcate" name="gcate" type="text" style="width: 150px" class="inputxt" > -->
								<t:dictSelect field="gcode" typeGroupCode="gCode"  hasLabel="false" defaultVal="${eweGoodsPage.gcode}"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">属性</label>
						</td>
<!-- 					<td align="right"> -->
<!-- 						<label class="Validform_label"> -->
<!-- 							单位: -->
<!-- 						</label> -->
<!-- 					</td> -->
<!-- 					<td class="value"> -->
<!-- 					     	 <input id="gunite" name="gunite" type="text" style="width: 150px" class="inputxt" > -->
<!-- 							<span class="Validform_checktip"></span> -->
<!-- 							<label class="Validform_label" style="display: none;">单位</label> -->
<!-- 						</td> -->
					</tr>
				<tr>
					
<!-- 					<td align="right"> -->
<!-- 						<label class="Validform_label"> -->
<!-- 							类别: -->
<!-- 						</label> -->
<!-- 					</td> -->
<!-- 					<td class="value"> -->
<!-- 					     	 <input id="gkind" name="gkind" type="text" style="width: 150px" class="inputxt" > -->
<!-- 							<span class="Validform_checktip"></span> -->
<!-- 							<label class="Validform_label" style="display: none;">类别</label> -->
<!-- 						</td> -->
					</tr>
				<tr>
			
					
					</tr>
				<tr>
				<td align="right">
						<label class="Validform_label">
							缩略图:
						</label>
					</td>
					<td class="value">
<!-- 					     	 <input id="imagesrc" name="imagesrc" type="text" style="width: 150px" class="inputxt" > -->
<%-- 		<t:upload name="fiels" buttonText="上传文件" uploader="systemController.do?saveFiles"  extend="pic" id="file_upload"  formData="imagesrc"></t:upload> --%>
	<t:ckfinder name="imagesrc" uploadType="Images"  width="100" height="60" buttonClass="ui-button" value="${eweGoodsPage.imagesrc}" buttonValue="上传图片"></t:ckfinder>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">缩略图</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							大图片:
						</label>
					</td>
					<td class="value">
<!-- 					     	 <input id="bigimagesrc" name="bigimagesrc" type="text" style="width: 150px" class="inputxt" > -->
								<t:ckfinder name="bigimagesrc" uploadType="Images"  width="100" height="60" value="${eweGoodsPage.bigimagesrc}" buttonClass="ui-button" buttonValue="上传图片"></t:ckfinder>
	
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">bigimagesrc</label>
						</td>
					
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/goods/eweGoods.js"></script>		
