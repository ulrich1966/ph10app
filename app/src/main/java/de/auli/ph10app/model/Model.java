package de.auli.ph10app.model;

import java.io.Serializable;
import java.sql.Timestamp;

public abstract class Model implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long version;
	private Timestamp createDate;
	private Timestamp updateDate;


	protected Model() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
}