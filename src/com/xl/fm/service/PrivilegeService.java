package com.xl.fm.service;

import java.util.List;

import com.xl.fm.base.BaseService;
import com.xl.fm.domain.Privilege;

public interface PrivilegeService extends BaseService<Privilege> {

	List<Privilege> findTopPrivilege();

	List<String> getAllPrivilegeUrls();

}
