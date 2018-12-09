package com.ex.beans.game;

public class LeaderboardBean {
	private String name;
	private int score;
	
	public LeaderboardBean(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "LeaderboardBean [name=" + name + ", score=" + score + "]";
	}
	
	
}
