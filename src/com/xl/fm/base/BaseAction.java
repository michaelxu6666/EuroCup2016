package com.xl.fm.base;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.xl.fm.service.CoachService;
import com.xl.fm.service.CountryService;
import com.xl.fm.service.MatchService;
import com.xl.fm.service.PlayerService;
import com.xl.fm.service.PrivilegeService;
import com.xl.fm.service.UserService;

public class BaseAction extends ActionSupport {
	
	@Resource
	protected PlayerService playerService;
	@Resource
	protected CountryService countryService;
	@Resource
	protected CoachService coachService;
	@Resource
	protected MatchService matchService;
	@Resource
	protected UserService userService; 
	@Resource
	protected PrivilegeService privilegeService;
	
	
}
