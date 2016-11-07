package com.espn.playbookservice.jpa;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @version 1.0 created on Jan 25, 2006 at 10:03:28 AM
 * @author swarrb@espn.com
 */
@MappedSuperclass
public abstract class AbstractEntity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Version
	@Column(name = "VERSION", nullable = false)
	@XmlTransient
	private Long version;

	/**
	 * default constructor
	 */
	public AbstractEntity() {
		super();
	}

	/**
	 * Accessor method for the version property.
	 * 
	 * @return a long
	 */

	@XmlTransient
	public Long getVersion() {
		return version;
	}

	/**
	 * Mutator method for the version property.
	 * 
	 * @param version
	 *            a long
	 */

	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * 
	 * @return boolean
	 * @param anObject
	 */
	public abstract boolean equals(Object anObject);

	/**
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public abstract int hashCode();

}
