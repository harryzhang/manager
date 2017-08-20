package com.ewe.user.service.impl;
import com.ewe.user.service.EweUserInfoServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.ewe.user.entity.EweUserInfoEntity;
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

@Service("eweUserInfoService")
@Transactional
public class EweUserInfoServiceImpl extends CommonServiceImpl implements EweUserInfoServiceI {

	
 	public void delete(EweUserInfoEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(EweUserInfoEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(EweUserInfoEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(EweUserInfoEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(EweUserInfoEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(EweUserInfoEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(EweUserInfoEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("userid", t.getUserid());
		map.put("realname", t.getRealname());
		map.put("idcardno", t.getIdcardno());
		map.put("sex", t.getSex());
		map.put("contactaddress", t.getContactaddress());
		map.put("mobile", t.getMobile());
		map.put("email", t.getEmail());
		map.put("weixinumber", t.getWeixinumber());
		map.put("qqnumber", t.getQqnumber());
		map.put("zfbnumber", t.getZfbnumber());
		map.put("cftnumber", t.getCftnumber());
		map.put("bankname", t.getBankname());
		map.put("province", t.getProvince());
		map.put("city", t.getCity());
		map.put("banksubbranch", t.getBanksubbranch());
		map.put("bankaccount", t.getBankaccount());
		map.put("openaccount", t.getOpenaccount());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,EweUserInfoEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{userid}",String.valueOf(t.getUserid()));
 		sql  = sql.replace("#{realname}",String.valueOf(t.getRealname()));
 		sql  = sql.replace("#{idcardno}",String.valueOf(t.getIdcardno()));
 		sql  = sql.replace("#{sex}",String.valueOf(t.getSex()));
 		sql  = sql.replace("#{contactaddress}",String.valueOf(t.getContactaddress()));
 		sql  = sql.replace("#{mobile}",String.valueOf(t.getMobile()));
 		sql  = sql.replace("#{email}",String.valueOf(t.getEmail()));
 		sql  = sql.replace("#{weixinumber}",String.valueOf(t.getWeixinumber()));
 		sql  = sql.replace("#{qqnumber}",String.valueOf(t.getQqnumber()));
 		sql  = sql.replace("#{zfbnumber}",String.valueOf(t.getZfbnumber()));
 		sql  = sql.replace("#{cftnumber}",String.valueOf(t.getCftnumber()));
 		sql  = sql.replace("#{bankname}",String.valueOf(t.getBankname()));
 		sql  = sql.replace("#{province}",String.valueOf(t.getProvince()));
 		sql  = sql.replace("#{city}",String.valueOf(t.getCity()));
 		sql  = sql.replace("#{banksubbranch}",String.valueOf(t.getBanksubbranch()));
 		sql  = sql.replace("#{bankaccount}",String.valueOf(t.getBankaccount()));
 		sql  = sql.replace("#{openaccount}",String.valueOf(t.getOpenaccount()));
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