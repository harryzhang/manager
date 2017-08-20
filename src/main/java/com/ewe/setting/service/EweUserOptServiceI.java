package com.ewe.setting.service;
import com.ewe.setting.entity.EweUserOptEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EweUserOptServiceI extends CommonService{
	
 	public void delete(EweUserOptEntity entity) throws Exception;
 	
 	public Serializable save(EweUserOptEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EweUserOptEntity entity) throws Exception;
 	
}
