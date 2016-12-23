package com.khh.hibernate.chapter2.join.onetomany;

import com.khh.hibernate.HibernateSet;
//import com.khh.hibernate.c2.join.onetomany.entity.CoffeShop;
import com.khh.hibernate.chapter2.join.onetomany.entity.AuthComposite;
import com.khh.hibernate.chapter2.join.onetomany.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class OneToManyTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();

		save(session);
		session.flush();
		session.clear();



		//////Fetch
//		User userBydb = session.get(User.class,100);		//부모테이블만 조회
//		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
//		//아래에서 사용할때 자식테이블 조회
//		userBydb.getAuths().forEach(it->log.info("get(DB)"+it.getUser().getName()));


		session.getTransaction().commit();
	}

	private void save(Session session) {
//		CoffeShop auth1 = new CoffeShop();
//		auth1.setAuth("ROLE_ADMIB");
//		auth1.setExpiry(new Date());
//		CoffeShop auth2 = new CoffeShop();
//		auth2.setAuth("ROLE_USER");
//		auth2.setExpiry(new Date());

		AuthComposite authc1 = new AuthComposite();
		authc1.setAuth("ROLE_ADMIN");
//		authc1.setPk(new AuthCompositePK(null,"ROLE_ADMIB"));
		authc1.setExpiry(new Date());
		AuthComposite authc2 = new AuthComposite();
		authc2.setAuth("ROLE_USER");
//		authc2.setPk(new AuthCompositePK(null,"ROLE_USER"));
		authc2.setExpiry(new Date());
//		List s = Stream.of(auth).collect(Collectors.toCollection(ArrayList::new));

		User user = new User();
//		user.setSeq(100);
//		user.setAuths(Stream.of(auth1,auth2).map(it->{it.setSeq(user.getSeq());return it;}).collect(Collectors.toList()));
//		user.setAuths(Stream.of(auth1,auth2).peek(it->it.setSeq(user.getSeq())).collect(Collectors.toList()));
//		user.setAuths(Stream.of(auth1,auth2).collect(Collectors.toList()));
//		user.setAuths(Stream.of(authc1,authc2).collect(Collectors.toList()));
//		user.setAuths(Stream.of(authc1,authc2).peek(it->{it.setUser(user);}).collect(Collectors.toList()));
//		user.setAuths(Stream.of(authc1,authc2).peek(it->{it.setUser(user);}).toArray(AuthComposite[]::new));
//		user.setAuths(Stream.of(authc1,authc2).peek(it->{it.setUser(user);}).collect(Collectors.toSet()));
		user.setAuths(Stream.of(authc1,authc2).peek(it->{it.setUser(user);}).collect(Collectors.toMap(c-> c.getAuth(),c->c)));
//		user.setAuths(Stream.of(authc1,authc2).peek(it->{it.setSeq(user.getSeq())}).collect(Collectors.toList()));
//		user.setAuths();
		user.setName("name");
		user.setPassword("pwd");
		log.debug("-save before--->"+user.getSeq());
		Serializable id = session.save(user);
		log.debug("-save after--->"+user.getSeq());
//		session.getTransaction().commit();
		//session.persist(user);
//		User userBydb = session.get(User.class, id);
//		userBydb.setAuths(Stream.of(authc1,authc2).peek(it->it.setSeq(userBydb.getSeq())).collect(Collectors.toList()));
//		user.getAuths().forEach(it->it.setSeq(user.getSeq()));
//		log.debug("-merge before--->"+user.getAuths());
//		session.update(user);
//		log.debug("-merge after--->"+user.getAuths());

//		session.persist(user);
//		log.debug("---->"+user.getSeq());
//		user.setAuths(Stream.of(authc1,authc2).collect(Collectors.toList()));
//		session.save(user);
		session.flush();
		session.clear();

//		AuthComposite g = session.get(AuthComposite.class,new AuthCompositePKID(100,"RO2O"));
//		log.debug("==>"+g.getUser().getSeq());
	}

	public static void main(String[] arg){
		try {
			new OneToManyTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
