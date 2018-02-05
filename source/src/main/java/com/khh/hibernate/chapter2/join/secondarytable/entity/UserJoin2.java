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
	Integer user_info_seq;
	String addr;
	double weight;
	double height;

	@Column(table = "USER")
	String password;
}
