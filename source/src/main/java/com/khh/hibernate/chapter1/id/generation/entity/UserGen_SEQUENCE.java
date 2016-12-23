package com.khh.hibernate.chapter1.id.generation.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name = UserGen_SEQUENCE.SEQUENCE_GEN_NAME, sequenceName = "EMP_SEQ_GEN")
public class UserGen_SEQUENCE {
	public static final String SEQUENCE_GEN_NAME = "empSeqGen";
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = SEQUENCE_GEN_NAME)
	Integer seq;
	String name;
	String address;
	Integer age;
}
