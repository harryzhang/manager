package com.ewe.user.service;
import com.ewe.user.entity.EweUserInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EweUserInfoServiceI extends CommonService{
	
 	public void delete(EweUserInfoEntity entity) throws Exception;
 	
 	public Serializable save(EweUserInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EweUserInfoEntity entity) throws Exception;
 	
}
