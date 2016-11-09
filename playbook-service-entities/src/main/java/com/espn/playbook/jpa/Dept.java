package com.espn.playbook.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "DEPT")
public class Dept {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "DEPT_ID", unique = true, nullable = false)
	private String id;
	
	public Dept() {
		super();
	}

	public Dept(String id, String deptNm) {
		super();
		this.id = id;
		this.deptNm = deptNm;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return deptNm;
	}

	public void setDepartmentName(String departmentName) {
		this.deptNm = departmentName;
	}

	@Column(name = "DEPT_NM" )
	private String deptNm;
}
