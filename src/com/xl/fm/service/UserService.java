package com.xl.fm.service;

import com.xl.fm.action.PageBean;
import com.xl.fm.base.BaseService;
import com.xl.fm.domain.User;

public interface UserService extends BaseService<User> {

	@Deprecated
	PageBean getPageBean(int pageNum);
	
	/**
	 * 根据用户名和密码查找用户
	 * @param name
	 * @param password
	 * @return
	 */
	User getByNameAndPassword(String name, String password);

	
	
	
	
}
