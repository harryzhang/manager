package com.ewe.user.service.impl;
import com.ewe.user.service.EweWithdrawServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.ewe.user.entity.EweWithdrawEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("eweWithdrawService")
@Transactional
public class EweWithdrawServiceImpl extends CommonServiceImpl implements EweWithdrawServiceI {

	
 	public void delete(EweWithdrawEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(EweWithdrawEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(EweWithdrawEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(EweWithdrawEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(EweWithdrawEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(EweWithdrawEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(EweWithdrawEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("withdrawid", t.getWithdrawid());
		map.put("withdrawcode", t.getWithdrawcode());
		map.put("userid", t.getUser().getId());
		map.put("amount", t.getAmount());
		map.put("charge", t.getCharge());
		map.put("payamount", t.getPayamount());
		map.put("createtime", t.getCreatetime());
		map.put("withdrawstatus", t.getWithdrawstatus());
		map.put("paystatus", t.getPaystatus());
		map.put("paytime", t.getPaytime());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,EweWithdrawEntity t){
 		sql  = sql.replace("#{withdrawid}",String.valueOf(t.getWithdrawid()));
 		sql  = sql.replace("#{withdrawcode}",String.valueOf(t.getWithdrawcode()));
// 		sql  = sql.replace("#{userid}",String.valueOf(t.getUser().getId()));
 		sql  = sql.replace("#{amount}",String.valueOf(t.getAmount()));
 		sql  = sql.replace("#{charge}",String.valueOf(t.getCharge()));
 		sql  = sql.replace("#{payamount}",String.valueOf(t.getPayamount()));
 		sql  = sql.replace("#{createtime}",String.valueOf(t.getCreatetime()));
 		sql  = sql.replace("#{withdrawstatus}",String.valueOf(t.getWithdrawstatus()));
 		sql  = sql.replace("#{paystatus}",String.valueOf(t.getPaystatus()));
 		sql  = sql.replace("#{paytime}",String.valueOf(t.getPaytime()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute(data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}