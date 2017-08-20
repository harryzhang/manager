package com.ewe.user.service;
import com.ewe.user.entity.EweUserEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EweUserServiceI extends CommonService{
	
 	public void delete(EweUserEntity entity) throws Exception;
 	
 	public Serializable save(EweUserEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EweUserEntity entity) throws Exception;
 	
}
