package com.espn.playbook.entities;



import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ROLE")
public class Role {

	
 
	
	public Role() {
		super();
	}

	public Role(String id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "ROLE_ID", unique = true, nullable = false)
	private String id;
	
	@Column(name = "ROLE_NM" )
	private String roleName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
