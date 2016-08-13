package com.xl.fm.base;

import java.util.List;

import com.xl.fm.action.PageBean;
import com.xl.fm.util.HqlHelper;

public interface BaseService<T> {
	
	/**
	 * ����ʵ��
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * ɾ��ʵ�� Ҳ����ͨ��idɾ�� delete��int id�� ��OA��Ŀ�÷�
	 * 
	 * @param entity
	 */
	void delete(T entity);
	
	/**
	 * ����ʵ��
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * ��ѯʵ��
	 * @param id
	 * @return
	 */
	T getById(Long id);
	
	/**
	 * ��ѯ����
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * ��ѯʵ��
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	/**
	 * ������ѯ��ҳ��Ϣ�ķ���
	 * @param pageNum
	 * @param hql
	 * 		��ѯ�����б��hql��䣬�����ǰ�����"select count(*)"�ͱ�ɲ�ѯ������������� 
	 * @param parameters
	 * 			�����б�˳����hql�е�"?"��˳��һһ��Ӧ��
	 * @return
	 */
	@Deprecated
	PageBean getPageBean(int pageNum, String hql, Object[] parameters);
	
	/**
	 * ������ѯ��ҳ��Ϣ�ķ���
	 * @param pageNum
	 * @param hqlHelper
	 * 			��ѯ����(hql���������б�)
	 * @return
	 */
	PageBean getPageBean(int pageNum, HqlHelper hqlHelper);
	
	
}
