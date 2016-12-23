package com.khh.hibernate.c1;


import com.khh.hibernate.HibernateSet;
import org.h2.tools.Server;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

//@Slf4j
public class HibernateTest extends HibernateSet {
	private static final Logger log = LoggerFactory.getLogger(HibernateTest.class);

	public HibernateTest() throws SQLException {}



	@Before
	public void before(){
	}

	@Test
	@Override
	public void run() {
		log.debug("aaaaaaaa");
	}

	@After
	public void after(){

	}

}
