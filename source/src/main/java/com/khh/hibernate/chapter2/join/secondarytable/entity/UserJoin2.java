package com.khh.hibernate.chapter2.join.secondarytable.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USERINFO")// @IdClass(UserId.class)
@SecondaryTable(name = "USER",pkJoinColumns = @PrimaryKeyJoinColumn(name = "USER_INFO_SEQ", referencedColumnName = "USER_SEQ"))
public class UserJoin2 {
	@Id
	@Column(name = "USER_SEQ")
	Integer userSeq;
	String addr;
	double weight;
	double height;

	@Column(table = "USER", insertable = false, updatable = false)
	String password;


	@Column(table = "USER", name = "USER_INFO_SEQ", insertable = false, updatable = false)
	Integer userInfoSeq;
}
