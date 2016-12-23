//package com.khh.hibernate.c2.join.manytoone;
//
//import com.khh.hibernate.HibernateSet;
//import com.khh.hibernate.c2.join.onetomany.entity.CoffeShop;
//import User;
//import lombok.extern.slf4j.Slf4j;
//import org.hibernate.Session;
//
//import java.util.Date;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@Slf4j
//public class ManyToOneTest extends HibernateSet{
//
//	public void run() {
//		Session session = getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//
//		save(session);
//		session.flush();
//		session.clear();
//
//
//
//		//////Fetch
////		User userBydb = session.get(User.class,100);		//부모테이블만 조회
////		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
////		//아래에서 사용할때 자식테이블 조회
////		userBydb.getAuths().forEach(it->log.info("get(DB)"+it.getUser().getName()));
//
//
//		session.getTransaction().commit();
//	}
//
//	private void save(Session session) {
//		CoffeShop auth1 = new CoffeShop();
//		auth1.setAuth("ROLE_ADMIB");
//		auth1.setExpiry(new Date());
//		CoffeShop auth2 = new CoffeShop();
//		auth2.setAuth("ROLE_USER");
//		auth2.setExpiry(new Date());
////		List s = Stream.of(auth).collect(Collectors.toCollection(ArrayList::new));
//
//		User user = new User();
//		user.setSeq(50);
////		user.setAuths(Stream.of(auth1,auth2).map(it->{it.setSeq(user.getSeq());return it;}).collect(Collectors.toList()));
////		user.setAuths(Stream.of(auth1,auth2).peek(it->it.setSeq(user.getSeq())).collect(Collectors.toList()));
////		user.setAuths(Stream.of(auth1,auth2).collect(Collectors.toList()));
////		user.setAuths();
//		user.setName("name");
//		user.setPassword("pwd");
//		session.save(user);
//	}
//
//	public static void main(String[] arg){
//		try {
//			new ManyToOneTest().run();
//		}catch (Throwable e){
//			log.error("Exception",e);
//		}finally {
//			//System.exit(0);
//		}
//	}
//}
