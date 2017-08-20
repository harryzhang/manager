package com.ewe.common.service;
import com.ewe.common.entity.EweProvinceEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EweProvinceServiceI extends CommonService{
	
 	public void delete(EweProvinceEntity entity) throws Exception;
 	
 	public Serializable save(EweProvinceEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EweProvinceEntity entity) throws Exception;
 	
}
