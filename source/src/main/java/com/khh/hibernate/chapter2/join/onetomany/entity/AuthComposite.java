package com.khh.hibernate.chapter2.join.onetomany.entity;

import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
//@IdClass(AuthCompositePKID.class)
@SequenceGenerator(name = AuthComposite.SEQUENCE_NAME, sequenceName = AuthComposite.SEQUENCE_NAME, initialValue = 50)
@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
public class AuthComposite implements Serializable{
	public static final String SEQUENCE_NAME = "AUTHCOMPOSITE_SEQ";
//http://stackoverflow.com/questions/2611619/onetomany-and-composite-primary-keys
	//http://www.thejavageek.com/2014/09/23/jpa-joincolumns-annotation-example/
	//http://uaihebert.com/jpa-onetomany-and-manytoone-unidirectional-and-bidirectional/
	//http://kruders.com/hibernate/foreign-key-constraint-to-a-composite-primary-key-in-hibernate/


//	@EmbeddedId
//	@GeneratedValue(generator = "gen")
//	@GenericGenerator(name="gen", strategy = "foreign", parameters = @org.hibernate.annotations.Parameter(name="property", value = "USER_SEQ"))
//	@TableGenerator(name = "phone_gen", table = "USER", pkColumnName = "USER_SEQ", valueColumnName = "USER_SEQ")
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "phone_gen")
//	@TableGenerator(name = "phone_gen", table = "USER_SS", pkColumnName = "USER_SEQ", valueColumnName = "VAL")
//	@GeneratedValue(strategy = GenerationType.TABLE, generator = "phone_gen")

//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private AuthCompositePK pk;

	@Id
	@Column(name = "USER_SEQ",nullable = false)
	@GeneratedValue(generator = "generator")
//	@GeneratedValue(generator = "generator")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GenericGenerator(
//			name = "Parent",
//			strategy = "foreign",
//			parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "parent") }
//	)
//	@GeneratedValue(generator = "Parent")
	Integer seq;
	@Id
	@Column(nullable = false)
	String auth;

	Date expiry;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="USER_SEQ", nullable=false,updatable=false,insertable=false)
	User user;
}
