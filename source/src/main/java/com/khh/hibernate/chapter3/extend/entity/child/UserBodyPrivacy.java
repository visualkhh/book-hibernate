package com.khh.hibernate.chapter3.extend.entity.child;

import com.khh.hibernate.chapter3.extend.entity.UserConcreteClass;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue(value="BODY")
//public class UserBodyPrivacy extends User{
//public class UserBodyPrivacy extends UserSubClass {
public class UserBodyPrivacy extends UserConcreteClass {
	Integer age;
	double weight;
	double height;
}
