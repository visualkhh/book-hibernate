package com.khh.hibernate.chapter5.element_collection;

import com.khh.hibernate.HibernateSet;
//import com.khh.hibernate.chapter5.element_collection.entity.Car;
import com.khh.hibernate.chapter5.element_collection.entity.Car;
import com.khh.hibernate.chapter5.element_collection.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.HashSet;

@Slf4j
public class ElementCollectionlTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();

		User user = new User();
		user.setName("name");
		user.setCars_set(new HashSet<Car>((Arrays.asList(new Car("MODEL_2"), new Car("MODEL_1")))));
		user.setCars_enum(Arrays.asList(User.CAR_TYPE.ENUM_MODEL_1,User.CAR_TYPE.ENUM_MODEL_2,User.CAR_TYPE.ENUM_MODEL_3));

		session.save(user);

		session.getTransaction().commit();
	}

	public static void main(String[] arg){
		try {
			new ElementCollectionlTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
