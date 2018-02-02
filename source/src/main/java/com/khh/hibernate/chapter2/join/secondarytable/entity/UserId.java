package com.khh.hibernate.chapter2.join.secondarytable.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class UserId implements Serializable {
	@Column(name = "USER_SEQ")
	Integer seq;

	@Column(name = "USER_INFO_SEQ")
	Integer userInfoSeq;
}
