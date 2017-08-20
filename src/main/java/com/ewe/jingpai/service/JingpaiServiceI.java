package com.ewe.jingpai.service;
import com.ewe.jingpai.entity.JingpaiEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface JingpaiServiceI extends CommonService{
	
 	public void delete(JingpaiEntity entity) throws Exception;
 	
 	public Serializable save(JingpaiEntity entity) throws Exception;
 	
 	public void saveOrUpdate(JingpaiEntity entity) throws Exception;
 	
}
