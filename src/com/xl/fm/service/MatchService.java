package com.xl.fm.service;

import com.xl.fm.action.PageBean;
import com.xl.fm.base.BaseService;
import com.xl.fm.domain.Match;

public interface MatchService extends BaseService<Match> {
	
	@Deprecated
	PageBean getPageBean(int pageNum);

	

	
	
	
	
}
