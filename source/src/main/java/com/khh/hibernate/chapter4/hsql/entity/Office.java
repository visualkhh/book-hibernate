package com.khh.hibernate.chapter4.hsql.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Office {
	@Id
	@Column(name = "OFFICE_SEQ")
	Integer seq;
	String addr;
	public Office() {
	}
	public Office(Integer seq, String addr){
		this.seq = seq;
		this.addr = addr;
	}
}
