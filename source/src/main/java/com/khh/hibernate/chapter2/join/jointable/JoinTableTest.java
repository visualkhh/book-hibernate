package com.khh.hibernate.chapter2.join.jointable;

import com.khh.hibernate.HibernateSet;
import com.khh.hibernate.chapter2.join.jointable.entity.Auth;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

@Slf4j
public class JoinTableTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();


		session.find(Auth.class,Auth.ID.builder().seq(1).tempSeq(1).build());


		session.getTransaction().commit();
	}

	public static void main(String[] arg){
		try {
			new JoinTableTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
