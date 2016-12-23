package com.khh.hibernate.chapter2.join.manytomany;

import com.khh.hibernate.HibernateSet;
import com.khh.hibernate.chapter2.join.manytomany.entity.CoffeShop;
import com.khh.hibernate.chapter2.join.manytomany.entity.User;
import com.khh.hibernate.chapter2.join.manytomany.entity.UserShop;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

@Slf4j
public class ManyToManyTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();

//		User user1 = new User();
//		user1.setName("name1");
//		User user2 = new User();
//		user2.setName("name2");
//
//		CoffeShop shop1 = new CoffeShop();
//		shop1.setName("shop1");
//		CoffeShop shop2 = new CoffeShop();
//		shop2.setName("shop2");
//
//		user1.setShops(Arrays.asList(shop1,shop2));
//		user2.setShops(Arrays.asList(shop1,shop2));
//
//		session.save(user1);
//		session.save(user2);
		User user1 = new User();
		user1.setName("name1");
		User user2 = new User();
		user2.setName("name2");
		session.save(user1);
		session.save(user2);

		CoffeShop shop1 = new CoffeShop();
		shop1.setName("shop1");
		CoffeShop shop2 = new CoffeShop();
		shop2.setName("shop2");
		session.save(shop1);
		session.save(shop2);
//
		UserShop userShop = new UserShop();
		userShop.setUser_seq(user1.getSeq());
		userShop.setShop_seq(shop1.getSeq());
		session.save(userShop);

		userShop = new UserShop();
		userShop.setUser_seq(user1.getSeq());
		userShop.setShop_seq(shop2.getSeq());
		session.save(userShop);


		session.flush();
		session.clear();



		//		UserShop byDB = session.get(UserShop.class,new UserShopPK(100,101));
//		log.debug(byDB.getUser_seq()+"<--(1)-->"+byDB.getShop_seq());
//		log.debug(byDB.getUser()+"<--(1)-->"+byDB.getShop());
//
//		session.refresh(byDB);
//		log.debug(byDB.getUser_seq()+"<--(2)-->"+byDB.getShop_seq());
//		log.debug(byDB.getUser()+"<--(2)-->"+byDB.getShop());
//		log.debug(byDB.getUser().getName()+"<--->"+byDB.getShop().getName());

//		session.clear();
		User userBydb = session.get(User.class,100);
//		User userBydb2 = session.get(User.class,1001);
		if(null==userBydb){
			log.debug("-101-null_T_T>" + userBydb);
		}else {
			log.debug("-101->" + userBydb.getName()+"  -->"+userBydb.getShops().size());
		}
//
//		if(null==userBydb2){
//			log.debug("-1001-null_T_T>" + userBydb2);
//		}else {
//			log.debug("-1001->" + userBydb2.getName());
//		}


//		session.flush();
//		session.clear();
//		CoffeShop shopBydb = session.get(CoffeShop.class,100);
//		shopBydb.getUsers().forEach(it->log.debug("-->"+it.getName()));
		session.getTransaction().commit();
	}

	public static void main(String[] arg){
		try {
			new ManyToManyTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
