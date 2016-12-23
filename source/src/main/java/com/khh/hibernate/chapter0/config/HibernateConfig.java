package com.khh.hibernate.chapter0.config;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.SQLException;
@Slf4j
@Data
public class HibernateConfig implements  Runnable{

	Server server = null;
	SessionFactory sessionFactory = null;


	public HibernateConfig() throws SQLException {
		//H2 Database Start
		server = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8088").start();

//		script.e
		//외부 XML으로 설정
		Configuration configuration = getHibernateConfigByCode();
		//CODE BASE로 설정
		//Configuration configuration = getHibernateConfigByCode();

		//Build
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(serviceRegistryBuilder.build());
		configuration.buildSessionFactory(serviceRegistryBuilder.build());
	}

	public Configuration getHibernateConfigByXML() throws SQLException {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		return configuration;
	}
	public Configuration getHibernateConfigByCode() {
		Configuration configuration = new Configuration();
		configuration.setProperty(Environment.DIALECT, 							"org.hibernate.dialect.H2Dialect");
		configuration.setProperty(Environment.DRIVER, 							"org.h2.Driver");
		configuration.setProperty(Environment.URL, 								"jdbc:h2:mem:test");
		configuration.setProperty(Environment.USER, 							"sa");
		configuration.setProperty(Environment.PASS, 							"");
		configuration.setProperty(Environment.POOL_SIZE, 						"55");
		configuration.setProperty(Environment.STATEMENT_BATCH_SIZE, 			"30");
		configuration.setProperty(Environment.AUTOCOMMIT, 						"true");
		configuration.setProperty(Environment.SHOW_SQL, 						"true");
		configuration.setProperty(Environment.FORMAT_SQL, 						"true");
		configuration.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, 	"thread");
		configuration.setProperty(Environment.HBM2DDL_AUTO, 					"create-drop");
		return configuration;
	}

	public void run() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();


		session.getTransaction().commit();
	}


	public static void main(String[] arg)  throws SQLException {
		new HibernateConfig().run();
	}
}
