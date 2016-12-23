package com.khh.hibernate.chapter7.query;

import com.khh.hibernate.HibernateSet;
import com.khh.hibernate.chapter7.query.entity.Car;
import com.khh.hibernate.chapter7.query.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Slf4j
public class QueryTest extends HibernateSet{
	public QueryTest(List<String> resource) {
		super(resource);
	}

	public QueryTest() {
	}

	public void run() {
		try {
			Session session = getSessionFactory().getCurrentSession();
			session.beginTransaction();

			IntStream.range(1,5).forEach(it->{
				User user = new User("name_"+it, Arrays.asList(new Car("CAR_"+it),new Car("TRUCK_"+it)));
				session.save(user);
			});

			session.flush();
			session.clear();

	//		Query query = session.getNamedQuery(User.NQ_FIND_ALL);
	//		Query query = session.getNamedQuery("MNQ_USER_FINDALL");
	//		Query query = session.getNamedQuery(User.NQ_FIND_BY_USERNAME);
	//		NativeQuery query = session.getNamedNativeQuery(User.SQ_FIND_ALL);


			//groovy template dynamic query
			NativeQuery query = session.getNamedNativeQuery("MSQ_USER");
			String queryStr = query.getQueryString();
			Map<String,Object> param = new HashMap<>();
			param.put("name","name_2");
			queryStr = makeGQuery(queryStr, param);
			NativeQuery dynamicQuery = session.createNativeQuery(queryStr);
			param.entrySet().stream().forEach(it->dynamicQuery.setParameter(it.getKey(),it.getValue()));
			query = dynamicQuery;
			List<Object[]> users = query.getResultList();
			users.stream().forEach(it->log.debug("-->"+it[1]));


//			List<User> users = query.getResultList();

//			users.stream().forEach(it->log.debug("-->"+it.getName()));


			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] arg){
		try {
			new QueryTest(Arrays.asList("query.hbm.xml")).run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
