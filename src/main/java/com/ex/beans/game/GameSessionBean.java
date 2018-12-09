package com.ex.beans.game;

import java.util.ArrayList;

import com.ex.interfaces.game.QuestionInterface;

public class GameSessionBean {
	
   /*
	* Is used to get the instance from the instance manager
	* Will never change after initialization 
	* so it does not need to be thread safe
	* */
	int instanceId;
	
	/*
	 * Is used to easily get the current instance state
	 * 0 = waiting, 1 = playing, 2 = game-end, 3 = finished
	 * StringBuffer is used because it must be thread safe
	 * */
	StringBuffer state;
	
	/*
	 * This is used to track the global message system
	 * Must be thread safe
	 * */
	StringBuffer globalChatBuffer;
	
	
	/*
	 * This is used to track the category
	 * Must be thread safe
	 * */
	StringBuffer category;
	
	StringBuffer difficulty;
	
	StringBuffer name;
	
	StringBuffer scope;
	
	public synchronized int getInstanceId() {
		return instanceId;
	}


	public synchronized void setInstanceId(int instanceId) {
		this.instanceId = instanceId;
	}


	public synchronized StringBuffer getState() {
		return state;
	}


	public synchronized void setState(StringBuffer state) {
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


	public synchronized ArrayList<QuestionInterface> getQuestions() {
		return Questions;
	}


	public synchronized void setQuestions(ArrayList<QuestionInterface> questions) {
		Questions = questions;
	}


	/*
	 * This is a serializable list of currentPlayers
	 * 
	 * */
	ArrayList<PlayerBean> currentPlayers;
	
	int maxPlayers;
	
	
	/*
	 * This is a serializable 
	 * 
	 * */
	ArrayList<QuestionInterface> Questions;
	
}