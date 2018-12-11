package com.ex.beans.game;

public class PlayerBean {
	
	//Thread safe username
	private StringBuffer username;
	
	//0 = a, 1 = b, 2 = c, 3 = d
	private int currentAnswer;
	
	//the order in which the usere answered the question
	private int currentAnswerPosition;
	
	private int score;
	
	private int maxStreak;
	
	private int rightAnswers;
	
	private int wrongAnswers;

	public synchronized StringBuffer getUsername() {
		return username;
	}

	public synchronized void setUsername(StringBuffer username) {
		this.username = username;
	}

	public synchronized int getCurrentAnswer() {
		return currentAnswer;
	}

	public synchronized void setCurrentAnswer(int currentAnswer) {
		this.currentAnswer = currentAnswer;
	}

	public synchronized int getCurrentAnswerPosition() {
		return currentAnswerPosition;
	}

	public synchronized void setCurrentAnswerPosition(int currentAnswerPosition) {
		this.currentAnswerPosition = currentAnswerPosition;
	}

	public synchronized int getScore() {
		return score;
	}

	public synchronized void setScore(int score) {
		this.score = score;
	}

	public synchronized int getMaxStreak() {
		return maxStreak;
	}

	public synchronized void setMaxStreak(int maxStreak) {
		this.maxStreak = maxStreak;
	}

	public synchronized int getRightAnswers() {
		return rightAnswers;
	}

	public synchronized void setRightAnswers(int rightAnswers) {
		this.rightAnswers = rightAnswers;
	}

	public synchronized int getWrongAnswers() {
		return wrongAnswers;
	}

	public synchronized void setWrongAnswers(int wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}
}
