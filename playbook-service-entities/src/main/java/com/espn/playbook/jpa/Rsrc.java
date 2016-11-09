package com.espn.playbook.jpa;

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
public class Rsrc {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "RSRC_ID", unique = true, nullable = false)
	private String id;

	@Column(name = "DISPLAY_NM")
	private String displayNm;

	@OneToOne
	@JoinColumn(
			name     = "RSRC_TYPE_ID",
			nullable = false
			)
	private RsrcType     rsrcType;

	@OneToOne
	@JoinColumn(
			name     = "PRSN_ID",
			nullable = false
			)
	private Prsn     prsn;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDisplayNm() {
		return displayNm;
	}

	public void setDisplayNm(String displayName) {
		this.displayNm = displayName;
	}

	public RsrcType getRsrcType() {
		return rsrcType;
	}

	public void setRsrcType(RsrcType rsrcType) {
		this.rsrcType = rsrcType;
	}

	public Rsrc() {
		super();
	}
}
