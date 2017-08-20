package com.ewe.order.service;
import com.ewe.order.entity.EweOrderEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EweOrderServiceI extends CommonService{
	
 	public void delete(EweOrderEntity entity) throws Exception;
 	
 	public Serializable save(EweOrderEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EweOrderEntity entity) throws Exception;
 	
}
