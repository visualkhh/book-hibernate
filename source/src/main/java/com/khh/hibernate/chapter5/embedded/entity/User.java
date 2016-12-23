package com.khh.hibernate.chapter5.embedded.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@SequenceGenerator(name = User.SEQ_NAME, sequenceName = User.SEQ_NAME, allocationSize = 1)
public class User {
	public static final String SEQ_NAME = "SEQ_USER";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_SEQ")
	Integer seq;
	String name;

	@Embedded
	Address addr;
}
