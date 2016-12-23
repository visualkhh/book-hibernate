package com.khh.hibernate.chapter6.criteria.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


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
	public User() {}
	public User(String name,List<Car> cars) {this.name=name;this.cars=cars;}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_SEQ")
	List<Car> cars;
}
