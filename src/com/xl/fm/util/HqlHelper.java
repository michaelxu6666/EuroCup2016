package com.xl.fm.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于辅助拼接生成HQL的工具类
 * @author tyg
 *
 */
public class HqlHelper {
	
	private String fromClause;	 //必须
	private String whereClause = "";  //可选
	private String orderByClause = ""; //可选
	
	
	private List<Object> parameters = new ArrayList<Object>(); //参数列表
	
	
	/**
	 * 生成From子句，默认的别名为‘o’
	 * @param clazz
	 */
	public HqlHelper(Class<?> clazz) {
		this.fromClause = "FROM " + clazz.getSimpleName() + "o";
	}
	
	/**
	 * 生成From子句，使用指定的别名
	 * @param clazz
	 */
	public HqlHelper(Class<?> clazz, String alias) {
		this.fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
	}
	
	/**
	 * 拼接Where子句
	 * @param condition
	 * @param params
	 */
	public HqlHelper addCondition(String condition, Object... params) {
		if (whereClause.length() == 0) {
			whereClause = " WHERE " + condition;
		} else {
			whereClause +=" AND " + condition;
		}
		
		if(params != null && params.length > 0) {
			for (Object obj : params) {
				parameters.add(obj);
			}
		}
		return this;
	}
	
	/**
	 * 如果第一个参数为true,则拼接Where子句
	 * @param append
	 * @param params
	 */
	public HqlHelper addCondition(Boolean append, String condition, Object... params) {
		if(append) {
			addCondition(condition, params);
		}
		return this;
	}
	
	/**
	 * 拼接OrderBy子句
	 * @param propertyName 
	 * 			属性名
	 * @param isAsc
	 * 			true表示升序，false表示降序
	 */
	public HqlHelper addOrder(String propertyName, boolean isAsc) {
		if (orderByClause.length() == 0) {
			orderByClause = " ORDER BY " + propertyName + (isAsc ? " ASC" : " DESC");
		} else {
			orderByClause += ", " + propertyName + (isAsc ? " ASC" : " DESC");
		}
		
		
		return this;
	}
	
	/**
	 * 如果第一个参数为true,则拼接OrderBy子句
	 * @param propertyName 
	 * 			属性名
	 * @param isAsc
	 * 			true表示升序，false表示降序
	 */
	public HqlHelper addOrder(boolean append, String propertyName, boolean isAsc) {
		if(append){
			addOrder(propertyName, isAsc);
		}
		return this;
	}
	
	
	/**
	 * 获取生成查询数据列表的Hql语句
	 * @return
	 */
	public String getQueryListHql() {
		return fromClause + whereClause + orderByClause;
	}
	
	/**
	 * 获取生成查询总记录数的Hql语句
	 * @return
	 */
	public String getQueryCountHql() {
		return "SELECT COUNT(*) " + fromClause + whereClause;
	}
	
	
	/**
	 * 获取参数列表，与HQL过滤条件中的'?'一一对应
	 * @return
	 */
	public List<Object> getParameters() {
		return parameters;
	}

	
}
















































