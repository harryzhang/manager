package com.ewe.game.service;
import com.ewe.game.entity.EweUserBetEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EweUserBetServiceI extends CommonService{
	
 	public void delete(EweUserBetEntity entity) throws Exception;
 	
 	public Serializable save(EweUserBetEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EweUserBetEntity entity) throws Exception;
 	
}
