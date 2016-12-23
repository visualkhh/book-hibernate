package com.khh.hibernate.chapter7.query.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@SequenceGenerator(name = User.SEQ_NAME, sequenceName = User.SEQ_NAME, allocationSize = 1)
//@NamedQueries(
//		value = {
//				@NamedQuery(name = User.NQ_FIND_ALL, query = "from User"),
//				@NamedQuery(name = User.NQ_FIND_BY_USERNAME, query = "from User where name=:name")
//		}
//)
@NamedNativeQueries(
		value = {
				@NamedNativeQuery(name = User.SQ_FIND_ALL, query = "SELECT * FROM USER" , resultClass = User.class),
				@NamedNativeQuery(name = User.SQ_FIND_BY_USERNAME, query = "SELECT * FROM USER WHERE NAME=:name")
		}
)

public class User {
	public static final String SEQ_NAME = "SEQ_USER";
//	public static final String NQ_FIND_ALL = "USER_findAll";
//	public static final String NQ_FIND_BY_USERNAME = "USER_findByUsername";
	public static final String SQ_FIND_ALL = "USER_S_findAll";
	public static final String SQ_FIND_BY_USERNAME = "USER_S_findByUsername";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_SEQ")
	Integer seq;
	String name;
	public User() {}
	public User(String name,List<Car> cars) {this.name=name;this.cars=cars;}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_SEQ")
	List<Car> cars;
}
