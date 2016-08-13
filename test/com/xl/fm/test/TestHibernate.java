package com.xl.fm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.xl.fm.domain.Coach;
import com.xl.fm.domain.Country;
import com.xl.fm.domain.Match;
import com.xl.fm.domain.Player;

public class TestHibernate {
	
	Session session = getSession();
	@Test
	public void saveEntities() {
		Transaction trans = session.beginTransaction();
		
		Player p1 = new Player();
		p1.setName("player-test");
		
		Coach c1 = new Coach();
		c1.setName("coach-test");
		
		Country cty = new Country();
		cty.setName("country-test");
		
		Match m1 = new Match();
		m1.setName("match-test");
		
		session.save(p1);
//		session.save(c1);
//		session.save(cty);
//		session.save(m1);
		trans.commit();
		
	}
	
	public Session getSession() {
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		return sessionFactory.getCurrentSession();
		
	}
	
}
