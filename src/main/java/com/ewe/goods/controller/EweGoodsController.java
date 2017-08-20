package com.ewe.goods.controller;
import com.ewe.goods.entity.EweGoodsEntity;
import com.ewe.goods.service.EweGoodsServiceI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * @Description: 商品信息表
 * @author onlineGenerator
 * @date 2016-10-28 16:49:31
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/eweGoodsController")
public class EweGoodsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EweGoodsController.class);

	@Autowired
	private EweGoodsServiceI eweGoodsService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 商品信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/ewe/goods/eweGoodsList");
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
	public void datagrid(EweGoodsEntity eweGoods,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(EweGoodsEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eweGoods, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.eweGoodsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除商品信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(EweGoodsEntity eweGoods, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		eweGoods = systemService.getEntity(EweGoodsEntity.class, eweGoods.getId());
		message = "商品信息表删除成功";
		try{
			eweGoodsService.delete(eweGoods);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "商品信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除商品信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "商品信息表删除成功";
		try{
			for(String id:ids.split(",")){
				EweGoodsEntity eweGoods = systemService.getEntity(EweGoodsEntity.class, 
				Integer.parseInt(id)
				);
				eweGoodsService.delete(eweGoods);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "商品信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加商品信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(EweGoodsEntity eweGoods, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "商品信息表添加成功";
		try{
			String iamgesrc = eweGoods.getImagesrc();
			iamgesrc = iamgesrc.replace("//images/", "");
			iamgesrc = iamgesrc.replace("/manager/images/", "");
			eweGoods.setImagesrc(iamgesrc);
			
			String bannerscr = eweGoods.getBigimagesrc();
			bannerscr = bannerscr.replace("//images/", "");
			bannerscr = bannerscr.replace("/manager/images/", "");
			eweGoods.setBigimagesrc(bannerscr);
			eweGoods.setCreatetime(new Date());
			eweGoods.setGoodsid(0);
			eweGoodsService.save(eweGoods);
			eweGoods.setGoodsid(eweGoods.getId());
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "商品信息表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新商品信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(EweGoodsEntity eweGoods, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "商品信息表更新成功";
		EweGoodsEntity t = eweGoodsService.get(EweGoodsEntity.class, eweGoods.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(eweGoods, t);
			
			String iamgesrc = t.getImagesrc();
			iamgesrc = iamgesrc.replace("//images/", "");
			iamgesrc = iamgesrc.replace("/manager/images/", "");
			t.setImagesrc(iamgesrc);
			
			String bannerscr = t.getBigimagesrc();
			bannerscr = bannerscr.replace("//images/", "");
			bannerscr = bannerscr.replace("/manager/images/", "");
			t.setBigimagesrc(bannerscr);
			t.setCreatetime(new Date());
			eweGoodsService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "商品信息表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 商品信息表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(EweGoodsEntity eweGoods, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eweGoods.getId())) {
			eweGoods = eweGoodsService.getEntity(EweGoodsEntity.class, eweGoods.getId());
			req.setAttribute("eweGoodsPage", eweGoods);
		}
		return new ModelAndView("com/ewe/goods/eweGoods-add");
	}
	/**
	 * 商品信息表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(EweGoodsEntity eweGoods, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(eweGoods.getId())) {
			eweGoods = eweGoodsService.getEntity(EweGoodsEntity.class, eweGoods.getId());
			req.setAttribute("eweGoodsPage", eweGoods);
		}
		return new ModelAndView("com/ewe/goods/eweGoods-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","eweGoodsController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(EweGoodsEntity eweGoods,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(EweGoodsEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, eweGoods, request.getParameterMap());
		List<EweGoodsEntity> eweGoodss = this.eweGoodsService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"商品信息表");
		modelMap.put(NormalExcelConstants.CLASS,EweGoodsEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("商品信息表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,eweGoodss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(EweGoodsEntity eweGoods,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"商品信息表");
    	modelMap.put(NormalExcelConstants.CLASS,EweGoodsEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("商品信息表列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<EweGoodsEntity> listEweGoodsEntitys = ExcelImportUtil.importExcel(file.getInputStream(),EweGoodsEntity.class,params);
				for (EweGoodsEntity eweGoods : listEweGoodsEntitys) {
					eweGoodsService.save(eweGoods);
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
	public List<EweGoodsEntity> list() {
		List<EweGoodsEntity> listEweGoodss=eweGoodsService.getList(EweGoodsEntity.class);
		return listEweGoodss;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		EweGoodsEntity task = eweGoodsService.get(EweGoodsEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

}
