package de.auli.ph10zettel.model;

import java.util.ArrayList;
import java.util.List;

public class Game extends Model {
	private static final long serialVersionUID = 1L;
	private Integer currentNumber;
	private Player winner;
	private PlaySession playSession;
	private List<Sheed> sheeds;
	
	public Game() {
		super();
	}

	public Game(Player winner, PlaySession playSession) {
		super();
		this.winner = winner;
		this.playSession = playSession;
	}

	public Integer getCurrentNumber() {
		if(this.currentNumber == null) {
			this.currentNumber = 0;
		}
		return currentNumber;
	}

	public void setCurrentNumber(Integer currentNumber) {
		this.currentNumber = currentNumber;
	}
	
	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public List<Sheed> getSheeds() {
		return sheeds;
	}

	public void setSheeds(List<Sheed> sheeds) {
		this.sheeds = sheeds;
	}
	
	public PlaySession getPlaySession() {
		return playSession;
	}

	public void setPlaySession(PlaySession playSession) {
		this.playSession = playSession;
		setCurrentNumber(getCurrentNumber()+1);
	}

	public void addSheed(Sheed sheed) {
		if (this.sheeds == null) {
			this.sheeds = new ArrayList<Sheed>();
		}
		this.sheeds.add(sheed);
		sheed.setGame(this);			
	}
	public String toString() {
		return "Game [currentNumber=" + currentNumber + ", winner=" + winner + ", playSession=" + playSession + ", sheeds=" + sheeds + "]";
	}
}
