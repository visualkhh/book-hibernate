package com.khh.hibernate.chapter2.join.manytomany.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@IdClass(UserShopPK.class)
public class UserShop{
	@Id
	Integer user_seq;
	@Id
	Integer shop_seq;

	@ManyToOne(cascade = CascadeType.ALL)
//	@ManyToOne
	@JoinColumn(name="USER_SEQ", referencedColumnName = "USER_SEQ", insertable = false, updatable = false)
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
//	@ManyToOne
	@JoinColumn(name="SHOP_SEQ",referencedColumnName = "SHOP_SEQ", insertable = false, updatable = false)
	private CoffeShop shop;

	@Temporal(TemporalType.TIMESTAMP)
//	@ColumnDefault("now()")
	@Version
	Date reg;
//	Date reg = new Date();
}
