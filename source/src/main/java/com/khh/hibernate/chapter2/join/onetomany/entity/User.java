package com.khh.hibernate.chapter2.join.onetomany.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Entity
@SequenceGenerator(name = User.SEQUENCE_NAME, sequenceName = User.SEQUENCE_NAME, initialValue = 100, allocationSize = 1)
public class User {
	public static final String SEQUENCE_NAME = "USER_SEQ";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_SEQ")
	Integer seq;
	String name;
	String password;

//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = CoffeShop.class)
//	@OneToMany(cascade = CascadeType.MERGE)
//	@OneToMany(cascade = CascadeType.DETACH)
//	@OneToMany(cascade = CascadeType.PERSIST)
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@OneToMany(cascade = CascadeType.ALL)
//	@JoinTable(e)
//	@JoinColumn
//	@JoinColumn(name = "AUTH_SEQ")
//	@JoinColumn(name = "USER_SEQ")
//	@JoinColumn(name = "USER_SEQ", referencedColumnName = "SEQ")
//	@JoinColumn(name = "USER_SEQ", referencedColumnName = "USER_SEQ", updatable=false, insertable=false, nullable = false)
//	@PrimaryKeyJoinColumn(name = "USER_SEQ" , referencedColumnName = "USER_SEQ")
//	@PrimaryKeyJoinColumn
	@JoinColumn(name = "USER_SEQ", referencedColumnName = "USER_SEQ")
//	@PrimaryKeyJoinColumn(name = "USER_SEQ", referencedColumnName = "USER_SEQ")
//	@JoinColumn(name = "USER_SEQ", referencedColumnName = "USER_SEQ", nullable = false)
//	@JoinColumn(name = "USER_SEQ", referencedColumnName = "USER_SEQ", insertable = false)
//	@JoinColumn( nullable = false)
//	@JoinColumn(nullable = false)
	//@OrderColumn(name = "seq")
//	@PrimaryKeyJoinColumn
//	@JoinColumn(name = "USER_SEQ", referencedColumnName = "USER_SEQ")
//	@Cascade(CascadeType.ALL)
//	List<CoffeShop> auths = null;
//	@JoinTable(name="USER_AUTH", joinColumns={@JoinColumn(name ="USER_SEQ", referencedColumnName ="USER_SEQ")},
//			   inverseJoinColumns={@JoinColumn(name ="USER_SEQ", referencedColumnName ="USER_SEQ")})
//	@JoinColumn(name = "pk.USER_SEQ", referencedColumnName = "USER_SEQ")
//	@JoinTable(
//			name="AUTHCOMPOSITE",
//			joinColumns = {@JoinColumn( name="USER_SEQ",referencedColumnName = "USER_SEQ") },
//			inverseJoinColumns = @JoinColumn( name="USER_SEQ")
//	)
//	@Fetch(value = FetchMode.SUBSELECT)
//	@OrderColumn(name = "ORDER_AUTH")
//	@OrderColumn(name = "ORDER_AUTH")
//	@OrderColumn
//	private List<AuthComposite> auths;
//	private AuthComposite[] auths;
//	private Set<AuthComposite> auths;
	//@MapKey(name = "MAP_KEY")
	private Map<String,AuthComposite> auths;
}
