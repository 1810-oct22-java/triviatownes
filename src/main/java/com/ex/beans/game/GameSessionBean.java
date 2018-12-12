package com.ex.beans.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class GameSessionBean {
	
	QuestionBean currentQuestion;
	
	int currentAnswers;
	
	int currentQuestionIndex;

	long startTime;
	
	long currentTime;
	
	int instanceId;
	
	StringBuffer joinKey;
	
	public int numberOfQuestions;

	int state;
	
	StringBuffer globalChatBuffer;
	
	StringBuffer category;
	
	StringBuffer difficulty;
	
	StringBuffer name;
	
	StringBuffer scope;
	
	public int count = 0;

	public ArrayList<PlayerBean> currentPlayers;
	
	int maxPlayers;
	
	int currentAnswerCounter;
	
	ArrayList<QuestionBean> Questions;
	
	
	
	public synchronized void startGame() {
		
		this.resetTimer();
		
		//Set the currentQuestion
		this.currentQuestion = this.Questions.get(this.currentQuestionIndex);
		
		//Cut off more players from joining
		this.maxPlayers = this.currentPlayers.size();
	}
	
	public synchronized void updateGame() {
		
		//If the timer ran out, reset the 
		if(this.currentTime == 0 || this.currentPlayers.size() == this.currentAnswerCounter) {
			
			//If game is over
			if(this.Questions.size() == this.currentQuestionIndex + 1) {
				
				//End game state
				this.state = 2;
				return;
			}
			
			//Set the timer back to 20 seconds;
			this.resetTimer();
			
			this.loadNewQuestion();
			
		}
				
	}

	public synchronized void loadNewQuestion() {
		
		//Load question
		this.currentQuestionIndex += 1;
		this.currentQuestion = this.Questions.get(this.currentQuestionIndex);
		
		this.currentAnswerCounter = 1;
	}
	
	public synchronized void resetTimer() {
		//Set the current timer;
		this.startTime = System.nanoTime();
		long now = System.nanoTime();
		this.currentTime = 20 - ((now - this.startTime)/1000);
	}
	
	public synchronized QuestionBean getCurrentQuestion() {
		return currentQuestion;
	}

	public synchronized void setCurrentQuestion(QuestionBean currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public synchronized int getCurrentAnswers() {
		return currentAnswers;
	}

	public synchronized void setCurrentAnswers(int currentAnswers) {
		this.currentAnswers = currentAnswers;
	}

	public synchronized int getCurrentQuestionIndex() {
		return currentQuestionIndex;
	}

	public synchronized void setCurrentQuestionIndex(int currentQuestionIndex) {
		this.currentQuestionIndex = currentQuestionIndex;
	}

	public synchronized long getStartTime() {
		return startTime;
	}

	public synchronized void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public synchronized long getCurrentTime() {
		return currentTime;
	}

	public synchronized void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}

	public synchronized int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public synchronized void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public synchronized int getCount() {
		return count;
	}

	public synchronized void setCount(int count) {
		this.count = count;
	}

	public synchronized int getCurrentAnswerCounter() {
		return currentAnswerCounter;
	}

	public synchronized void setCurrentAnswerCounter(int currentAnswerCounter) {
		this.currentAnswerCounter = currentAnswerCounter;
	}

	public static synchronized Comparator<PlayerBean> getSortByPointsComparator() {
		return sortByPointsComparator;
	}

	public static synchronized void setSortByPointsComparator(Comparator<PlayerBean> sortByPointsComparator) {
		GameSessionBean.sortByPointsComparator = sortByPointsComparator;
	}
	
	public StringBuffer getJoinKey() {
		return joinKey;
	}

	public void setJoinKey(StringBuffer joinKey) {
		this.joinKey = joinKey;
	}
	
	public void getTopThreePlayers(){
		Collections.sort(this.getCurrentPlayers(), sortByPointsComparator);
	}
	
	public static Comparator<PlayerBean> sortByPointsComparator = new Comparator<PlayerBean>() {         
	    @Override         
	    public int compare(PlayerBean player1, PlayerBean player2) {             
	      return (player1.getScore() < player1.getScore() ? -1 :                     
	              (player1.getScore() == player1.getScore() ? 0 : 1));           
	    }     
	 };
	
	
	public synchronized void loadQuestions() {
		
		return;
		
	}
	
	public synchronized PlayerBean getPlayerById(int id) {
		for(int i = 0; i < this.currentPlayers.size(); i++) {
			if(this.currentPlayers.get(i).getPlayerId() == id) {
				return this.currentPlayers.get(i);
			}
		}
		return null;
	}
	
	public synchronized Boolean hasPlayers() {
		if(this.currentPlayers == null) return false;
		return true;
	}
	
	public synchronized void addDumbyData(){
		if(this.hasPlayers()) return;
		this.currentPlayers = new ArrayList<PlayerBean>();
		
		for(int i = 0; i < 5; i ++) {
			PlayerBean temp = new PlayerBean();
			temp.setUsername(new StringBuffer("Test " + i));
			this.currentPlayers.add(temp);
		}
	}
	
	public synchronized void addPlayer(PlayerBean p) {
		this.currentPlayers.add(p);
	}
	
	public synchronized int getInstanceId() {
		return instanceId;
	}


	public synchronized void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}


	public synchronized int getState() {
		return state;
	}


	public synchronized void setState(int state) {
		this.state = state;
	}


	public synchronized StringBuffer getGlobalChatBuffer() {
		return globalChatBuffer;
	}


	public synchronized void setGlobalChatBuffer(StringBuffer globalChatBuffer) {
		this.globalChatBuffer = globalChatBuffer;
	}


	public synchronized StringBuffer getCategory() {
		return category;
	}


	public synchronized void setCategory(StringBuffer category) {
		this.category = category;
	}


	public synchronized StringBuffer getDifficulty() {
		return difficulty;
	}


	public synchronized void setDifficulty(StringBuffer difficulty) {
		this.difficulty = difficulty;
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


	public synchronized ArrayList<PlayerBean> getCurrentPlayers() {
		return currentPlayers;
	}


	public synchronized void setCurrentPlayers(ArrayList<PlayerBean> currentPlayers) {
		this.currentPlayers = currentPlayers;
	}


	public synchronized int getMaxPlayers() {
		return maxPlayers;
	}


	public synchronized void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	
	public int getNextAnswerPosition() {
		currentAnswerCounter = currentAnswerCounter + 1;
		return count;
	}
	
	public void resetNextAnswerPosition() {
		currentAnswerCounter = 0;
	}


	public synchronized ArrayList<QuestionBean> getQuestions() {
		return Questions;
	}


	public synchronized void setQuestions(ArrayList<QuestionBean> questions) {
		Questions = questions;
	}
	
	public synchronized void addDummyPlayer() {
		PlayerBean temp = new PlayerBean();
		temp.setUsername(new StringBuffer("Added" + count));
		count++;
		this.currentPlayers.add(temp);
	}
	
	public GameSessionBean() {
		
		this.currentPlayers = new ArrayList<PlayerBean>();
		
	}
}