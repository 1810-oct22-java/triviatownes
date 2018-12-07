package com.ex.beans.game;

import java.util.ArrayList;

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
	 * This is a serializable list of currentPlayers
	 * 
	 * */
	ArrayList<StringBuffer> currentPlayers;
	
	
	

}