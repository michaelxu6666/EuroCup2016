package com.xl.fm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.xl.fm.domain.Player;

public class TestSpring {
	
	private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	/**
	 * 初始化数据库中的表（建表）
	 */
	@Test
	public void saveEntities() {
		SessionFactory sessionFactory = (SessionFactory)ac.getBean("sessionFactory");
		
		
		Session session = sessionFactory.getCurrentSession();
		
		/*Player p = new Player();
		p.setName("player-test");
		session.save(p);*/
		
		
		
	}
	
}
