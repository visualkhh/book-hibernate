package com.khh.hibernate.chapter1.id.generation.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@TableGenerator(name = UserGen_TABLE.TABLE_GEN_NAME, table = "USER_ID_TABLE")
public class UserGen_TABLE {
	public static final String TABLE_GEN_NAME = "empTableGen";
	@Id
	@GeneratedValue (strategy = GenerationType.TABLE, generator = TABLE_GEN_NAME)
	Integer seq;
	String name;
	String address;
	Integer age;
}
