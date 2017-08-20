package com.ewe.goods.service.impl;
import com.ewe.goods.service.EweGoodsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.ewe.goods.entity.EweGoodsEntity;
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

@Service("eweGoodsService")
@Transactional
public class EweGoodsServiceImpl extends CommonServiceImpl implements EweGoodsServiceI {

	
 	public void delete(EweGoodsEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(EweGoodsEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(EweGoodsEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}
 	
 	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(EweGoodsEntity t) throws Exception{
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(EweGoodsEntity t) throws Exception{
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(EweGoodsEntity t) throws Exception{
 	}
 	
 	private Map<String,Object> populationMap(EweGoodsEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("goodsid", t.getGoodsid());
		map.put("gname", t.getGname());
		map.put("gdesc", t.getGdesc());
		map.put("status", t.getStatus());
		map.put("gcode", t.getGcode());
		map.put("gcate", t.getGcate());
		map.put("gunite", t.getGunite());
		map.put("price", t.getPrice());
		map.put("gkind", t.getGkind());
		map.put("createtime", t.getCreatetime());
		map.put("imagesrc", t.getImagesrc());
		map.put("bigimagesrc", t.getBigimagesrc());
		map.put("bandname", t.getBandname());
		map.put("id", t.getId());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,EweGoodsEntity t){
 		sql  = sql.replace("#{goodsid}",String.valueOf(t.getGoodsid()));
 		sql  = sql.replace("#{gname}",String.valueOf(t.getGname()));
 		sql  = sql.replace("#{gdesc}",String.valueOf(t.getGdesc()));
 		sql  = sql.replace("#{status}",String.valueOf(t.getStatus()));
 		sql  = sql.replace("#{gcode}",String.valueOf(t.getGcode()));
 		sql  = sql.replace("#{gcate}",String.valueOf(t.getGcate()));
 		sql  = sql.replace("#{gunite}",String.valueOf(t.getGunite()));
 		sql  = sql.replace("#{price}",String.valueOf(t.getPrice()));
 		sql  = sql.replace("#{gkind}",String.valueOf(t.getGkind()));
 		sql  = sql.replace("#{createtime}",String.valueOf(t.getCreatetime()));
 		sql  = sql.replace("#{imagesrc}",String.valueOf(t.getImagesrc()));
 		sql  = sql.replace("#{bigimagesrc}",String.valueOf(t.getBigimagesrc()));
 		sql  = sql.replace("#{bandname}",String.valueOf(t.getBandname()));
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
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