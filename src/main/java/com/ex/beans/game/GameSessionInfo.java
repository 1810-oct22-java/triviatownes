package com.ex.beans.game;

public class GameSessionInfo {
	
	private StringBuffer category;
	private int players;
	private int maxPlayers;
	private StringBuffer name;
	private StringBuffer scope;
	private StringBuffer difficulty;
	
	public synchronized StringBuffer getDifficulty() {
		return difficulty;
	}
	public synchronized void setDifficulty(StringBuffer difficulty) {
		this.difficulty = difficulty;
	}
	public synchronized StringBuffer getCategory() {
		return category;
	}
	public synchronized void setCategory(StringBuffer category) {
		this.category = category;
	}
	public synchronized int getPlayers() {
		return players;
	}
	public synchronized void setPlayers(int players) {
		this.players = players;
	}
	public synchronized int getMaxPlayers() {
		return maxPlayers;
	}
	public synchronized void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public synchronized StringBuffer getName() {
		return name;
	}
	public synchronized void setName(StringBuffer name) {
		this.name = name;
	}
	public synchronized StringBuffer getScope() {
		return scope;
	}
	public synchronized void setScope(StringBuffer scope) {
		this.scope = scope;
	}

}