package com.khh.hibernate.chapter4.hsql;

import com.khh.hibernate.HibernateSet;
import com.khh.hibernate.chapter4.hsql.entity.Office;
import com.khh.hibernate.chapter4.hsql.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Arrays;

@Slf4j
public class HsqlTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();

		User user = new User();
		user.setName("nanme1");
		user.setPassword("pwd1");
		session.save(user);

		Office office = new Office();
		office.setSeq(user.getSeq());
		office.setAddr("guro1");
		session.save(office);


		user = new User();
		user.setName("nanme2");
		user.setPassword("pwd2");
		session.save(user);
		office = new Office();
		office.setSeq(user.getSeq());
		office.setAddr("guro2");
		session.save(office);



		session.flush();
		session.clear();

//		Query query = session.createQuery("from User as A, Office as B where A.seq = 1 AND A.seq = B.seq");
//		Query query = session.createQuery("SELECT new Office (B.seq,B.addr) from User as A, Office as B where A.seq = 1 AND A.seq = B.seq");
//		Query query = session.createQuery("from User as A where A.seq = 1");
//		Query query = session.createQuery("from User as A where A.seq = ?");
//		query.setParameter(0, new Integer(1));
		Query query = session.createQuery("from User as A where A.seq in :seq");
		query.setParameter("seq", Arrays.asList(new Integer(1),new Integer(2),new Integer(3),new Integer(4),new Integer(5)));
//		Query query = session.createQuery("SELECT MAX(A.seq) from User as A");
//		Query query = session.createQuery("SELECT MAX(A.seq), MIN(A.seq), AVG(A.seq), COUNT(*) from User as A");
//		List<Object[]> list = query.getResultList();
//		list.forEach(it->{
//			for (Object entity : it) {
//				log.debug("-->"+entity.toString());
//			}
//		});
//		List<Office> list = query.getResultList();
//		list.forEach(it->log.debug("-->"+it.toString()));
//		Object result = query.getSingleResult();
//		log.debug("-->"+result);

		Object[] results = (Object[]) query.getSingleResult();
		for (Object entity : results) {
			log.debug("-->"+entity.toString());
		}
//		List<User> users = query.getResultList();
//		users.forEach(it->log.debug(it.toString()));


		session.getTransaction().commit();
	}

	public static void main(String[] arg){
		try {
			new HsqlTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
