package com.khh.hibernate.chapter1.id.composite.entity;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@Entity
public class UserInfo_EmbeddedId {
	@EmbeddedId
	UserPK_EmbeddedId id;
	String address;
	Integer age;
}
