package com.xl.fm.base;

import java.util.List;

import com.xl.fm.action.PageBean;
import com.xl.fm.util.HqlHelper;

public interface BaseService<T> {
	
	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * 删除实体 也可以通过id删除 delete（int id） 见OA项目用法
	 * 
	 * @param entity
	 */
	void delete(T entity);
	
	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * 查询实体
	 * @param id
	 * @return
	 */
	T getById(Long id);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 查询实体
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	/**
	 * 公共查询分页信息的方法
	 * @param pageNum
	 * @param hql
	 * 		查询数据列表的hql语句，如果在前面加上"select count(*)"就变成查询总数量的语句了 
	 * @param parameters
	 * 			参数列表，顺序与hql中的"?"的顺序一一对应。
	 * @return
	 */
	@Deprecated
	PageBean getPageBean(int pageNum, String hql, Object[] parameters);
	
	/**
	 * 公共查询分页信息的方法
	 * @param pageNum
	 * @param hqlHelper
	 * 			查询条件(hql语句与参数列表)
	 * @return
	 */
	PageBean getPageBean(int pageNum, HqlHelper hqlHelper);
	
	
}
