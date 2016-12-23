package com.khh.hibernate.chapter2.join.manytomany.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@SequenceGenerator(name = User.SEQUENCE_NAME, sequenceName = User.SEQUENCE_NAME, initialValue = 100)
public class User {
	public static final String SEQUENCE_NAME = "USER_SEQ";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "USER_SEQ")
	Integer seq;
	String name;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "USER_SEQ", referencedColumnName = "SHOP_SEQ", nullable = false)
//	List<CoffeShop> shops = null;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	List<UserShop> shops = null;
}
