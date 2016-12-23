package com.khh.hibernate.chapter2.join.manytomany.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="COFFESHOP")
@SequenceGenerator(name = CoffeShop.SEQUENCE_NAME, sequenceName = CoffeShop.SEQUENCE_NAME, initialValue = 100)
public class CoffeShop implements Serializable {
	public static final String SEQUENCE_NAME = "SHOP_SEQ";
	@Id
	@Column(name = "SHOP_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	Integer seq;

	String name;
	Date open;
	Date close;

//	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "shops")
//	List<User> users = null;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "shop")
	List<UserShop> shops = null;


}
