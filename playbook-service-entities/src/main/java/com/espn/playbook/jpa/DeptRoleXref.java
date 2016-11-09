package com.espn.playbook.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "DEPT_ROLE_XREF")
public class DeptRoleXref {

	public String getId() {
		return id;
	}

	public DeptRoleXref() {
		super();
	}

	public void setId(String id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Dept getDept() {
		return department;
	}

	public void setDept(Dept department) {
		this.department = department;
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "DEPT_ROLE_XREF_ID", unique = true, nullable = false)
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Dept department;
	
	
}
