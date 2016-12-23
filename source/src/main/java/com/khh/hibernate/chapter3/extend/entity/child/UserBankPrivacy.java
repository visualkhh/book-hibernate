package com.khh.hibernate.chapter3.extend.entity.child;

import com.khh.hibernate.chapter3.extend.entity.UserConcreteClass;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue(value="BANK")
//public class UserBankPrivacy extends User{
//public class UserBankPrivacy extends UserSubClass {
public class UserBankPrivacy extends UserConcreteClass {
	String password;
}
