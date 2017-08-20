package com.ewe.question.service;
import com.ewe.question.entity.QuestionEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface QuestionServiceI extends CommonService{
	
 	public void delete(QuestionEntity entity) throws Exception;
 	
 	public Serializable save(QuestionEntity entity) throws Exception;
 	
 	public void saveOrUpdate(QuestionEntity entity) throws Exception;
 	
}
