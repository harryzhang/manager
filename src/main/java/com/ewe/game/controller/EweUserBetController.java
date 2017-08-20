package com.ewe.game.controller;
import com.ewe.game.entity.EweUserBetEntity;
import com.ewe.game.service.EweUserBetServiceI;
import java.util.ArrayList;
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
import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
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
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.core.util.DBTypeUtil;
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
 * @Description: 竞猜下注列表
 * @author onlineGenerator
 * @date 2016-10-12 19:51:08
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/eweUserBetController")
public class EweUserBetController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EweUserBetController.class);

	@Autowired
	private EweUserBetServiceI eweUserBetService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 竞猜下注列表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/ewe/game/eweUserBetList");
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
	public void datagrid(EweUserBetEntity eweUserBet,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		String param = "periods = (select max(periods) from  t_user_bet ) ";
		if(null != eweUserBet.getPeriods() && eweUserBet.getPeriods() !=0){
			param = " periods =" +  eweUserBet.getPeriods() + " ";
		}
		
		String betSql = " select betNumber,sum(amount) amount,periods from t_user_bet  "
				  + " where   1=1  and " + param
				  + " group by betNumber,periods";
		List<Map<String,Object>> maplist=systemService.findForJdbc(betSql);
	
		
		dataGrid.setTotal(6);
		dataGrid.setResults(maplist);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除竞猜下注列表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(EweUserBetEntity eweUserBet, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		eweUserBet = systemService.getEntity(EweUserBetEntity.class, eweUserBet.getId());
		message = "竞猜下注列表删除成功";
		try{
			eweUserBetService.delete(eweUserBet);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "竞猜下注列表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除竞猜下注列表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "竞猜下注列表删除成功";
		try{
			for(String id:ids.split(",")){
				EweUserBetEntity eweUserBet = systemService.getEntity(EweUserBetEntity.class, 
				Integer.parseInt(id)
				);
				eweUserBetService.delete(eweUserBet);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "竞猜下注列表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加竞猜下注列表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(EweUserBetEntity eweUserBet, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "竞猜下注列表添加成功";
		try{
			eweUserBetService.save(eweUserBet);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "竞猜下注列表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新竞猜下注列表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(EweUserBetEntity eweUserBet, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "竞猜下注列表更新成功";
		EweUserBetEntity t = eweUserBetService.get(EweUserBetEntity.class, eweUserBet.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(eweUserBet, t);
			eweUserBetService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "竞猜下注列表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 竞猜下注列表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(EweUserBetEntity eweUserBet, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eweUserBet.getId())) {
			eweUserBet = eweUserBetService.getEntity(EweUserBetEntity.class, eweUserBet.getId());
			req.setAttribute("eweUserBetPage", eweUserBet);
		}
		return new ModelAndView("com/ewe/game/eweUserBet-add");
	}
	/**
	 * 竞猜下注列表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(EweUserBetEntity eweUserBet, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eweUserBet.getId())) {
			eweUserBet = eweUserBetService.getEntity(EweUserBetEntity.class, eweUserBet.getId());
			req.setAttribute("eweUserBetPage", eweUserBet);
		}
		return new ModelAndView("com/ewe/game/eweUserBet-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","eweUserBetController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(EweUserBetEntity eweUserBet,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(EweUserBetEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eweUserBet, request.getParameterMap());
		List<EweUserBetEntity> eweUserBets = this.eweUserBetService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"竞猜下注列表");
		modelMap.put(NormalExcelConstants.CLASS,EweUserBetEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("竞猜下注列表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,eweUserBets);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(EweUserBetEntity eweUserBet,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"竞猜下注列表");
    	modelMap.put(NormalExcelConstants.CLASS,EweUserBetEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("竞猜下注列表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<EweUserBetEntity> listEweUserBetEntitys = ExcelImportUtil.importExcel(file.getInputStream(),EweUserBetEntity.class,params);
				for (EweUserBetEntity eweUserBet : listEweUserBetEntitys) {
					eweUserBetService.save(eweUserBet);
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
	
	
}
