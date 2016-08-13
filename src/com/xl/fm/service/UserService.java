package com.xl.fm.service;

import com.xl.fm.action.PageBean;
import com.xl.fm.base.BaseService;
import com.xl.fm.domain.User;

public interface UserService extends BaseService<User> {

	@Deprecated
	PageBean getPageBean(int pageNum);
	
	/**
	 * �����û�������������û�
	 * @param name
	 * @param password
	 * @return
	 */
	User getByNameAndPassword(String name, String password);

	
	
	
	
}
