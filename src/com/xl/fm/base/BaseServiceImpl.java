package com.xl.fm.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.xl.fm.action.PageBean;
import com.xl.fm.cfg.InitialCfg;
import com.xl.fm.util.HqlHelper;

@Transactional
@SuppressWarnings("unchecked")
public class BaseServiceImpl<T> implements BaseService<T> {
	@Resource
	SessionFactory sessionFactory;
	
	protected Class<T> clazz;
	
	public BaseServiceImpl() {
		//通过反射得到T的真实类型
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class) pt.getActualTypeArguments()[0];
	}
	
	
	public void save(T entity) {
		getSession().save(entity);
	}
	
	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	public void update(T entity) {
		getSession().update(entity);
	}
	
	public T getById(Long id) {
		if (id == null) {
			return null;
		}
		return getSession().get(clazz, id);
	}
	
	
	
	public List<T> findAll() {
		return getSession().createQuery(
				"From " + clazz.getSimpleName())
				.list();
	}

	public List<T> getByIds(Long[] ids) {
		if (ids == null || ids.length == 0) {
			return Collections.EMPTY_LIST;
		}
		
		return getSession().createQuery(
				"FROM " + clazz.getSimpleName() + " WHERE id IN(:ids)")
				.setParameterList("ids", ids)
				.list();
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Deprecated
	public PageBean getPageBean(int pageNum, String hql, Object[] parameters) {
		int pageSize = InitialCfg.getPageSize();
		
		Query listQuery = getSession().createQuery(hql);
		if (parameters != null && parameters.length > 0) {
			for(int i=0; i<parameters.length; i++) {
				listQuery.setParameter(i, parameters[i]);
			}
		} 
		List recordList = listQuery.setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize).list();
		
		Query recordQuery = getSession().createQuery("SELECT COUNT(*) " + hql);
		if (parameters != null && parameters.length > 0) {
			for(int i=0; i<parameters.length; i++) {
				recordQuery.setParameter(i, parameters[i]);
			}
		}
		Long recordCount = (Long) recordQuery.uniqueResult();
		return new PageBean(pageNum, pageSize, recordList, recordCount.intValue());
	}

	//最终版
	public PageBean getPageBean(int pageNum, HqlHelper hqlHelper) {
		int pageSize = InitialCfg.getPageSize();
		
		List<Object> parameters = hqlHelper.getParameters();
		
		Query listQuery = getSession().createQuery(hqlHelper.getQueryListHql());
		if (parameters != null && parameters.size() > 0) {
			for(int i=0; i<parameters.size(); i++) {
				listQuery.setParameter(i, parameters.get(i));
			}
		} 
		List recordList = listQuery.setFirstResult((pageNum-1)*pageSize).setMaxResults(pageSize).list();
		
		Query recordQuery = getSession().createQuery(hqlHelper.getQueryCountHql());
		if (parameters != null && parameters.size() > 0) {
			for(int i=0; i<parameters.size(); i++) {
				recordQuery.setParameter(i, parameters.get(i));
			}
		}
		Long recordCount = (Long) recordQuery.uniqueResult();
		return new PageBean(pageNum, pageSize, recordList, recordCount.intValue());
		
	}
	
}


































