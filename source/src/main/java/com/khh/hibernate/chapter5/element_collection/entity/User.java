package com.khh.hibernate.chapter5.element_collection.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Data
@Entity
@SequenceGenerator(name = User.SEQ_NAME, sequenceName = User.SEQ_NAME, allocationSize = 1)
public class User {
	public static final String SEQ_NAME = "SEQ_USER";

	public enum CAR_TYPE{
		ENUM_MODEL_1,
		ENUM_MODEL_2,
		ENUM_MODEL_3,
		ENUM_MODEL_4
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_SEQ")
	Integer seq;
	String name;

	@ElementCollection
//	@ElementCollection(targetClass=Car.class,fetch= FetchType.LAZY)
	@CollectionTable(name="CAR_SET",joinColumns=@JoinColumn(name="CAR_SET_SEQ"))
//	@CollectionTable(name="ADDRESS")
	Set<Car> cars_set;

	@ElementCollection
	@CollectionTable(name="CAR_ENUM",joinColumns=@JoinColumn(name="CAR_ENUM_SEQ"))
	@Enumerated(EnumType.STRING)
	List<CAR_TYPE> cars_enum;
}
