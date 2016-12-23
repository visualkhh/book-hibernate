package com.khh.hibernate.chapter1.id.composite.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Data
public class UserPK_EmbeddedId implements Serializable{
	String name;
	Integer number;
}
