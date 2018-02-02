package com.khh.hibernate.chapter2.join.onetomany.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Map;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter
@SequenceGenerator(name = Emp.SEQUENCE_NAME, sequenceName = Emp.SEQUENCE_NAME, initialValue = 100, allocationSize = 1)
//@IdClass(EmpId.class)
public class Emp {
	public static final String SEQUENCE_NAME = "EMP_SEQ";
	@Builder
	public Emp(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_SEQ")
	Integer Empseq;
	@Column(name = "COMPANY_SEQ")
	Integer companySeq;
	@Column(name = "NAME")
	String name;
	@Column(name = "AGE")
	Integer age;

//	@ManyToOne
//	@JoinColumn(name = "COMPANY_SEQ", referencedColumnName = "COMPANY_SEQ", nullable = false, insertable=false, updatable=false)
//	Company company;
}
