package com.ewe.user.service;
import com.ewe.user.entity.EweWithdrawEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EweWithdrawServiceI extends CommonService{
	
 	public void delete(EweWithdrawEntity entity) throws Exception;
 	
 	public Serializable save(EweWithdrawEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EweWithdrawEntity entity) throws Exception;
 	
}
