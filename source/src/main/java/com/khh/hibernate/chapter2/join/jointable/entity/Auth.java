package com.khh.hibernate.chapter2.join.jointable.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
//@IdClass(Auth.ID.class)
//@UniqueConstraint(columnNames={"some_id", "some_version"}))
@SequenceGenerator(name = Auth.SEQUENCE_NAME, sequenceName = Auth.SEQUENCE_NAME, initialValue = 100)
public class Auth implements Serializable {
	public static final String SEQUENCE_NAME = "AUTH_SEQ";


	@NoArgsConstructor  @Data
	public static class ID implements Serializable {
		@Column(name = "AUTH_SEQ") Integer seq;
		@Column(name = "TEMP_SEQ") Integer tempSeq;
		@Builder public ID(Integer seq, Integer tempSeq) {this.seq = seq; this.tempSeq = tempSeq;}
	}

	@Id
	@Column(name = "AUTH_SEQ")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	Integer seq;

	@Id
	@Column(name = "TEMP_SEQ")
	Integer tempSeq;
//	@Id
	String auth;
//	@Temporal(TemporalType.DATE)
	Date expiry;


	@ManyToOne
	@MapsId("tempSeq")
	@OneToOne
	@JoinTable(name = "T_AUTH_USER",
			joinColumns = @JoinColumn(name = "AUTH_SEQ", referencedColumnName = "TEMP_SEQ"),
			inverseJoinColumns = @JoinColumn(name = "USER_SEQ")
	)
	User user;

//	@MapsId("tempSeq")
//	@MapsId
//	@OneToOne
//	@JoinColumn(name = "TEMP_SEQ",  referencedColumnName = "USER_SEQ")
//	User user;
}
