package com.xl.fm.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xl.fm.base.BaseServiceImpl;
import com.xl.fm.domain.Privilege;
import com.xl.fm.service.PrivilegeService;

@Service
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements PrivilegeService {

		
	@SuppressWarnings("unchecked")
	public List<Privilege> findTopPrivilege() {
		
		return getSession().createQuery(
				"FROM Privilege p WHERE p.parent = null ")
				.list();
		
	}

	public List<String> getAllPrivilegeUrls() {
		return getSession().createQuery(
				"SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL")
				.list();
		
	}
	
	
}
