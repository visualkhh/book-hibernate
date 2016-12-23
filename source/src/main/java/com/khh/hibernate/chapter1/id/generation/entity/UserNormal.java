package com.khh.hibernate.chapter1.id.generation.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class UserNormal {
	@Id
	Integer seq;
	String name;
	String address;
	Integer age;
}
