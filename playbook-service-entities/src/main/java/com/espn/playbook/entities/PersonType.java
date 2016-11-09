package com.espn.playbook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PRSN_TYPE_XREF")
public class PersonType {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "PRSN_TYPE_XREF_ID", unique = true, nullable = false)
	private String id;
	
	@Column(name = "DISPLAY_NM")
	private String personTypeName;
	
	@Column(name = "DISPLAY_NM")
	private String displayName;
 
}
