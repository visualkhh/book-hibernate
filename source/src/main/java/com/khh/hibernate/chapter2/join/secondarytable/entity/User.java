package com.khh.hibernate.chapter2.join.secondarytable.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity @IdClass(UserId.class)
@SequenceGenerator(name = User.SEQ_NAME, sequenceName = User.SEQ_NAME, initialValue = 100, allocationSize = 1)
public class User {
	public static final String SEQ_NAME = "SEQ_USER";


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQ_NAME)
	@Column(name = "USER_SEQ")
	Integer seq;
	String name;
	String password;

	@Id
	@Column(name = "USER_INFO_SEQ")
	Integer userInfoSeq;
}
