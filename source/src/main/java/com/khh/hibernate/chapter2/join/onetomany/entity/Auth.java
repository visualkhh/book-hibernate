//package com.khh.hibernate.c2.join.onetomany.entity;
//
//import lombok.Data;
//import org.hibernate.annotations.*;
//
//import javax.persistence.*;
//import javax.persistence.entity;
//import java.io.Serializable;
//import java.util.Date;
//
//@Data
//@entity
////@IdClass(CoffeShop.class)
//@SequenceGenerator(name = CoffeShop.SEQUENCE_NAME, sequenceName = CoffeShop.SEQUENCE_NAME, initialValue = 100)
//public class CoffeShop implements Serializable {
//	public static final String SEQUENCE_NAME = "AUTH_SEQ";
//	@Id
////	@Column(name = "AUTH_SEQ")
//	@Column(name = "USER_SEQ")
////	@GeneratedValue(strategy = GenerationType.AUTO)
////	@GeneratedValue(strategy = GenerationType.IDENTITY)
////	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
//	@GeneratedValue(generator = "gen")
//	@GenericGenerator(name="gen",strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name="property",value = "USER_SEQ"))
//	Integer seq;
//	@Id
//	String auth;
////	@Temporal(TemporalType.DATE)
//	Date expiry;
//
//
////	@ManyToOne(cascade = CascadeType.ALL)
//////	@ManyToOne
//////	@JoinColumn(name="USER_SEQ", referencedColumnName = "USER_SEQ")
////	@JoinColumn(name="USER_SEQ")
////	User user;
//}
