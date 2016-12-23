package com.khh.hibernate.chapter3.extend.entity;

import lombok.Data;
import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.*;

@Data
@Entity
//@Table(name = "USER")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="CLASS_TYPE", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorFormula("...")
@DiscriminatorValue(value="USER")
@SequenceGenerator(name = User.SEQ_NAME, sequenceName = User.SEQ_NAME, initialValue = 50, allocationSize = 1)
public class User {
	public static final String SEQ_NAME = "SEQ_USER";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
	Integer seq;
	String name;
}
