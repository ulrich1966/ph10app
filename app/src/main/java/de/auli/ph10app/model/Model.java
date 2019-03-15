package de.auli.ph10app.model;

import java.io.Serializable;

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