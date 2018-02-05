package com.khh.hibernate.chapter2.join.onetoone.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data @NoArgsConstructor
@Entity
@SequenceGenerator(name = User.SEQ_NAME, sequenceName = User.SEQ_NAME, initialValue = 100, allocationSize = 1)
public class User {
	public static final String SEQ_NAME = "SEQ_USER";

	@Builder
	public User(Integer seq, String name, String password, UserInfo info) {
		this.seq = seq;
		this.name = name;
		this.password = password;
		this.info = info;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = SEQ_NAME)
	@Column(name = "USER_SEQ")
	Integer seq;
	String name;
	String password;
	@OneToOne(cascade = CascadeType.ALL)
//	@MapsId
//	@JoinColumn(name = "USER_SEQ", referencedColumnName="SEQ")
//	@PrimaryKeyJoinColumn(name = "USER_SEQ", referencedColumnName="SEQ")
//	@JoinColumn(name = "GGGG")
	UserInfo info;
}
