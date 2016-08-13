package com.xl.fm.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xl.fm.action.PageBean;
import com.xl.fm.base.BaseServiceImpl;
import com.xl.fm.cfg.InitialCfg;
import com.xl.fm.domain.User;
import com.xl.fm.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	
	@Deprecated
	public PageBean getPageBean(int currentPage) {
		
		int pageSize = InitialCfg.getPageSize();
		
		
		
		//查询 本页的数据列表和总的记录数
		List recordList = getSession().createQuery(
				"FROM Player")
				.setFirstResult((currentPage-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
				
		Long recordCount = (Long)getSession().createQuery(
				"SELECT COUNT(*) FROM Player")
				.uniqueResult();
		int rc = recordCount.intValue();	
		
		return new PageBean(currentPage, pageSize, recordList, rc);
	}

	public User getByNameAndPassword(String name, String password) {

		return (User)getSession().createQuery(
				"FROM User u WHERE u.loginName = ? AND u.password = ?")
				.setParameter(0, name)
				.setParameter(1, password)
				.uniqueResult();
		
	}


}
