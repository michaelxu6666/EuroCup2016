package com.xl.fm.util;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ڸ���ƴ������HQL�Ĺ�����
 * @author tyg
 *
 */
public class HqlHelper {
	
	private String fromClause;	 //����
	private String whereClause = "";  //��ѡ
	private String orderByClause = ""; //��ѡ
	
	
	private List<Object> parameters = new ArrayList<Object>(); //�����б�
	
	
	/**
	 * ����From�Ӿ䣬Ĭ�ϵı���Ϊ��o��
	 * @param clazz
	 */
	public HqlHelper(Class<?> clazz) {
		this.fromClause = "FROM " + clazz.getSimpleName() + "o";
	}
	
	/**
	 * ����From�Ӿ䣬ʹ��ָ���ı���
	 * @param clazz
	 */
	public HqlHelper(Class<?> clazz, String alias) {
		this.fromClause = "FROM " + clazz.getSimpleName() + " " + alias;
	}
	
	/**
	 * ƴ��Where�Ӿ�
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
	 * �����һ������Ϊtrue,��ƴ��Where�Ӿ�
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
	 * ƴ��OrderBy�Ӿ�
	 * @param propertyName 
	 * 			������
	 * @param isAsc
	 * 			true��ʾ����false��ʾ����
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
	 * �����һ������Ϊtrue,��ƴ��OrderBy�Ӿ�
	 * @param propertyName 
	 * 			������
	 * @param isAsc
	 * 			true��ʾ����false��ʾ����
	 */
	public HqlHelper addOrder(boolean append, String propertyName, boolean isAsc) {
		if(append){
			addOrder(propertyName, isAsc);
		}
		return this;
	}
	
	
	/**
	 * ��ȡ���ɲ�ѯ�����б��Hql���
	 * @return
	 */
	public String getQueryListHql() {
		return fromClause + whereClause + orderByClause;
	}
	
	/**
	 * ��ȡ���ɲ�ѯ�ܼ�¼����Hql���
	 * @return
	 */
	public String getQueryCountHql() {
		return "SELECT COUNT(*) " + fromClause + whereClause;
	}
	
	
	/**
	 * ��ȡ�����б���HQL���������е�'?'һһ��Ӧ
	 * @return
	 */
	public List<Object> getParameters() {
		return parameters;
	}

	
}
















































