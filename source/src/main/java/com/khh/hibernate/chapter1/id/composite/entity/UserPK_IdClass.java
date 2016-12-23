package com.khh.hibernate.chapter1.id.composite.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPK_IdClass implements Serializable{
	String name;
	Integer number;
}
