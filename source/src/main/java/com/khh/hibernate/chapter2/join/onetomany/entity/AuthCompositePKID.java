package com.khh.hibernate.chapter2.join.onetomany.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Data
public class AuthCompositePKID implements Serializable {
	public AuthCompositePKID() {
	}


	public AuthCompositePKID(Integer seq, String auth) {
		this.seq = seq;
		this.auth = auth;
	}
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_SEQ",nullable = false)
	Integer seq;
	@Column(nullable = false)
	String auth;
}