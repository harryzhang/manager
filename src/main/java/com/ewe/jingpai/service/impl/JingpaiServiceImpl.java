package com.ewe.jingpai.service.impl;
import com.ewe.jingpai.service.JingpaiServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.ewe.jingpai.entity.JingpaiEntity;
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

@Service("jingpaiService")
@Transactional
public class JingpaiServiceImpl extends CommonServiceImpl implements JingpaiServiceI {

	
 	public void delete(JingpaiEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(JingpaiEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(JingpaiEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(JingpaiEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(JingpaiEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(JingpaiEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(JingpaiEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("goodsid", t.getGoods().getId());
		map.put("starttime", t.getStarttime());
		map.put("endtime", t.getEndtime());
		map.put("startprice", t.getStartprice());
		map.put("endprice", t.getEndprice());
		map.put("lastuser", t.getLastuser());
		map.put("usertime", t.getUsertime());
		map.put("lastprice", t.getLastprice());
		map.put("status", t.getStatus());
		map.put("createtime", t.getCreatetime());
		map.put("userid", t.getUserid());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,JingpaiEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{goodsid}",String.valueOf(t.getGoods().getId()));
 		sql  = sql.replace("#{starttime}",String.valueOf(t.getStarttime()));
 		sql  = sql.replace("#{endtime}",String.valueOf(t.getEndtime()));
 		sql  = sql.replace("#{startprice}",String.valueOf(t.getStartprice()));
 		sql  = sql.replace("#{endprice}",String.valueOf(t.getEndprice()));
 		sql  = sql.replace("#{lastuser}",String.valueOf(t.getLastuser()));
 		sql  = sql.replace("#{usertime}",String.valueOf(t.getUsertime()));
 		sql  = sql.replace("#{lastprice}",String.valueOf(t.getLastprice()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{createtime}",String.valueOf(t.getCreatetime()));
 		sql  = sql.replace("#{userid}",String.valueOf(t.getUserid()));
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