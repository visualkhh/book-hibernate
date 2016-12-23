package com.khh.hibernate.chapter6.criteria;

import com.khh.hibernate.HibernateSet;
import com.khh.hibernate.chapter6.criteria.entity.Car;
import com.khh.hibernate.chapter6.criteria.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class CriteriaTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();

		IntStream.range(1,5).forEach(it->{
			User user = new User("name_"+it, Arrays.asList(new Car("CAR_"+it),new Car("TRUCK_"+it)));
//			User user = new User("name", Arrays.asList(new Car("CAR_"+it),new Car("TRUCK_"+it)));
			session.save(user);
		});

		session.flush();
		session.clear();


		// Create CriteriaBuilder
		CriteriaBuilder builder = session.getCriteriaBuilder();

		// Create CriteriaQuery
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> studentRoot = criteria.from(User.class);

		Predicate w1 = builder.equal(studentRoot.get("seq"), 1);
		Predicate w2 = builder.equal(studentRoot.get("name"), "name_1");
		Predicate w3 = builder.like(studentRoot.get("name"), "name_1");
		Predicate w4 = builder.between(studentRoot.get("seq"), 1,100);
//		Predicate w2 = builder.equal(studentRoot.get("name"), builder.parameter(String.class,"name_1"));
		Predicate w = builder.or(w1, w2, w3, w4);

//		criteria.select(studentRoot).where(w).groupBy(studentRoot.get("name"));
		criteria.multiselect(studentRoot.get("*"), builder.count(studentRoot));
		Projections.rowCount();
		TypedQuery<User> query = session.createQuery(criteria);
//		log.debug(query.toString());
//		query.setParameter(1,new Integer(1));
		
		List<User> contacts = query.getResultList();
//		contacts.forEach(it->{
//			log.debug(it.getCars().get(0).getModel());
//		});
//		ParameterExpression<Integer> id = criteria.parameter(Integer.class);
//
//		cq.select(studentRoot).where(cb.eq(studentRoot.get("id"),id));
//
//		TypedQuery<Student3> query = em.createQuery(cq);
//		query.setParameter(p, 2);
//		List<Student3> results = query.getResultList();


		session.getTransaction().commit();
	}

	public static void main(String[] arg){
		try {
			new CriteriaTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
