package com.ewe.common.service;
import com.ewe.common.entity.EweCityEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EweCityServiceI extends CommonService{
	
 	public void delete(EweCityEntity entity) throws Exception;
 	
 	public Serializable save(EweCityEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EweCityEntity entity) throws Exception;
 	
}
