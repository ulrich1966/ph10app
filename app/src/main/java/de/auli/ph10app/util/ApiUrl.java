package de.auli.ph10app.util;

public class ApiUrl {
	public static final String BASE = "http://localhost:8080/ph10zettel/api";
	public static final String REMOTE_BASE = "http://h2825659.stratoserver.net/ph10zettel/api";
	public static final String GROUPS = "%s/playergroup";
	public static final String GROUP_ID = GROUPS+"/%s";
	public static final String PLAYER = "%s/player";
	public static final String PLAYER_ID = PLAYER+"/%s";
	public static final String GROUP_ADD_PLAYER = "%s/playergroup/%s/player/%s";
}
