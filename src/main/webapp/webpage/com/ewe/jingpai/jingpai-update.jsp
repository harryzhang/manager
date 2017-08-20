<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>竞拍管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="jingpaiController.do?doUpdate" tiptype="1" >
					<input id="id" name="id" type="hidden" value="${jingpaiPage.id }">
					<input id="goods.id" name="goods.id" type="hidden" value="${jingpaiPage.goods.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								商品:
							</label>
						</td>
						<td class="value">
						     	 <input id="goodsName" name="goodsName" type="text" style="width: 150px" class="inputxt"  value='${jingpaiPage.goods.gname}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品ID</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								竞拍开始时间:
							</label>
						</td>
						<td class="value">
									  <input id="starttime" name="starttime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${jingpaiPage.starttime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">竞拍开始时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								竞拍结束时间:
							</label>
						</td>
						<td class="value">
									  <input id="endtime" name="endtime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${jingpaiPage.endtime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">竞拍结束时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								竞拍开始价格:
							</label>
						</td>
						<td class="value">
						     	 <input id="startprice" name="startprice" type="text" style="width: 150px" class="inputxt"  value='${jingpaiPage.startprice}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">竞拍开始价格</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								竞拍结束价格:
							</label>
						</td>
						<td class="value">
						     	 <input id="endprice" name="endprice" type="text" style="width: 150px" class="inputxt"  value='${jingpaiPage.endprice}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">竞拍结束价格</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								最后竞拍人:
							</label>
						</td>
						<td class="value">
						     	 <input id="lastuser" name="lastuser" type="text" style="width: 150px" class="inputxt"  value='${jingpaiPage.lastuser}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">最后竞拍人</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								最后竞拍时间:
							</label>
						</td>
						<td class="value">
									  <input id="usertime" name="usertime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${jingpaiPage.usertime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">最后竞拍时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								竞拍当前价格:
							</label>
						</td>
						<td class="value">
						     	 <input id="lastprice" name="lastprice" type="text" style="width: 150px" class="inputxt"  value='${jingpaiPage.lastprice}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">竞拍当前价格</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								竞拍状态:
							</label>
						</td>
						<td class="value">
						     	 <input id="status" name="status" type="text" style="width: 150px" class="inputxt"  value='${jingpaiPage.status}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">竞拍状态</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								创建时间:
							</label>
						</td>
						<td class="value">
									  <input id="createtime" name="createtime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${jingpaiPage.createtime}' type="date" pattern="yyyy-MM-dd"/>'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								userid:
							</label>
						</td>
						<td class="value">
						     	 <input id="userid" name="userid" type="text" style="width: 150px" class="inputxt"  value='${jingpaiPage.userid}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">userid</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/ewe/jingpai/jingpai.js"></script>		
