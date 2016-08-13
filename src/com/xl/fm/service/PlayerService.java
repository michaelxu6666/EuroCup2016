package com.xl.fm.service;

import java.util.List;

import com.xl.fm.action.PageBean;
import com.xl.fm.base.BaseService;
import com.xl.fm.domain.Player;

public interface PlayerService extends BaseService<Player> {

	@Deprecated
	PageBean getPageBean(int pageNum);

	
	
	
	
}
