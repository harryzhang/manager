package com.ewe.question.service;
import com.ewe.question.entity.QuestionFeedbackEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface QuestionFeedbackServiceI extends CommonService{
	
 	public void delete(QuestionFeedbackEntity entity) throws Exception;
 	
 	public Serializable save(QuestionFeedbackEntity entity) throws Exception;
 	
 	public void saveOrUpdate(QuestionFeedbackEntity entity) throws Exception;
 	
}
