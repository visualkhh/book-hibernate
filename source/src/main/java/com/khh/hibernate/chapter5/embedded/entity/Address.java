package com.khh.hibernate.chapter5.embedded.entity;

import lombok.Data;

import javax.persistence.Embeddable;


@Data
@Embeddable
public class Address {
	String mail;
	String zip;
	String country;
	String addr;
}
