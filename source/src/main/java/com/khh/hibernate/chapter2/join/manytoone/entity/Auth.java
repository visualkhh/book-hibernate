package com.khh.hibernate.chapter2.join.manytoone.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
//@IdClass(CoffeShop.class)
@SequenceGenerator(name = Auth.SEQUENCE_NAME, sequenceName = Auth.SEQUENCE_NAME, initialValue = 100)
public class Auth implements Serializable {
	public static final String SEQUENCE_NAME = "AUTH_SEQ";
	@Id
	@Column(name = "AUTH_SEQ")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	Integer seq;
	@Id
	String auth;
//	@Temporal(TemporalType.DATE)
	Date expiry;


	@ManyToOne(cascade = CascadeType.ALL)
//	@ManyToOne
//	@JoinColumn(name="USER_SEQ", referencedColumnName = "USER_SEQ")
//	@JoinColumn(name="USER_SEQ")
			User user;
}
