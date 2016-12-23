package com.khh.hibernate.chapter1.id.generation.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class UserGen_IDENTITY {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer seq;
	String name;
	String address;
	Integer age;
}
