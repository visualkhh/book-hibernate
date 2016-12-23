package com.khh.hibernate.chapter1.id.composite.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(UserPK_IdClass.class)
public class UserInfo_IdClass {
	@Id
	String name;
	@Id
	Integer number;
	String address;
	Integer age;
}
