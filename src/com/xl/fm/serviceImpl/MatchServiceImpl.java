package com.xl.fm.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xl.fm.action.PageBean;
import com.xl.fm.base.BaseServiceImpl;
import com.xl.fm.cfg.InitialCfg;
import com.xl.fm.domain.Match;
import com.xl.fm.service.MatchService;

@Service
public class MatchServiceImpl extends BaseServiceImpl<Match> implements MatchService {
	@Deprecated
	public PageBean getPageBean(int pageNum) {

		int pageSize = InitialCfg.getPageSize();
		
		List recordList = getSession().createQuery(
				"FROM Match")
				.setFirstResult((pageNum-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
		
		Long recordCount = (Long)getSession().createQuery(
				"SELECT COUNT(*) FROM Match").uniqueResult();
		int rc = recordCount.intValue();
		
		return new PageBean(pageNum, pageSize, recordList, rc);
	}


}









