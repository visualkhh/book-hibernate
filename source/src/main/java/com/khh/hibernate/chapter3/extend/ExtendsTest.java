package com.khh.hibernate.chapter3.extend;

import com.khh.hibernate.HibernateSet;
import com.khh.hibernate.chapter3.extend.entity.child.UserBankPrivacy;
import com.khh.hibernate.chapter3.extend.entity.child.UserBodyPrivacy;
import com.khh.hibernate.chapter3.extend.entity.child.UserOfficePrivacy;
import com.khh.hibernate.chapter3.extend.entity.UserConcreteClass;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

@Slf4j
public class ExtendsTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();


//		User user = new User();
//		UserSubClass user = new UserSubClass();
		UserConcreteClass user = new UserConcreteClass();
		user.setName("nameOffice");
		session.save(user);

		UserOfficePrivacy userOffice = new UserOfficePrivacy();
		userOffice.setName("nameOffice");
		userOffice.setAddress("addr");
		session.save(userOffice);

		UserBodyPrivacy userBody = new UserBodyPrivacy();
		userBody.setName("nameBody");
		userBody.setAge(2);
		userBody.setWeight(2.0);
		userBody.setHeight(2.0);
		session.save(userBody);

		UserBankPrivacy userBank = new UserBankPrivacy();
//		userBank.setName("nameBank");
		userBank.setPassword("pwd");
		session.save(userBank);


		session.getTransaction().commit();
	}

	public static void main(String[] arg){
		try {
			new ExtendsTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
