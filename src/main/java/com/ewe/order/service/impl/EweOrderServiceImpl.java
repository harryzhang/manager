package com.ewe.order.service.impl;
import com.ewe.order.service.EweOrderServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.ewe.order.entity.EweOrderEntity;
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

@Service("eweOrderService")
@Transactional
public class EweOrderServiceImpl extends CommonServiceImpl implements EweOrderServiceI {

	
 	public void delete(EweOrderEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(EweOrderEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(EweOrderEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(EweOrderEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(EweOrderEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(EweOrderEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(EweOrderEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderid", t.getOrderid());
		map.put("ordercode", t.getOrdercode());
		map.put("userid", t.getUser().getId());
		map.put("goodsid", t.getGoods().getId());
		map.put("qty", t.getQty());
		map.put("price", t.getPrice());
		map.put("totalprice", t.getTotalprice());
		map.put("recaddress", t.getRecaddress());
		map.put("createtime", t.getCreatetime());
		map.put("orderstatus", t.getOrderstatus());
		map.put("paystatus", t.getPaystatus());
		map.put("paytime", t.getPaytime());
		map.put("ordertype", t.getOrdertype());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,EweOrderEntity t){
 		sql  = sql.replace("#{orderid}",String.valueOf(t.getOrderid()));
 		sql  = sql.replace("#{ordercode}",String.valueOf(t.getOrdercode()));
 		sql  = sql.replace("#{userid}",String.valueOf(t.getUser().getId()));
 		sql  = sql.replace("#{goodsid}",String.valueOf(t.getGoods().getId()));
 		sql  = sql.replace("#{qty}",String.valueOf(t.getQty()));
 		sql  = sql.replace("#{price}",String.valueOf(t.getPrice()));
 		sql  = sql.replace("#{totalprice}",String.valueOf(t.getTotalprice()));
 		sql  = sql.replace("#{recaddress}",String.valueOf(t.getRecaddress()));
 		sql  = sql.replace("#{createtime}",String.valueOf(t.getCreatetime()));
 		sql  = sql.replace("#{orderstatus}",String.valueOf(t.getOrderstatus()));
 		sql  = sql.replace("#{paystatus}",String.valueOf(t.getPaystatus()));
 		sql  = sql.replace("#{paytime}",String.valueOf(t.getPaytime()));
 		sql  = sql.replace("#{ordertype}",String.valueOf(t.getOrdertype()));
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