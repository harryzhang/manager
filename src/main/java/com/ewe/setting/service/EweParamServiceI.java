package com.ewe.setting.service;
import com.ewe.setting.entity.EweParamEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EweParamServiceI extends CommonService{
	
 	public void delete(EweParamEntity entity) throws Exception;
 	
 	public Serializable save(EweParamEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EweParamEntity entity) throws Exception;
 	
}
