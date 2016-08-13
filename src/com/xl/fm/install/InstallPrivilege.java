package com.xl.fm.install;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xl.fm.domain.Privilege;
@Component
public class InstallPrivilege {
	
	/*欧洲杯信息
		教练管理
			教练列表
			教练删除
			教练增加
			教练修改
		国家管理
			国家列表
			国家删除
			国家增加
			国家修改
		球员管理
			球员列表
			球员删除
			球员增加
			球员修改
		比赛管理
			比赛列表
			比赛删除
			比赛增加
			比赛修改
		用户管理
			用户列表
			用户删除
			用户增加
			用户修改*/
	@Resource
	SessionFactory sessionFactory;
	
	@Transactional
	public void install() {
		
	Session session = sessionFactory.getCurrentSession();
	
	Privilege menu, menu1, menu2, menu3, menu4, menu5;
	
	menu = new Privilege("欧洲杯信息", null, "footable.gif", null);
	menu1 = new Privilege("教练管理","coachAction_list", null, menu);
	menu2 = new Privilege("国家管理","countryAction_list", null, menu);
	menu3 = new Privilege("球员管理","playerAction_list", null, menu);
	menu4 = new Privilege("比赛管理","matchAction_list", null, menu);
	menu5 = new Privilege("用户管理","userAction_list", null, menu);
	
	session.save(menu);
	session.save(menu1);
	session.save(menu2);
	session.save(menu3);
	session.save(menu4);
	session.save(menu5);
	
	session.save(new Privilege("教练列表","coachAction_list", null, menu1));	
	session.save(new Privilege("教练删除","coachAction_delete", null, menu1));	
	session.save(new Privilege("教练添加","coachAction_add", null, menu1));	
	session.save(new Privilege("教练修改","coachAction_edit", null, menu1));	
	
	session.save(new Privilege("国家列表","countryAction_list", null, menu2));	
	session.save(new Privilege("国家删除","countryAction_delete", null, menu2));	
	session.save(new Privilege("国家添加","countryAction_add", null, menu2));	
	session.save(new Privilege("国家修改","countryAction_edit", null, menu2));	
	
	session.save(new Privilege("球员列表","playerAction_list", null, menu3));	
	session.save(new Privilege("球员删除","playerAction_delete", null, menu3));	
	session.save(new Privilege("球员添加","playerAction_add", null, menu3));	
	session.save(new Privilege("球员修改","playerAction_edit", null, menu3));	
	
	session.save(new Privilege("比赛列表","matchAction_list", null, menu4));	
	session.save(new Privilege("比赛删除","matchAction_delete", null, menu4));	
	session.save(new Privilege("比赛添加","matchAction_add", null, menu4));	
	session.save(new Privilege("比赛修改","matchAction_edit", null, menu4));	
	
	session.save(new Privilege("用户列表","userAction_list", null, menu5));	
	session.save(new Privilege("用户删除","userAction_delete", null, menu5));	
	session.save(new Privilege("用户添加","userAction_add", null, menu5));	
	session.save(new Privilege("用户修改","userAction_edit", null, menu5));	
	}
	
	public static void main(String[] args) {
		System.out.println("正在执行安装......");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		InstallPrivilege inspvg = (InstallPrivilege)ac.getBean("installPrivilege");
		
		inspvg.install();
		
		System.out.println("===安装完毕===");
	}
	
	
}




































