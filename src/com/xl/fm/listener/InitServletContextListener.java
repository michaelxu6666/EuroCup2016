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
		
		//�õ�Service��ʵ������
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(application);
		PrivilegeService privilegeService = (PrivilegeService)ac.getBean("privilegeServiceImpl");
		
		//׼�����ж���Ȩ�޵ļ��ϣ������˵���
		List<Privilege> topPrivilegeList = privilegeService.findTopPrivilege();
		application.setAttribute("topPrivilegeList", topPrivilegeList);
System.out.println("===��׼�������ж���Ȩ�޵�����===");		

		// ׼������Ȩ�޵�URL����
		List<String> allPrivilegeUrls = privilegeService.getAllPrivilegeUrls();
		application.setAttribute("allPrivilegeUrls", allPrivilegeUrls);
System.out.println("--��׼��������Ȩ�޵�URL����---");		
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
