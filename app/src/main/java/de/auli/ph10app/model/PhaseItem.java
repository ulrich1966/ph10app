package de.auli.ph10app.model;

public class PhaseItem extends Model {
	private static final long serialVersionUID = 1L;
	private Integer number;
	private String name;
	private GameModus gameModus;
	
	public PhaseItem() {
		super();
	}

	public PhaseItem(Integer number, String name) {
		super();
		this.number = number;
		this.name = name;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GameModus getGameModus() {
		return gameModus;
	}

	public void setGameModus(GameModus gameModus) {
		this.gameModus = gameModus;
	}

	public String toString() {
		return "PhaseItem [Id=" + getId() + "number=" + number + ", name=" + name + ", gameModus=" + "" + "]";
	}
}
