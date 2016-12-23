package com.khh.hibernate.chapter2.join.onetoone.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@SequenceGenerator(name = User.SEQ_NAME, sequenceName = User.SEQ_NAME, initialValue = 100, allocationSize = 1)
public class User {
	public static final String SEQ_NAME = "SEQ_USER";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQ_NAME)
	@Column(name = "USER_SEQ")
	Integer seq;
	String name;
	String password;
	@OneToOne(cascade = CascadeType.ALL)
//	@MapsId
//	@JoinColumn(name = "USER_SEQ", referencedColumnName="SEQ")
//	@PrimaryKeyJoinColumn(name = "USER_SEQ", referencedColumnName="SEQ")
//	@JoinColumn(name = "GGGG")
	UserInfo info;
}
