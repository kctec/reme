package com.espn.playbook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="RSRC_ROLE_XREF")
public class ResourceRole {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "RSRC_ROLE_XREF_ID", unique = true, nullable = false)
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name="RSRC_ID")
	private Resource resource;
	
	@Column(name = "PRIMARY_IND")
	Long primaryIndicator;
 
}
