package com.khh.hibernate.chapter2.join.jointable.entity;

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
	String password;

//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@OneToMany(cascade = CascadeType.ALL)
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn
	@JoinColumn(name = "USER_SEQ")
//	@JoinColumn(name = "USER_SEQ", referencedColumnName = "USER_SEQ")
//	@JoinColumn(name = "USER_SEQ", referencedColumnName = "SEQ", nullable = false)
//	@JoinColumn( nullable = false)
//	@JoinColumn(nullable = false)
	//@OrderColumn(name = "seq")
//	@PrimaryKeyJoinColumn
//	@JoinColumn(name = "USER_SEQ", referencedColumnName = "USER_SEQ")
//	@Cascade(CascadeType.ALL)
	List<Auth> auths = null;
}
