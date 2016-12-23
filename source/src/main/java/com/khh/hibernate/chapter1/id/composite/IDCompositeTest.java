package com.khh.hibernate.chapter1.id.composite;

import com.khh.hibernate.HibernateSet;
import com.khh.hibernate.chapter1.id.composite.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

@Slf4j
public class IDCompositeTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();

//		UserPK_Embededdable pk = new UserPK_Embededdable();
//		UserPK_EmbeddedId pk = new UserPK_EmbeddedId();
		UserInfo_IdClass pk = new UserInfo_IdClass();
		pk.setName("name");
		pk.setNumber(128);

//		UserInfo_Embededdable user = new UserInfo_Embededdable();
//		UserInfo_EmbeddedId user = new UserInfo_EmbeddedId();
//		user.setId(pk);
		UserInfo_IdClass user = pk;
		user.setAddress("korea");
		user.setAge(53);
		session.save(user);

		session.flush(); //db apply
		session.clear();


		//select
//		UserPK_Embededdable userPK = new UserPK_Embededdable();
		UserPK_EmbeddedId userPK = new UserPK_EmbeddedId();
//		UserPK_IdClass userPK = new UserPK_IdClass();
		userPK.setName("name");
		userPK.setNumber(128);
//		UserInfo_Embededdable userBydb = session.get(UserInfo_Embededdable.class,userPK);
		UserInfo_EmbeddedId userBydb = session.get(UserInfo_EmbeddedId.class,userPK);
//		UserInfo_IdClass userBydb = session.get(UserInfo_IdClass.class,userPK);
		if(null!=userBydb)
		log.info("get::"+userBydb.toString());



		session.getTransaction().commit();
	}


	public static void main(String[] arg){
		try {
			new IDCompositeTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
