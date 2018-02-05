package com.khh.hibernate.chapter2.join.secondarytable;

import com.khh.hibernate.HibernateSet;
//import com.khh.hibernate.chapter2.join.secondarytable.entity.UserJoin;
import com.khh.hibernate.chapter2.join.secondarytable.entity.User;
import com.khh.hibernate.chapter2.join.secondarytable.entity.UserInfo;
//import com.khh.hibernate.chapter2.join.secondarytable.entity.UserJoin2;
import com.khh.hibernate.chapter2.join.secondarytable.entity.UserJoin2;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

@Slf4j
public class SecondaryTableTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();

//		session.find(UserJoin.class, new Integer(11));

		session.save(UserInfo.builder().userSeq(1).addr("aa").build());
		session.save(User.builder().userSeq(1).userInfoSeq(1).name("an").password("aa").build());
		session.save(User.builder().userSeq(1).userInfoSeq(2).name("an2").password("aabb").build());

		session.flush();


		UserJoin2 userJoin2 = session.find(UserJoin2.class, new Integer(1));
		if(null!=userJoin2){
			System.out.println(userJoin2.toString());
		}

		session.getTransaction().commit();
	}

	public static void main(String[] arg){
		try {
			new SecondaryTableTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
