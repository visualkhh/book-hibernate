package com.khh.hibernate.chapter2.join.onetomany.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor @Getter @Setter @NoArgsConstructor
@Entity
@SequenceGenerator(name = Company.SEQUENCE_NAME, sequenceName = Company.SEQUENCE_NAME, initialValue = 100, allocationSize = 1)
public class Company {
	public static final String SEQUENCE_NAME = "COMPANY_SEQ";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "COMPANY_SEQ")
	Integer companySeq;
	@Column(name = "NAME")
	String name;
	@Column(name = "ADDR")
	String addr;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "COMPANY_SEQ", referencedColumnName = "COMPANY_SEQ")
	private Set<Emp> emps;

}
