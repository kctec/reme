package com.espn.playbook.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="EMPLOYEE_TYPE")
public class EmployeeType {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "EMPLOYEE_TYPE_ID", unique = true, nullable = false)
	private String id;
	
	@Column(name = "EMPLOYEE_TYPE_NM")
	private String employeeTypeNm;
}
