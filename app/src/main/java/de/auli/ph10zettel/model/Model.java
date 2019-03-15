package de.auli.ph10zettel.model;

import java.io.Serializable;
import java.sql.Timestamp;

public abstract class Model implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;

	protected Model() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}