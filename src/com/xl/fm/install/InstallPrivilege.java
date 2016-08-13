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
	
	/*ŷ�ޱ���Ϣ
		��������
			�����б�
			����ɾ��
			��������
			�����޸�
		���ҹ���
			�����б�
			����ɾ��
			��������
			�����޸�
		��Ա����
			��Ա�б�
			��Աɾ��
			��Ա����
			��Ա�޸�
		��������
			�����б�
			����ɾ��
			��������
			�����޸�
		�û�����
			�û��б�
			�û�ɾ��
			�û�����
			�û��޸�*/
	@Resource
	SessionFactory sessionFactory;
	
	@Transactional
	public void install() {
		
	Session session = sessionFactory.getCurrentSession();
	
	Privilege menu, menu1, menu2, menu3, menu4, menu5;
	
	menu = new Privilege("ŷ�ޱ���Ϣ", null, "footable.gif", null);
	menu1 = new Privilege("��������","coachAction_list", null, menu);
	menu2 = new Privilege("���ҹ���","countryAction_list", null, menu);
	menu3 = new Privilege("��Ա����","playerAction_list", null, menu);
	menu4 = new Privilege("��������","matchAction_list", null, menu);
	menu5 = new Privilege("�û�����","userAction_list", null, menu);
	
	session.save(menu);
	session.save(menu1);
	session.save(menu2);
	session.save(menu3);
	session.save(menu4);
	session.save(menu5);
	
	session.save(new Privilege("�����б�","coachAction_list", null, menu1));	
	session.save(new Privilege("����ɾ��","coachAction_delete", null, menu1));	
	session.save(new Privilege("�������","coachAction_add", null, menu1));	
	session.save(new Privilege("�����޸�","coachAction_edit", null, menu1));	
	
	session.save(new Privilege("�����б�","countryAction_list", null, menu2));	
	session.save(new Privilege("����ɾ��","countryAction_delete", null, menu2));	
	session.save(new Privilege("�������","countryAction_add", null, menu2));	
	session.save(new Privilege("�����޸�","countryAction_edit", null, menu2));	
	
	session.save(new Privilege("��Ա�б�","playerAction_list", null, menu3));	
	session.save(new Privilege("��Աɾ��","playerAction_delete", null, menu3));	
	session.save(new Privilege("��Ա���","playerAction_add", null, menu3));	
	session.save(new Privilege("��Ա�޸�","playerAction_edit", null, menu3));	
	
	session.save(new Privilege("�����б�","matchAction_list", null, menu4));	
	session.save(new Privilege("����ɾ��","matchAction_delete", null, menu4));	
	session.save(new Privilege("�������","matchAction_add", null, menu4));	
	session.save(new Privilege("�����޸�","matchAction_edit", null, menu4));	
	
	session.save(new Privilege("�û��б�","userAction_list", null, menu5));	
	session.save(new Privilege("�û�ɾ��","userAction_delete", null, menu5));	
	session.save(new Privilege("�û����","userAction_add", null, menu5));	
	session.save(new Privilege("�û��޸�","userAction_edit", null, menu5));	
	}
	
	public static void main(String[] args) {
		System.out.println("����ִ�а�װ......");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		InstallPrivilege inspvg = (InstallPrivilege)ac.getBean("installPrivilege");
		
		inspvg.install();
		
		System.out.println("===��װ���===");
	}
	
	
}




































