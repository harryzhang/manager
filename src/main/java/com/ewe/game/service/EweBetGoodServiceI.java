package com.ewe.game.service;
import com.ewe.game.entity.EweBetGoodEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EweBetGoodServiceI extends CommonService{
	
 	public void delete(EweBetGoodEntity entity) throws Exception;
 	
 	public Serializable save(EweBetGoodEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EweBetGoodEntity entity) throws Exception;
 	
}
