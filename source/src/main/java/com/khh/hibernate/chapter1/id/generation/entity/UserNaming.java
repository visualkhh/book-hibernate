package com.khh.hibernate.chapter1.id.generation.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "USER")
public class UserNaming {
	@Id
	@Column(name = "JUMIN_NUMBER")
	Integer seq;
	@Column(name = "USER_NAME")
	String name;
	@Column(name = "USER_ADDR")
	String address;
	@Column(name = "USER_AGE")
	Integer age;
}
