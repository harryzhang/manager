package com.ewe.user.service;
import com.ewe.user.entity.UserAgentApplyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface UserAgentApplyServiceI extends CommonService{
	
 	public void delete(UserAgentApplyEntity entity) throws Exception;
 	
 	public Serializable save(UserAgentApplyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(UserAgentApplyEntity entity) throws Exception;
 	
}
