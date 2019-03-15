package de.auli.ph10zettel.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PlaySession extends Model {
	private static final long serialVersionUID = 1L;
	private Date date;
	private Player winner;
	private PlayerGroup playerGroup;
	private List<Game> games;
	
	public PlaySession() {
		super();
	}

	public PlaySession(Date date) {
		super();
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public PlayerGroup getPlayerGroup() {
		return playerGroup;
	}

	public void setPlayerGroup(PlayerGroup playerGroup) {
		this.playerGroup = playerGroup;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public void addGame(Game game) {
		if(this.games == null) {
			this.games = new ArrayList<Game>();
		}
		this.games.add(game);
		game.setPlaySession(this);
	}

	@Override
	public String toString() {
		return "Session [date=" + date + ", winner=" + winner + ", playerGroup=" + playerGroup + "]";
	}
}
