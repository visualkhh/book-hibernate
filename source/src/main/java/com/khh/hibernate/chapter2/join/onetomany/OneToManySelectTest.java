package com.khh.hibernate.chapter2.join.onetomany;

import com.khh.hibernate.HibernateSet;
import com.khh.hibernate.chapter2.join.onetomany.entity.AuthComposite;
import com.khh.hibernate.chapter2.join.onetomany.entity.Company;
import com.khh.hibernate.chapter2.join.onetomany.entity.Emp;
import com.khh.hibernate.chapter2.join.onetomany.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import com.khh.hibernate.c2.join.onetomany.entity.CoffeShop;

@Slf4j
public class OneToManySelectTest extends HibernateSet{

	public void run() {
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();


		//insert
		Company company = new Company();
		company.setAddr("CompanyAddr");
		company.setName("VISUALKHH");
		company.setEmps(
				Arrays.asList(
						Emp.builder().name("KIM").age(10).build(),
						Emp.builder().name("WHA").age(23).build(),
						Emp.builder().name("GON").age(22).build()
				).stream().collect(Collectors.toSet())
		);
		session.save(company);
		session.flush();
		session.clear();
		session.getTransaction().commit();




		//select
		session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
//		company = session.get(Company.class, new Integer(100));
//		log.debug("company:{}",company);

		Query<Company> hql = session.createQuery("from Company c inner join fetch c.emps e where c.companySeq = :companySeq" , Company.class);
		hql.setParameter("companySeq", new Integer(100));
		company = hql.uniqueResult();
		log.debug("company:{}",company);














	}

	public static void main(String[] arg){
		try {
			new OneToManySelectTest().run();
		}catch (Throwable e){
			log.error("Exception",e);
		}finally {
			//System.exit(0);
		}
	}
}
