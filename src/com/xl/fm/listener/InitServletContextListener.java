package com.xl.fm.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xl.fm.domain.Privilege;
import com.xl.fm.service.PrivilegeService;

public class InitServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext application = sce.getServletContext();
		
		//得到Service的实例对象
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);
		PrivilegeService privilegeService = (PrivilegeService)ac.getBean("privilegeServiceImpl");
		
		//准备所有顶级权限的集合（顶级菜单）
		List<Privilege> topPrivilegeList = privilegeService.findTopPrivilege();
		application.setAttribute("topPrivilegeList", topPrivilegeList);
System.out.println("===已准备好所有顶级权限的数据===");		

		// 准备所有权限的URL集合
		List<String> allPrivilegeUrls = privilegeService.getAllPrivilegeUrls();
		application.setAttribute("allPrivilegeUrls", allPrivilegeUrls);
System.out.println("--已准备好所有权限的URL数据---");		
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
