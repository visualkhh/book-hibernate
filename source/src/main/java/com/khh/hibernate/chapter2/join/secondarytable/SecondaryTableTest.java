package com.khh.hibernate.chapter2.join.secondarytable;

import com.khh.hibernate.HibernateSet;
//import com.khh.hibernate.chapter2.join.secondarytable.entity.UserJoin;
import com.khh.hibernate.chapter2.join.secondarytable.entity.User;
import com.khh.hibernate.chapter2.join.secondarytable.entity.UserGroup;
import com.khh.hibernate.chapter2.join.secondarytable.entity.UserInfo;
//import com.khh.hibernate.chapter2.join.secondarytable.entity.UserJoin2;
import com.khh.hibernate.chapter2.join.secondarytable.entity.UserJoin2;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Slf4j
public class SecondaryTableTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();

//		session.find(UserJoin.class, new Integer(11));

		session.save(UserGroup.builder().userSeq(1).name("group").build());

		session.save(UserInfo.builder().userSeq(1).addr("1aa").build());
		session.save(UserInfo.builder().userSeq(2).addr("2aa").build());


		session.save(User.builder().userSeq(1).userInfoSeq(1).name("an").password("aa").build());
		session.save(User.builder().userSeq(1).userInfoSeq(2).name("an2").password("aabb").build());
		session.save(User.builder().userSeq(2).userInfoSeq(1).name("2-1").password("2-1pwd").build());


		session.flush();


//		UserJoin2 userJoin2 = session.find(UserJoin2.class, new Integer(1));
//		if(null!=userJoin2){
//			System.out.println(userJoin2.toString());
//		}
		session.clear();

//		UserGroup userGroup = session.find(UserGroup.class, new Integer(1));

//		CriteriaBuilder builder = getSessionFactory().getCriteriaBuilder();
//		CriteriaQuery<UserGroup> query = builder.createQuery(UserGroup.class);
//		Root<UserGroup> root = query.from(UserGroup.class);
//		query.select(root);
//		query.where( builder.equal( root.get( "" ), 2 ) );
//		Query<UserGroup> q = session.createQuery(query);
//		List<UserGroup> list = q.getResultList();



//		List<UserGroup> list = session.createQuery("select a from UserGroup as a left join fetch a.userJoin2 b where a.userSeq=1 and b.password='2-1pwd'").list();
		List<UserGroup> list = session.createQuery("select a from UserGroup as a left join a.userJoin2 b where a.userSeq=1 and b.userSeq=2").list();

		if(null!=list){
			System.out.println(list.toString());
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
