package com.ewe.goods.service;
import com.ewe.goods.entity.EweGoodsEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface EweGoodsServiceI extends CommonService{
	
 	public void delete(EweGoodsEntity entity) throws Exception;
 	
 	public Serializable save(EweGoodsEntity entity) throws Exception;
 	
 	public void saveOrUpdate(EweGoodsEntity entity) throws Exception;
 	
}
