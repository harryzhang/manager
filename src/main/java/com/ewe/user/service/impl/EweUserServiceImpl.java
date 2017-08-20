package com.ewe.user.service.impl;
import com.ewe.user.service.EweUserServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.ewe.user.entity.EweUserEntity;
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

@Service("eweUserService")
@Transactional
public class EweUserServiceImpl extends CommonServiceImpl implements EweUserServiceI {

	
 	public void delete(EweUserEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(EweUserEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(EweUserEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(EweUserEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(EweUserEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(EweUserEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(EweUserEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("username", t.getUsername());
		map.put("password", t.getPassword());
		map.put("passwordtwo", t.getPasswordtwo());
		map.put("grade", t.getGrade());
		map.put("organ", t.getOrgan());
		map.put("remark", t.getRemark());
		map.put("enabled", t.getEnabled());
		map.put("referrerid", t.getReferrerid());
		map.put("parentid", t.getParentid());
		map.put("treenode", t.getTreenode());
		map.put("creatortime", t.getCreatortime());
		map.put("updatetime", t.getUpdatetime());
		map.put("name", t.getName());
		map.put("bonus", t.getBonus());
		map.put("status", t.getStatus());
		map.put("joinmoney", t.getJoinmoney());
		map.put("optuserid", t.getOptuserid());
		map.put("isbackmoney", t.getIsbackmoney());
		map.put("optremark", t.getOptremark());
		map.put("iszengsong", t.getIszengsong());
		map.put("weixin", t.getWeixin());
		map.put("zhifubao", t.getZhifubao());
		map.put("usercode", t.getUsercode());
		map.put("openid", t.getOpenid());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,EweUserEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{username}",String.valueOf(t.getUsername()));
 		sql  = sql.replace("#{password}",String.valueOf(t.getPassword()));
 		sql  = sql.replace("#{passwordtwo}",String.valueOf(t.getPasswordtwo()));
 		sql  = sql.replace("#{grade}",String.valueOf(t.getGrade()));
 		sql  = sql.replace("#{organ}",String.valueOf(t.getOrgan()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{enabled}",String.valueOf(t.getEnabled()));
 		sql  = sql.replace("#{referrerid}",String.valueOf(t.getReferrerid()));
 		sql  = sql.replace("#{parentid}",String.valueOf(t.getParentid()));
 		sql  = sql.replace("#{treenode}",String.valueOf(t.getTreenode()));
 		sql  = sql.replace("#{creatortime}",String.valueOf(t.getCreatortime()));
 		sql  = sql.replace("#{updatetime}",String.valueOf(t.getUpdatetime()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{bonus}",String.valueOf(t.getBonus()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{joinmoney}",String.valueOf(t.getJoinmoney()));
 		sql  = sql.replace("#{optuserid}",String.valueOf(t.getOptuserid()));
 		sql  = sql.replace("#{isbackmoney}",String.valueOf(t.getIsbackmoney()));
 		sql  = sql.replace("#{optremark}",String.valueOf(t.getOptremark()));
 		sql  = sql.replace("#{iszengsong}",String.valueOf(t.getIszengsong()));
 		sql  = sql.replace("#{weixin}",String.valueOf(t.getWeixin()));
 		sql  = sql.replace("#{zhifubao}",String.valueOf(t.getZhifubao()));
 		sql  = sql.replace("#{usercode}",String.valueOf(t.getUsercode()));
 		sql  = sql.replace("#{openid}",String.valueOf(t.getOpenid()));
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