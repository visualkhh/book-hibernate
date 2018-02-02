package com.khh.hibernate.chapter2.join.secondarytable.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;


@Data
@Entity
@SequenceGenerator(name = UserInfo.SEQ_NAME, sequenceName = UserInfo.SEQ_NAME, initialValue = 200, allocationSize = 1)
@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
public class UserInfo {
	public static final String SEQ_NAME = "SEQ_USERINFO";
	@Id
	@Column(name = "USER_INFO_SEQ")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
	@GeneratedValue(generator = "generator")
	Integer user_info_seq;
	String addr;
	double weight;
	double height;

}
