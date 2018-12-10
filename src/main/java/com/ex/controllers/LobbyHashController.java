package com.ex.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ex.beans.game.GameSessionBean;
import com.ex.beans.game.GameSessionInfo;
import com.ex.beans.game.PlayerBean;
import com.ex.beans.game.WaitingMessage;
import com.ex.services.GameManagerService;
import com.google.gson.Gson;

@Controller
@CrossOrigin(origins = "*")
public class LobbyHashController {
	
	private static Logger logger = Logger.getLogger(NewUserController.class);
	
	@MessageMapping("{gameId}/get-game-data")
	@SendTo("/send-game-update/{gameId}/get-game-data")
	@CrossOrigin(origins = "*")
	@ResponseBody
	public int connect3(@DestinationVariable String gameId,SimpMessageHeaderAccessor headerAccessor) {
		
		GameManagerService gm = GameManagerService.getInstance();
		
		if(gm.gameList.size() == 0) {
			logger.trace("Adding game key");
			int gameIndex = gm.createGame();
			gm.getGame(gameIndex).setJoinKey(new StringBuffer("abc"));
		} else if(gm.getGameByKey(new StringBuffer("abc")) == null) {
			int gameIndex = gm.createGame();
			gm.getGame(gameIndex).setJoinKey(new StringBuffer("abc"));
		} else {
			logger.trace("we should be good");
		}
		
		GameSessionBean game = gm.getGameByKey(new StringBuffer(gameId));
		
		//logger.trace(headerAccessor.getHeader(headerName));
		
		return 5;
		
	}
	
	@MessageMapping("{category}/get-lobby-data")
	@SendTo("/lobbies-hash/{category}/get-lobby-data")
	@CrossOrigin(origins = "*")
	@ResponseBody
	public int connect(@DestinationVariable String category,SimpMessageHeaderAccessor headerAccessor){
		
		logger.trace(category);
		logger.trace("Hello");
		
		GameManagerService gm = GameManagerService.getInstance();
		
		gm.gameList = new ArrayList<GameSessionBean>();
		gm.makeDummyList();
		
		gm.getGame(0).getCurrentPlayers().add(new PlayerBean());
	
		ArrayList<GameSessionInfo> payload = gm.getGameSessionsInfo(category);
		
		int jsonHash = new Gson().toJson(payload).hashCode();
		
		
		 
		logger.trace(jsonHash);
		
		return jsonHash;
	}
	
	@MessageMapping("{lobbyId}/update-waiting")
	@SendTo("/waiting/{lobbyId}/send-waiting")
	@CrossOrigin(origins = "*")
	@ResponseBody
	public WaitingMessage connect2(@DestinationVariable String lobbyId,SimpMessageHeaderAccessor headerAccessor) {
		
		GameManagerService gm = GameManagerService.getInstance();
		
		if(gm.gameList.size() == 0) {
			logger.trace("Adding game key");
			int gameIndex = gm.createGame();
			gm.getGame(gameIndex).setJoinKey(new StringBuffer("abc"));
		} else if(gm.getGameByKey(new StringBuffer("abc")) == null) {
			int gameIndex = gm.createGame();
			gm.getGame(gameIndex).setJoinKey(new StringBuffer("abc"));
		} else {
			logger.trace("we should be good");
		}
		
		logger.trace("Before Error");
		GameSessionBean game = gm.getGameByKey(new StringBuffer("abc"));
		logger.trace("After Error");
		
		logger.trace(game);
		
		game.addDumbyData();
		logger.trace("Is this it");
		
		game.addDummyPlayer();
		
		ArrayList<PlayerBean> playerList = game.getCurrentPlayers();
		WaitingMessage wm = new WaitingMessage();
		
		int status = game.getState();
		
		wm.setPlayers(playerList);
		wm.setStatus(status);
		
		return wm;
	}
	
}
