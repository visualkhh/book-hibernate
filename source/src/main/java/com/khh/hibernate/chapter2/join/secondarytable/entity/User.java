package com.khh.hibernate.chapter2.join.secondarytable.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data @NoArgsConstructor @Entity @IdClass(UserId.class)
//@SequenceGenerator(name = User.SEQ_NAME, sequenceName = User.SEQ_NAME, initialValue = 100, allocationSize = 1)
public class User {
	public static final String SEQ_NAME = "SEQ_USER";

	@Builder
	public User(Integer userSeq, String name, String password, Integer userInfoSeq) {
		this.userSeq = userSeq;
		this.name = name;
		this.password = password;
		this.userInfoSeq = userInfoSeq;
	}

	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQ_NAME)
	@Column(name = "USER_SEQ")
	Integer userSeq;
	String name;
	String password;

	@Id
	@Column(name = "USER_INFO_SEQ")
	Integer userInfoSeq;
}
