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
@Table(name="PRSN_TYPE")
public class PrsnType {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "PRSN_TYPE_ID", unique = true, nullable = false)
	private String id;
	
	@Column(name = "PRSN_TYPE_NM")
	private String employeeTypeNm;
	
	@OneToOne
	@JoinColumn(
			name     = "EMPLOYEE_  TYPE_ID",
			nullable = false
			)
	private EmployeeType employeeType;
	
	
}
