package com.ewe.user.controller;
import com.ewe.user.entity.EweUserEntity;
import com.ewe.user.entity.EweUserInfoEntity;
import com.ewe.user.entity.EweWithdrawEntity;
import com.ewe.user.service.EweWithdrawServiceI;
import com.smartpay.ops.client.RequestOrder;
import com.smartpay.ops.client.web.MerchantClient;
import com.smartpay.ops.pay.Singlepay;
import com.smartpay.ops.single.dto.impl.response.Response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller  
 * @Description: 提现列表
 * @author onlineGenerator
 * @date 2016-11-07 14:54:21
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/eweWithdrawController")
public class EweWithdrawController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EweWithdrawController.class);

	@Autowired
	private EweWithdrawServiceI eweWithdrawService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 提现列表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/ewe/user/eweWithdrawList");
	}
	@RequestMapping(params = "returnList")
	public ModelAndView returnList(HttpServletRequest request) {
		return new ModelAndView("com/ewe/user/eweReturnList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(EweWithdrawEntity eweWithdraw,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(EweWithdrawEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eweWithdraw, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.eweWithdrawService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除提现列表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(EweWithdrawEntity eweWithdraw, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		eweWithdraw = systemService.getEntity(EweWithdrawEntity.class, eweWithdraw.getWithdrawid());
		message = "提现列表删除成功";
		try{
			eweWithdrawService.delete(eweWithdraw);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提现列表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除提现列表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提现列表删除成功";
		try{
			for(String id:ids.split(",")){
				EweWithdrawEntity eweWithdraw = systemService.getEntity(EweWithdrawEntity.class, 
				Integer.parseInt(id)
				);
				eweWithdrawService.delete(eweWithdraw);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "提现列表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加提现列表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(EweWithdrawEntity eweWithdraw, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提现列表添加成功";
		try{
			eweWithdraw.setPaytime(new Date());
			eweWithdrawService.save(eweWithdraw);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提现列表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新提现列表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(EweWithdrawEntity eweWithdraw, HttpServletRequest request) {
		String message = null;
		String online = request.getParameter("online");
		if(StringUtils.isNotBlank(online)){
			return doPay(eweWithdraw,request);
		}
		
		
		AjaxJson j = new AjaxJson();
		message = "提现列表更新成功";
		EweWithdrawEntity t = eweWithdrawService.get(EweWithdrawEntity.class, eweWithdraw.getWithdrawid());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(eweWithdraw, t);
			eweWithdrawService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "提现列表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	
	
	/**
	 * 用户付款
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doPay",consumes="application/json")
	@ResponseBody
	public AjaxJson doPay(EweWithdrawEntity eweWithdraw, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "付款成功";
		EweWithdrawEntity t = eweWithdrawService.get(EweWithdrawEntity.class, eweWithdraw.getWithdrawid());
		try {
			EweUserEntity user= t.getUser();
			if( null ==user ){
				message = "付款失败,提现用户不存在";
			}else{
				
//				EweUserInfoEntity userInfo = user.getUserInfo();
//				String userAccount =  userInfo.getBankaccount();
//				String userBank =  userInfo.getBankname();
//				String usersub =userInfo.getBanksubbranch();
//				String usersub =userInfo.getBanksubbranch();
				String userName = t.getBankUser();
				String userAccount =  t.getBankNo();
				String userBank =  t.getBankName();
				String usersub = "";
				if( StringUtils.isNotBlank(userBank) && StringUtils.isNotBlank(usersub)){
					userBank = userBank + usersub;
				}
				
				String amt = "" + t.getPayamount().multiply(new BigDecimal("100")).setScale(0);
				if(StringUtils.isNotBlank(userAccount) && StringUtils.isNotBlank(userName) &&
						StringUtils.isNotBlank(userBank) ){
					String returnMsg = Singlepay.pay(userAccount, userName, amt, userBank, null);
					if(  returnMsg.startsWith("支付成功") ){
						t.setPaystatus(1);
						t.setPaytime(new Date());
//						t.setWithdrawcode(returnMsg);
						eweWithdrawService.saveOrUpdate(t);
					}
					message = "付款失败," + returnMsg;
					
				}else{
					message = "付款失败,提现用户真空姓名、银行卡号、开户行资料不全,请检查。";
				}
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			message = "付款失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 提现列表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(EweWithdrawEntity eweWithdraw, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eweWithdraw.getWithdrawid())) {
			eweWithdraw = eweWithdrawService.getEntity(EweWithdrawEntity.class, eweWithdraw.getWithdrawid());
			req.setAttribute("eweWithdrawPage", eweWithdraw);
		}
		return new ModelAndView("com/ewe/user/eweWithdraw-add");
	}
	/**
	 * 提现列表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goChongChi")
	public ModelAndView goChongChi(EweWithdrawEntity eweWithdraw, HttpServletRequest req) {
		return new ModelAndView("com/ewe/user/eweWithdraw-chongchi");
	}
	/**
	 * 提现列表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "postChongzhi")
	public ModelAndView postChongzhi(EweWithdrawEntity eweWithdraw, HttpServletRequest request,
			HttpServletRequest req) {
		String error = "";
		try {
			request.setCharacterEncoding("UTF-8");

			String serverUrl = request.getParameter("serverUrl");
			String key = request.getParameter("key");
			String version = request.getParameter("version");
			String language = request.getParameter("language");
			String inputCharset = request.getParameter("inputCharset");
			String merchantId = request.getParameter("merchantId");
			String pickupUrl = request.getParameter("pickupUrl");
			String receiveUrl = request.getParameter("receiveUrl");
			String payType = request.getParameter("payType");
			String signType = request.getParameter("signType");
			String orderNo = request.getParameter("orderNo");
			String orderAmount = request.getParameter("orderAmount");
			String orderDatetime = request.getParameter("orderDatetime");
			String orderCurrency = request.getParameter("orderCurrency");
			String orderExpireDatetime = request.getParameter("orderExpireDatetime");
			String payerTelephone = request.getParameter("payerTelephone");
			String payerEmail = request.getParameter("payerEmail");
			String payerName = request.getParameter("payerName");
			String productName = request.getParameter("productName");
			String productId = request.getParameter("productId");
			String productNum = request.getParameter("productNum");
			String productPrice = request.getParameter("productPrice");
			String productDesc = request.getParameter("productDesc");
			String ext1 = request.getParameter("ext1");
			String ext2 = request.getParameter("ext2");
			String extTL = request.getParameter("extTL");
			String issuerId = request.getParameter("issuerId");

			String sign = "";
		
			String signSrc = "";

			RequestOrder order = new RequestOrder();
			order.setExtTL(extTL);
			order.setInputCharset(Integer.parseInt(inputCharset));
			order.setPickupUrl(pickupUrl);
			order.setReceiveUrl(receiveUrl);
			order.setVersion(version);
			order.setLanguage(Integer.parseInt(language));
			order.setSignType(Integer.parseInt(signType));
			order.setMerchantId(merchantId);
			order.setPayerName(payerName);
			order.setPayerEmail(payerEmail);
			order.setPayerTelephone(payerTelephone);
			order.setOrderNo(orderNo);
			order.setOrderAmount(Long.parseLong(orderAmount));
			order.setOrderCurrency(orderCurrency);
			order.setOrderDatetime(orderDatetime);
			order.setOrderExpireDatetime(orderExpireDatetime);
			order.setProductName(productName);
			order.setProductPrice(Long.parseLong(productPrice));
			order.setProductNum(Integer.parseInt(productNum));
			order.setProductId(productId);
			order.setProductDesc(productDesc);

			order.setExt1(ext1);
			order.setExt2(ext2);
			order.setPayType(Integer.parseInt(payType));
			order.setIssuerId(issuerId);
			order.setKey(key);
			signSrc = new MerchantClient().generateSignSrc(order);
			sign = new MerchantClient().sign(order);
			
			request.setAttribute("serverUrl", serverUrl);
			request.setAttribute("key", key);
			request.setAttribute("version", version);
			request.setAttribute("language",language);
			request.setAttribute("inputCharset",inputCharset);
			request.setAttribute("merchantId",merchantId);
			request.setAttribute("pickupUrl",pickupUrl);
			request.setAttribute("receiveUrl",receiveUrl);
			request.setAttribute("payType",payType);
			request.setAttribute("signType",signType);
			request.setAttribute("orderNo",orderNo);
			request.setAttribute("orderAmount",orderAmount);
			request.setAttribute("orderDatetime",orderDatetime);
			request.setAttribute("orderCurrency",orderCurrency);
			request.setAttribute("orderExpireDatetime",orderExpireDatetime);
			request.setAttribute("payerTelephone",payerTelephone);
			request.setAttribute("payerEmail",payerEmail);
			request.setAttribute("payerName",payerName);
			request.setAttribute("productName",productName);
			request.setAttribute("productId",productId);
			request.setAttribute("productNum",productNum);
			request.setAttribute("productPrice",productPrice);
			request.setAttribute("productDesc",productDesc);
			request.setAttribute("ext1",ext1);
			request.setAttribute("ext2",ext2);
			request.setAttribute("extTL",extTL);
			request.setAttribute("sign",sign);
			request.setAttribute("signSrc",signSrc);
			request.setAttribute("issuerId",issuerId);
		} catch (Exception e) {
			error = "error";
		}
		request.setAttribute("error",error);
		return new ModelAndView("com/ewe/user/eweWithdraw-dochongchi");
	}
	/**
	 * 提现列表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(EweWithdrawEntity eweWithdraw, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eweWithdraw.getWithdrawid())) {
			eweWithdraw = eweWithdrawService.getEntity(EweWithdrawEntity.class, eweWithdraw.getWithdrawid());
			req.setAttribute("eweWithdrawPage", eweWithdraw);
		}
		return new ModelAndView("com/ewe/user/eweWithdraw-update");
	}

	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","eweWithdrawController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(EweWithdrawEntity eweWithdraw,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(EweWithdrawEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eweWithdraw, request.getParameterMap());
		List<EweWithdrawEntity> eweWithdraws = this.eweWithdrawService.getListByCriteriaQuery(cq,false);
		for (EweWithdrawEntity withdraw : eweWithdraws) {
			withdraw.setName(withdraw.getUser().getName());
			withdraw.setUserName(withdraw.getUser().getUsername());
			withdraw.setZfb(withdraw.getUser().getUserInfo().getZfbnumber());
			withdraw.setWeixin(withdraw.getUser().getUserInfo().getWeixinumber());
		}
		
		modelMap.put(NormalExcelConstants.FILE_NAME,"提现列表");
		modelMap.put(NormalExcelConstants.CLASS,EweWithdrawEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("提现列表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,eweWithdraws);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(EweWithdrawEntity eweWithdraw,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"提现列表");
    	modelMap.put(NormalExcelConstants.CLASS,EweWithdrawEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("提现列表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<EweWithdrawEntity> listEweWithdrawEntitys = ExcelImportUtil.importExcel(file.getInputStream(),EweWithdrawEntity.class,params);
				for (EweWithdrawEntity eweWithdraw : listEweWithdrawEntitys) {
					eweWithdrawService.save(eweWithdraw);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<EweWithdrawEntity> list() {
		List<EweWithdrawEntity> listEweWithdraws=eweWithdrawService.getList(EweWithdrawEntity.class);
		return listEweWithdraws;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		EweWithdrawEntity task = eweWithdrawService.get(EweWithdrawEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody EweWithdrawEntity eweWithdraw, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<EweWithdrawEntity>> failures = validator.validate(eweWithdraw);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			eweWithdrawService.save(eweWithdraw);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		int id = eweWithdraw.getWithdrawid();
		URI uri = uriBuilder.path("/rest/eweWithdrawController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody EweWithdrawEntity eweWithdraw) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<EweWithdrawEntity>> failures = validator.validate(eweWithdraw);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			eweWithdrawService.saveOrUpdate(eweWithdraw);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		eweWithdrawService.deleteEntityById(EweWithdrawEntity.class, id);
	}
}
