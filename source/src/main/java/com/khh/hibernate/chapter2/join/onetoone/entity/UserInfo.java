package com.khh.hibernate.chapter2.join.onetoone.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;


@Data
@Entity @NoArgsConstructor
@SequenceGenerator(name = UserInfo.SEQ_NAME, sequenceName = UserInfo.SEQ_NAME, initialValue = 200, allocationSize = 1)
@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
public class UserInfo {
	public static final String SEQ_NAME = "SEQ_USERINFO";

	@Builder
	public UserInfo(Integer seq, String addr, double weight, double height, User user) {
		this.seq = seq;
		this.addr = addr;
		this.weight = weight;
		this.height = height;
		this.user = user;
	}

	@Id
	@Column(name = "SEQ")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
	@GeneratedValue(generator = "generator")
	Integer seq;
	String addr;
	double weight;
	double height;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "info")
	User user;

}
