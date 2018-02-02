package com.khh.hibernate.chapter2.join.onetomany.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

public class EmpId implements Serializable {
	Integer Empseq;
	Integer companySeq;
}
