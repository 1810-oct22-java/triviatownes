package com.ex.beans.game;




public class HighScoreBean {

	private int id;
	private String username;
	private int score;
	private int maxStreak;
	private int rightAnswers;
	private int wrongAnswers;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "HighScoreBean [id=" + id + ", username=" + username + ", score=" + score + "]";
	}
	public HighScoreBean(int id, String username, int score) {
		super();
		this.id = id;
		this.username = username;
		this.score = score;
	}
	
	
	
	
	
}
