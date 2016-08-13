package com.xl.fm.base;

import java.lang.reflect.ParameterizedType;

import com.opensymphony.xwork2.ModelDriven;

public abstract class ModelDrivenBaseAction<T> extends BaseAction implements ModelDriven<T> {
	
	protected T model;
	
	@SuppressWarnings("unchecked")
	public ModelDrivenBaseAction() {
		try {
			//得到model的类型信息
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class clazz = (Class) pt.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public T getModel() {
		return model;
	}
	
	
	protected int pageNum = 1;
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	
	
}
