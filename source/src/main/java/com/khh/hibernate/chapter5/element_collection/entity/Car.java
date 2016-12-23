package com.khh.hibernate.chapter5.element_collection.entity;

import lombok.Data;

import javax.persistence.Embeddable;


@Data
@Embeddable
public class Car {
	String model;
	public Car(){}
	public Car(String model){this.model=model;}
}
