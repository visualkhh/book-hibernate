package com.khh.hibernate.chapter2.join.secondarytable.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data @NoArgsConstructor @Entity
public class UserGroup {

	@Builder
	public UserGroup(Integer userSeq, String name, List<UserJoin2> userJoin2) {
		this.userSeq = userSeq;
		this.name = name;
		this.userJoin2 = userJoin2;
	}

	@Id
	@Column(name = "USER_SEQ")
	Integer userSeq;
//	@Id
//	@Column(name = "GROUP_SEQ")
//	Integer groupSeq;

	String name;


	@OneToMany
	@JoinColumn(name = "USER_SEQ", referencedColumnName = "USER_SEQ")
	List<UserJoin2> userJoin2;

}
