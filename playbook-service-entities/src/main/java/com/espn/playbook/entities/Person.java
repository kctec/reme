package com.espn.playbook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PRSN")
public class Person {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "PRSN_ID", unique = true, nullable = false)
	private String id;

	@Column(name = "FIRST_NM")
	private String displayName;
	
	@Column(name = "FIRST_NM")
	private String lastName;
	
	@OneToOne
	@JoinColumn(
			name     = "PRSN_ID",
			nullable = false
			)
	private Resource resource;
	
 
	
}
