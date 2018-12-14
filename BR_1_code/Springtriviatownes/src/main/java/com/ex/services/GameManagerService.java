package com.ex.services;

import java.util.ArrayList;

import com.ex.beans.game.GameSessionBean;

public class GameManagerService {
	
	private static GameManagerService instance; 
	
	public String test;
	
	public ArrayList<GameSessionBean> gameList;
	
	public static void main(String[] args) {
		
		GameManagerService gm = GameManagerService.getInstance();
		
	}
	
	//Overrides the default public constructor
	private GameManagerService() {}
	
	//Lazy get singleton instance method
	public static GameManagerService getInstance() { 
		
		//If instance is null make one (Lazy implementation)
		if (instance == null) { 
			
			//remove overhead by using synchronized block
			synchronized (GameManagerService.class){
			
				//Check if instance is null again in synchronized block
				if(instance == null) instance = new GameManagerService(); 
			} 
		}
		return instance; 
	} 
}
