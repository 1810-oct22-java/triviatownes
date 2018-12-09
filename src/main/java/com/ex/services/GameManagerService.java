package com.ex.services;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ex.beans.game.GameSessionBean;
import com.ex.beans.game.GameSessionInfo;
import com.ex.beans.game.PlayerBean;
import com.ex.servlets.NewUserServlet;

public class GameManagerService {
	
	private static GameManagerService instance; 
	
	public String test;
	
	public ArrayList<GameSessionBean> gameList;
	
	public Boolean populated = false;
	
	private static Logger logger = Logger.getLogger(GameManagerService.class);
	
	//Overrides the default public constructor
	private GameManagerService() {}
	
	//Lazy get singleton instance method
	public static GameManagerService getInstance() { 
		
		//If instance is null make one (Lazy implementation)
		if (instance == null) { 
			
			//remove overhead by using synchronized block
			synchronized (GameManagerService.class){
			
				//Check if instance is null again in synchronized block
				if(instance == null) {
					instance = new GameManagerService();
					instance.gameList = new ArrayList<GameSessionBean>();
				}
			} 
		}
		return instance; 
	}
	
	synchronized public int createGame() {
		
		for(int i = 0; i < gameList.size(); i++) {
			if(gameList.get(i) == null) {
				gameList.add(i, new GameSessionBean());
				return i;
			}
		}
		gameList.add(new GameSessionBean());
		return gameList.size() - 1;
		
	}
	
	synchronized public GameSessionBean getGame(int gameIndex) {
		return gameList.get(gameIndex);
	}
	
	synchronized public void makeDummyList() {
		
		int count = 0;
		
		for(int i = 0; i < 5; i ++) {
			int tempId = createGame();
			getGame(tempId).setCategory(new StringBuffer("art"));
			
			ArrayList<PlayerBean> players = new ArrayList<PlayerBean>();
			
			for(int y = 0; y < i; y++)
				players.add(new PlayerBean());
			
			getGame(tempId).setCurrentPlayers(players);
			
			getGame(tempId).setMaxPlayers(i + 4);
			
			getGame(tempId).setScope(new StringBuffer("public"));
			
			getGame(tempId).setName(new StringBuffer("test"));
			
			getGame(tempId).setDifficulty(new StringBuffer("hard"));
			
			getGame(tempId).setInstanceId(tempId);
			
			getGame(tempId).setJoinKey(count + "");
			count  = count + 1;
		}
		
		for(int i = 0; i < 5; i ++) {
			int tempId = createGame();
			getGame(tempId).setCategory(new StringBuffer("sports"));
			
			ArrayList<PlayerBean> players = new ArrayList<PlayerBean>();
			
			for(int y = 0; y < i; y++)
				players.add(new PlayerBean());
			
			getGame(tempId).setCurrentPlayers(players);
			
			getGame(tempId).setMaxPlayers(i + 4);
			
			getGame(tempId).setScope(new StringBuffer("private"));
			
			getGame(tempId).setName(new StringBuffer("another name"));
			
			getGame(tempId).setDifficulty(new StringBuffer("easy"));
			
			getGame(tempId).setInstanceId(tempId);
			
			getGame(tempId).setJoinKey(count + "");
			count  = count + 1;
		}
		
		logger.trace("List is filled with " + gameList.size() + " games");
		
		this.populated = true;
		
	}
	
	synchronized public Boolean isFilled() {
		return this.populated;
	}
	
	synchronized public ArrayList<GameSessionInfo> getGameSessionsInfo(String category) {
		
		ArrayList<GameSessionInfo> serverList = new ArrayList<GameSessionInfo>();
		
		for(int i = 0; i < gameList.size(); i++) {
			
			if(gameList.get(i) == null) continue;
			
			if(category.equals("") || category.equals(gameList.get(i).getCategory().toString().toLowerCase())) {
			
				GameSessionInfo temp = new GameSessionInfo();
				
				temp.setCategory(gameList.get(i).getCategory());
				temp.setName(gameList.get(i).getName());
				temp.setDifficulty(gameList.get(i).getDifficulty());
				temp.setPlayers(gameList.get(i).getCurrentPlayers().size());
				temp.setMaxPlayers(gameList.get(i).getMaxPlayers());
				temp.setScope(gameList.get(i).getScope());
				
				serverList.add(temp);
			}
		}
		
		return serverList;
	}
	
	synchronized public GameSessionBean getGameByKey(StringBuffer key) {
		
		for(int i = 0; i < this.gameList.size(); i++) {
			if(gameList.get(i).getJoinKey().equals(key)) {
				return gameList.get(i);
			}
		}
		
		return null;
	}
}
