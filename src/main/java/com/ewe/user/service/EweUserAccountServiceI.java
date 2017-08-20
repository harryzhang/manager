package com.ewe.user.service;
import com.ewe.user.entity.EweUserAccountEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EweUserAccountServiceI extends CommonService{
	
 	public void delete(EweUserAccountEntity entity) throws Exception;
 	
 	public Serializable save(EweUserAccountEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EweUserAccountEntity entity) throws Exception;
 	
}
