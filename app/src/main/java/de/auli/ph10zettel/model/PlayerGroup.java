package de.auli.ph10zettel.model;

import java.util.ArrayList;
import java.util.List;
public class PlayerGroup extends Model {
	private static final long serialVersionUID = 1L;
	private String name;
	private List<Player> players;
	private List<PlaySession> sessions;

	public PlayerGroup() {
		super();
	}

	public PlayerGroup(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<PlaySession> getSessions() {
		return sessions;
	}

	public void setSessions(List<PlaySession> sessions) {
		this.sessions = sessions;
	}

	public void addPlayer(Player player) {
		if (this.players == null) {
			this.players = new ArrayList<Player>();
		}
		if(!this.players.contains(player)) {
			this.players.add(player);
			player.addPlayerGroup(this);			
		}
	}
	
	public void removePlayer(Player player) {
		if (this.players != null && this.players.contains(player)) {
			this.players.remove(player);
			//player.removePlayerGroup(this);
		}
	}

	public void addSession(PlaySession session) {
		if (this.sessions == null) {
			this.sessions = new ArrayList<PlaySession>();
		}
		this.sessions.add(session);
		session.setPlayerGroup(this);
	}

	public void removeSession(PlaySession session) {
		if (this.sessions != null && this.sessions.contains(session)) {
			this.sessions.remove(session);
			//session.setPlayerGroup(null);
		}
	}

	@Override
	public String toString() {
		return "PlayerGroup [name=" + name + ", players=" + "" + ", sessions=" + "" + ", Id=" + getId() + "]";
	}
	
}
