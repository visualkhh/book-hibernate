package com.khh.hibernate.chapter1.id.composite.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class UserPK_Embededdable implements Serializable{
	String name;
	Integer number;
}
