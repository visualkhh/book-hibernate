package com.khh.hibernate.chapter1.id.generation;

import com.khh.hibernate.HibernateSet;
import com.khh.hibernate.chapter1.id.generation.entity.UserGen_AUTO;
import com.khh.hibernate.chapter1.id.generation.entity.UserGen_SEQUENCE;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
@Slf4j
public class IDGenerationTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();

//		UserGen_SEQUENCE user = new UserGen_SEQUENCE();
//		UserGen_IDENTITY user = new UserGen_IDENTITY();
//		UserGen_TABLE user = new UserGen_TABLE();
		UserGen_AUTO user = new UserGen_AUTO();
		user.setName("name");
		user.setAddress("addr");
		user.setAge(100);
		session.save(user);

		session.getTransaction().commit();
	}

	public static void main(String[] arg){
		try {
			new IDGenerationTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
