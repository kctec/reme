package com.espn.playbook.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="RSRC")
public class Resource {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "RSRC_ID", unique = true, nullable = false)
	private String id;

	@Column(name = "DISPLAY_NM")
	private String displayName;
	
	@OneToOne
	@JoinColumn(
			name     = "RSRC_TYPE_ID",
			nullable = false
			)
	private ResourceType     resourceType;
}
