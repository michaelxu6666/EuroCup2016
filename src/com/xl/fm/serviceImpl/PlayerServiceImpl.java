package com.xl.fm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xl.fm.action.PageBean;
import com.xl.fm.base.BaseServiceImpl;
import com.xl.fm.cfg.InitialCfg;
import com.xl.fm.domain.Player;
import com.xl.fm.service.PlayerService;

@Service
public class PlayerServiceImpl extends BaseServiceImpl<Player> implements PlayerService {
	
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
}
