package de.auli.ph10app.model;

import java.util.ArrayList;
import java.util.List;

public class GameModus extends Model {
	private static final long serialVersionUID = 1L;
	private String name;
	private List<PhaseItem> phaseItems;
	
	public GameModus() {
		super();
	}

	public GameModus(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PhaseItem> getPhaseItems() {
		return phaseItems;
	}

	public void setPhaseItems(List<PhaseItem> phaseItems) {
		this.phaseItems = phaseItems;
	}

	public void addPhaseItem(PhaseItem phaseItem) {
		if (this.phaseItems == null) {
			this.phaseItems = new ArrayList<>();
		}
		this.phaseItems.add(phaseItem);
		phaseItem.setGameModus(this);			
	}

	public String toString() {
		return "GameModi [name=" + name + ", items=" + "" + "]";
	}
}
