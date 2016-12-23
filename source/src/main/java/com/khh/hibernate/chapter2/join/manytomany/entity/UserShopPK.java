package com.khh.hibernate.chapter2.join.manytomany.entity;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class UserShopPK implements Serializable {
	@Column(name = "USER_SEQ")
	Integer user_seq;
	@Column(name = "SHOP_SEQ")
	Integer shop_seq;

	public UserShopPK() {
	}

	public UserShopPK(Integer user_seq){
		this.user_seq=user_seq;
	}

	public UserShopPK(Integer user_seq, Integer shop_seq){
		this.user_seq = user_seq;
		this.shop_seq = shop_seq;
	}
}
