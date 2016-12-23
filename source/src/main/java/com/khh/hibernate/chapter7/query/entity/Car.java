package com.khh.hibernate.chapter7.query.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@SequenceGenerator(name = Car.SEQ_NAME, sequenceName = Car.SEQ_NAME, allocationSize = 1)
public class Car {
	public static final String SEQ_NAME = "SEQ_CAR";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
	Integer seq;
	String model;
	public Car() {}
	public Car(String model) {this.model=model;}
}
