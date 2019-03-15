package de.auli.ph10zettel.model;

import java.util.ArrayList;
import java.util.List;
public class Player extends Model {
	private static final long serialVersionUID = 1L;
	private String name;
	private String comment;
	private String pic;
	private List<PlayerGroup> playerGroups;
	
	public Player() {
		super();
	}
	
	public Player(String name, String comment, String pic) {
		this();
		this.name = name;
		this.comment = comment;
		this.pic = pic;
	}

	public Player(String name, String comment, String pic, PlayerGroup playerGroup) {
		this(name, comment, pic);
		this.addPlayerGroup(playerGroup);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public List<PlayerGroup> getPlayerGroups() {
		return playerGroups;
	}

	public void setPlayerGroups(List<PlayerGroup> playerGroups) {
		this.playerGroups = playerGroups;
	}
	
	public void addPlayerGroup(PlayerGroup playerGroup) {
		if(this.playerGroups == null) {
			this.playerGroups = new ArrayList<PlayerGroup>();
		}
		if(!this.playerGroups.contains(playerGroup)) {
			this.playerGroups.add(playerGroup);
			playerGroup.addPlayer(this);			
		}
	}
	
	public void removePlayerGroup(PlayerGroup playerGroup) {
		if(this.playerGroups != null && this.playerGroups.contains(playerGroup)) {
			this.playerGroups.remove(playerGroup);
			playerGroup.removePlayer(this);
		}		
	}

	public String toString() {
		return "Player [Id=" + getId() + "name=" + name + ", comment=" + comment + ", pic=" + pic + "]";
	}
}
