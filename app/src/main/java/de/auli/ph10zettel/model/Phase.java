package de.auli.ph10zettel.model;

public class Phase extends Model {
	private static final long serialVersionUID = 1L;
	private PhaseItem phaseItem;
	private Integer score;
	private Boolean done;
	
	public Phase() {
		super();
	}

	public Phase(PhaseItem phaseItem) {
		this();
		this.phaseItem = phaseItem;
	}
	
	public Phase(PhaseItem phaseItem, Integer score) {
		this(phaseItem);
		this.score = score;
	}

	
	public PhaseItem getPhaseItem() {
		return phaseItem;
	}
	public void setPhaseItem(PhaseItem phaseItem) {
		this.phaseItem = phaseItem;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	public Boolean isDone() {
		return done;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Phase [phaseItem=" + phaseItem + ", score=" + score + "]";
	}
	
	
}
