package com.khh.hibernate.chapter2.join.onetoone;

import com.khh.hibernate.HibernateSet;
import com.khh.hibernate.chapter2.join.onetoone.entity.UserInfo;
import com.khh.hibernate.chapter2.join.onetoone.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

@Slf4j
public class OneToOneTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();

		UserInfo info = new UserInfo();
		info.setAddr("addr");
		info.setHeight(180);
		info.setWeight(70);

		User user = new User();
		user.setName("name");
		user.setPassword("pwd");

		//서로의 관계를 맺어준다.
		user.setInfo(info);
		info.setUser(user);

		session.save(user);
		session.flush();
		session.clear();

//		User userBydb = session.get(User.class,1);
//		if(null!=user.getInfo().getUser())
//			log.debug("insert entity ---> "+user.getInfo().getUser().getName());
//		if(null!=userBydb.getInfo().getUser())
//			log.debug("get(DB) entity ---> "+userBydb.getInfo().getUser().getName());

		UserInfo userInfoBydb = session.get(UserInfo.class,100);
		if(null!=userInfoBydb && null!=userInfoBydb.getUser())
			log.debug("get(DB) entity ---> "+userInfoBydb.getUser().getName());

		session.getTransaction().commit();
	}

	public static void main(String[] arg){
		try {
			new OneToOneTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
