package com.khh.hibernate.chapter2.join.secondarytable.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;


@Data @NoArgsConstructor
@Entity
//@SequenceGenerator(name = UserInfo.SEQ_NAME, sequenceName = UserInfo.SEQ_NAME, initialValue = 200, allocationSize = 1)
//@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
public class UserInfo {
	public static final String SEQ_NAME = "SEQ_USERINFO";

	@Builder
	public UserInfo(Integer userSeq, String addr, double weight, double height) {
		this.userSeq = userSeq;
		this.addr = addr;
		this.weight = weight;
		this.height = height;
	}

	@Id
	@Column(name = "USER_SEQ")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
//	@GeneratedValue(generator = "generator")
	Integer userSeq;
	String addr;
	double weight;
	double height;

}
