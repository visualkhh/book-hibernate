package com.khh.hibernate.chapter3.extend.entity.child;

import com.khh.hibernate.chapter3.extend.entity.UserConcreteClass;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue(value="OFFICE")
//public class UserOfficePrivacy extends User{
//public class UserOfficePrivacy extends UserSubClass {
public class UserOfficePrivacy extends UserConcreteClass {
	String address;
}
