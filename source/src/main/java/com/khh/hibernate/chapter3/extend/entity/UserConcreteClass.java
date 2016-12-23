package com.khh.hibernate.chapter3.extend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@DiscriminatorValue(value="USER")
@SequenceGenerator(name = UserConcreteClass.SEQ_NAME, sequenceName = UserConcreteClass.SEQ_NAME, initialValue = 50, allocationSize = 1)
public class UserConcreteClass {
	public static final String SEQ_NAME = "SEQ_USER";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
	@Column(name = "USER_SEQ")
	Integer seq;
	String name;
}
