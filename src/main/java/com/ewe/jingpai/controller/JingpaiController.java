package com.ewe.jingpai.controller;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
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

import com.ewe.jingpai.entity.JingpaiEntity;
import com.ewe.jingpai.service.JingpaiServiceI;

/**   
 * @Title: Controller  
 * @Description: 竞拍管理
 * @author onlineGenerator
 * @date 2017-01-22 02:10:43
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/jingpaiController")
public class JingpaiController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(JingpaiController.class);

	@Autowired
	private JingpaiServiceI jingpaiService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 竞拍管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/ewe/jingpai/jingpaiList");
	}
	/**
	 * 竞拍管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "jingPailist")
	public ModelAndView jingPailist(HttpServletRequest request) {
		return new ModelAndView("com/ewe/jingpai/jpSuccesslist");
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
	public void datagrid(JingpaiEntity jingpai,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(JingpaiEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, jingpai, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.jingpaiService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */
	
	@RequestMapping(params = "successDatagrid")
	public void successDatagrid(JingpaiEntity jingpai,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		String sql = " select u.name,u.userName,js.price,js.id,js.create_time createTime,"
				   + "        g.gName "
				   + " from  tj_jingpai_success js"
				   + " left join t_user u on u.id = js.user_id  "
				   + " left join t_goods g on g.id = js.goods_id ";
		
		List<Map<String, Object>> jpList = systemService.findForJdbc(sql, null);
		dataGrid.setResults(jpList);
		
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除竞拍管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(JingpaiEntity jingpai, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		jingpai = systemService.getEntity(JingpaiEntity.class, jingpai.getId());
		message = "竞拍管理删除成功";
		try{
			jingpaiService.delete(jingpai);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "竞拍管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除竞拍管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "竞拍管理删除成功";
		try{
			for(String id:ids.split(",")){
				JingpaiEntity jingpai = systemService.getEntity(JingpaiEntity.class, 
				Integer.parseInt(id)
				);
				jingpaiService.delete(jingpai);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "竞拍管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加竞拍管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(JingpaiEntity jingpai, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "竞拍管理添加成功";
		try{
			jingpaiService.save(jingpai);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "竞拍管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新竞拍管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(JingpaiEntity jingpai, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "竞拍管理更新成功";
		JingpaiEntity t = jingpaiService.get(JingpaiEntity.class, jingpai.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(jingpai, t);
			t.setStatus(1);
			t.setUsertime(new Date());
			jingpaiService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "竞拍管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 竞拍管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(JingpaiEntity jingpai, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(jingpai.getId())) {
			jingpai = jingpaiService.getEntity(JingpaiEntity.class, jingpai.getId());
			req.setAttribute("jingpaiPage", jingpai);
		}
		return new ModelAndView("com/ewe/jingpai/jingpai-add");
	}
	/**
	 * 竞拍管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(JingpaiEntity jingpai, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(jingpai.getId())) {
			jingpai = jingpaiService.getEntity(JingpaiEntity.class, jingpai.getId());
			req.setAttribute("jingpaiPage", jingpai);
		}
		return new ModelAndView("com/ewe/jingpai/jingpai-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","jingpaiController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(JingpaiEntity jingpai,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(JingpaiEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, jingpai, request.getParameterMap());
		List<JingpaiEntity> jingpais = this.jingpaiService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"竞拍管理");
		modelMap.put(NormalExcelConstants.CLASS,JingpaiEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("竞拍管理列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,jingpais);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(JingpaiEntity jingpai,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"竞拍管理");
    	modelMap.put(NormalExcelConstants.CLASS,JingpaiEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("竞拍管理列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<JingpaiEntity> listJingpaiEntitys = ExcelImportUtil.importExcel(file.getInputStream(),JingpaiEntity.class,params);
				for (JingpaiEntity jingpai : listJingpaiEntitys) {
					jingpaiService.save(jingpai);
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
	public List<JingpaiEntity> list() {
		List<JingpaiEntity> listJingpais=jingpaiService.getList(JingpaiEntity.class);
		return listJingpais;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		JingpaiEntity task = jingpaiService.get(JingpaiEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody JingpaiEntity jingpai, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<JingpaiEntity>> failures = validator.validate(jingpai);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			jingpaiService.save(jingpai);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		Integer id = jingpai.getId();
		URI uri = uriBuilder.path("/rest/jingpaiController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody JingpaiEntity jingpai) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<JingpaiEntity>> failures = validator.validate(jingpai);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			jingpaiService.saveOrUpdate(jingpai);
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
		jingpaiService.deleteEntityById(JingpaiEntity.class, id);
	}
}
