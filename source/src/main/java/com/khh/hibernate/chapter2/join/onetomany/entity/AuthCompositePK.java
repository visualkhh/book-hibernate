package com.khh.hibernate.chapter2.join.onetomany.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
public class AuthCompositePK implements Serializable {
	public AuthCompositePK() {
	}

	public AuthCompositePK(Integer seq, String auth) {
		this.seq = seq;
		this.auth = auth;
	}

//	@Id
//	@Column(name = "USER_SEQ",nullable = false,insertable=false,updatable=false)
	@Column(name = "USER_SEQ",nullable = false)
//	@TableGenerator(name = "phone_gen", table = "USER", pkColumnName = "USER_SEQ", valueColumnName = "USER_SEQ")
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "phone_gen")
//	@TableGenerator(name = "phone_gen", table = "USER_SS", pkColumnName = "USER_SEQ", valueColumnName = "USER_SEQ")
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "phone_gen")
	Integer seq;
//	@Id
	@Column(nullable = false)
	String auth;
}