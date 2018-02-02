package com.khh.hibernate.chapter2.join.secondarytable;

import com.khh.hibernate.HibernateSet;
import com.khh.hibernate.chapter2.join.onetoone.entity.User;
import com.khh.hibernate.chapter2.join.onetoone.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

@Slf4j
public class SecondaryTableTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();



		session.getTransaction().commit();
	}

	public static void main(String[] arg){
		try {
			new SecondaryTableTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
