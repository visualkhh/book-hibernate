package com.khh.hibernate.chapter5.embedded;

import com.khh.hibernate.HibernateSet;
import com.khh.hibernate.chapter5.embedded.entity.Address;
import com.khh.hibernate.chapter5.embedded.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

@Slf4j
public class EmbeddedlTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Address addr = new Address();
		addr.setAddr("address");
		addr.setCountry("KOREA");
		addr.setMail("visualkhh@gmail.com");
		addr.setZip("08-08");

		User user = new User();
		user.setName("name");
		user.setAddr(addr);

		session.save(user);

		session.getTransaction().commit();
	}

	public static void main(String[] arg){
		try {
			new EmbeddedlTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
