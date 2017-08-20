package com.ewe.user.controller;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.ewe.setting.entity.EweUserOptEntity;
import com.ewe.user.entity.EweUserAccountEntity;
import com.ewe.user.service.EweUserAccountServiceI;

/**   
 * @Title: Controller  
 * @Description: 用户账户
 * @author onlineGenerator
 * @date 2017-01-01 22:41:50
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/eweUserAccountController")
public class EweUserAccountController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EweUserAccountController.class);

	@Autowired
	private EweUserAccountServiceI eweUserAccountService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 用户账户列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/ewe/user/eweUserAccountList");
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
	public void datagrid(EweUserAccountEntity eweUserAccount,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(EweUserAccountEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eweUserAccount, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.eweUserAccountService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除用户账户
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(EweUserAccountEntity eweUserAccount, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		eweUserAccount = systemService.getEntity(EweUserAccountEntity.class, eweUserAccount.getId());
		message = "用户账户删除成功";
		try{
			eweUserAccountService.delete(eweUserAccount);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "用户账户删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除用户账户
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户账户删除成功";
		try{
			for(String id:ids.split(",")){
				EweUserAccountEntity eweUserAccount = systemService.getEntity(EweUserAccountEntity.class, 
				Integer.parseInt(id)
				);
				eweUserAccountService.delete(eweUserAccount);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "用户账户删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加用户账户
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(EweUserAccountEntity eweUserAccount, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户账户添加成功";
		try{
			eweUserAccountService.save(eweUserAccount);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "用户账户添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新用户账户
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(EweUserAccountEntity eweUserAccount, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
	
		message = "用户账户更新成功";
		EweUserAccountEntity t = eweUserAccountService.get(EweUserAccountEntity.class, eweUserAccount.getId());
		try {
			
			//返写操作记录
			EweUserOptEntity opt =new EweUserOptEntity();
			opt.setUser(t.getUser());
			opt.setPointType(t.getAccounttype());
			String oldAmount = t.getAmount();
			String newAmount = eweUserAccount.getAmount();
			opt.setAmount(new BigDecimal(newAmount).subtract(new BigDecimal(oldAmount)));
			opt.setRemark("管理员调整积分");
			systemService.save(opt);
			
			MyBeanUtils.copyBeanNotNull2Bean(eweUserAccount, t);
			
			
			eweUserAccountService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "用户账户更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 用户账户新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(EweUserAccountEntity eweUserAccount, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eweUserAccount.getId())) {
			eweUserAccount = eweUserAccountService.getEntity(EweUserAccountEntity.class, eweUserAccount.getId());
			req.setAttribute("eweUserAccountPage", eweUserAccount);
		}
		return new ModelAndView("com/ewe/user/eweUserAccount-add");
	}
	/**
	 * 用户账户编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(EweUserAccountEntity eweUserAccount, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eweUserAccount.getId())) {
			eweUserAccount = eweUserAccountService.getEntity(EweUserAccountEntity.class, eweUserAccount.getId());
			req.setAttribute("eweUserAccountPage", eweUserAccount);
		}
		return new ModelAndView("com/ewe/user/eweUserAccount-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","eweUserAccountController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(EweUserAccountEntity eweUserAccount,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(EweUserAccountEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eweUserAccount, request.getParameterMap());
		List<EweUserAccountEntity> eweUserAccounts = this.eweUserAccountService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"用户账户");
		modelMap.put(NormalExcelConstants.CLASS,EweUserAccountEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("用户账户列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,eweUserAccounts);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(EweUserAccountEntity eweUserAccount,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"用户账户");
    	modelMap.put(NormalExcelConstants.CLASS,EweUserAccountEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("用户账户列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<EweUserAccountEntity> listEweUserAccountEntitys = ExcelImportUtil.importExcel(file.getInputStream(),EweUserAccountEntity.class,params);
				for (EweUserAccountEntity eweUserAccount : listEweUserAccountEntitys) {
					eweUserAccountService.save(eweUserAccount);
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
	public List<EweUserAccountEntity> list() {
		List<EweUserAccountEntity> listEweUserAccounts=eweUserAccountService.getList(EweUserAccountEntity.class);
		return listEweUserAccounts;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		EweUserAccountEntity task = eweUserAccountService.get(EweUserAccountEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody EweUserAccountEntity eweUserAccount, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<EweUserAccountEntity>> failures = validator.validate(eweUserAccount);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			eweUserAccountService.save(eweUserAccount);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		int id = eweUserAccount.getId();
		URI uri = uriBuilder.path("/rest/eweUserAccountController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody EweUserAccountEntity eweUserAccount) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<EweUserAccountEntity>> failures = validator.validate(eweUserAccount);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			eweUserAccountService.saveOrUpdate(eweUserAccount);
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
		eweUserAccountService.deleteEntityById(EweUserAccountEntity.class, id);
	}
}
