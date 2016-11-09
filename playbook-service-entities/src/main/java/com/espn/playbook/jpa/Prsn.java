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
@Table(name="PRSN")
public class Prsn {
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Rsrc getRsrc() {
		return rsrc;
	}

	public void setRsrc(Rsrc rsrc) {
		this.rsrc = rsrc;
	}

	public String getFirstNm() {
		return firstNm;
	}

	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}

	public String getLastNm() {
		return lastNm;
	}

	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "RSRC_ID", unique = true, nullable = false)
	private String id;
	
	@OneToOne
	@JoinColumn(
			name     = "PRSN_ID",
			nullable = false
			)
	private Rsrc     rsrc;
	
	@Column(name = "FIRST_NM")
	private String firstNm;
	
	@Column(name = "LAST_NM")
	private String lastNm;
}
