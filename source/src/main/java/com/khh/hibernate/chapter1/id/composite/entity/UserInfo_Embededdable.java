package com.khh.hibernate.chapter1.id.composite.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class UserInfo_Embededdable {
	@Id
	UserPK_Embededdable id;
	String address;
	Integer age;
}
