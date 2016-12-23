package com.khh.hibernate.chapter5.pagination;

import com.khh.hibernate.HibernateSet;
import com.khh.hibernate.chapter5.pagination.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class PaginationTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();

		IntStream.range(1, 100).forEach(it->{
			session.save(new User("name"+it));
		});

		session.flush();
		session.clear();

		Query query = session.createQuery("from User");
		query.setFirstResult(30); //30번째 로우부터
		query.setMaxResults(5);  //5개를 가져와라
		List<User> users = query.getResultList();
		users.stream().forEach(it->log.debug("-->"+it));

		log.debug("-----------");

		query = session.createQuery("from User");
		query.setFirstResult(40); //40번째 로우부터
		query.setMaxResults(5);  //5개를 가져와라
		users = query.getResultList();
		users.stream().forEach(it->log.debug("-->"+it));

		session.getTransaction().commit();
	}

	public static void main(String[] arg){
		try {
			new PaginationTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
