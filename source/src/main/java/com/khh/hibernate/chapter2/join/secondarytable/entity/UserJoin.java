//package com.khh.hibernate.chapter2.join.secondarytable.entity;
//
//import lombok.Data;
//
//import javax.persistence.*;
//
//@Data
//@Entity
//@Table(name = "USER")// @IdClass(UserId.class)
//@SequenceGenerator(name = User.SEQ_NAME, sequenceName = User.SEQ_NAME, initialValue = 100, allocationSize = 1)
//@SecondaryTable(name = "USERINFO",pkJoinColumns = @PrimaryKeyJoinColumn(name = "USER_SEQ", referencedColumnName = "USER_SEQ"))
//public class UserJoin {
//	public static final String SEQ_NAME = "SEQ_USER";
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQ_NAME)
//	@Column(name = "USER_SEQ")
//	Integer userSeq;
//	String name;
//	String password;
//
//	@Id
//	@Column(name = "USER_INFO_SEQ")
//	Integer userInfoSeq;
//
//	@Column(table = "USERINFO",name = "USER_SEQ", insertable=false, updatable=false)
////	@MapsId
////	@Column(table = "USERINFO",name = "USER_INFO_SEQ")
//	String addr;
//
//
//}
