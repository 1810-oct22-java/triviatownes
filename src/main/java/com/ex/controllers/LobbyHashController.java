package com.ex.controllers;

import static java.lang.String.valueOf;
import static java.time.LocalDateTime.now;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
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
import com.ex.beans.game.UserMessage;
import com.ex.beans.game.WaitingMessage;
import com.ex.services.GameManagerService;
import com.google.gson.Gson;

@Controller
@CrossOrigin(origins = "*")
public class LobbyHashController {
	
	private static Logger logger = Logger.getLogger(LobbyHashController.class);
	
	@MessageMapping("{lobbyId}/recive-chat-game")
	@SendTo("/send-game-update/{lobbyId}/send-chat")
	@CrossOrigin(origins = "*")
	@ResponseBody
	public UserMessage getMessageGame(@Payload UserMessage userResponse) {
		
		userResponse.setTime(new StringBuffer(DateTimeFormatter.ofPattern("hh:mm a").format(LocalTime.now())));
		return userResponse;
	}
	
	@MessageMapping("{lobbyId}/recive-chat")
	@SendTo("/waiting/{lobbyId}/send-chat")
	@CrossOrigin(origins = "*")
	@ResponseBody
	public UserMessage getMessage(@Payload UserMessage userResponse) {
		
		userResponse.setTime(new StringBuffer(DateTimeFormatter.ofPattern("hh:mm a").format(LocalTime.now())));
		return userResponse;
	}
	
	@MessageMapping("{gameKey}/get-game-data")
	@SendTo("/send-game-update/{gameKey}/get-game-data")
	@CrossOrigin(origins = "*")
	@ResponseBody
	public GameSessionInfo connect3(@DestinationVariable String gameKey,SimpMessageHeaderAccessor headerAccessor) {
		
		//Game Manager Service
		GameManagerService gm = GameManagerService.getInstance();
		
		//Get Game Session Wtih Key
		GameSessionBean game = gm.getGameByKey(new StringBuffer(gameKey));
		
		if(game.getState() != 2) game.updateGame();
		
		//Sort the players
		game.getTopThreePlayers();
		
		//init the game info object
		GameSessionInfo gameInfo = new GameSessionInfo(game);
		
		if(game.getState() == 3) gameInfo.setNumberOfAnswers(gameInfo.getPlayers());
		
		gameInfo.setTopScores(game.getCurrentPlayers());
		
		logger.trace("returning");
		return gameInfo;
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
	
	@MessageMapping("{lobbyId}/{userId}/update-waiting")
	@SendTo("/waiting/{lobbyId}/{userId}/send-waiting")
	@CrossOrigin(origins = "*")
	@ResponseBody
	public WaitingMessage connect2(@DestinationVariable String lobbyId, @DestinationVariable String userId, SimpMessageHeaderAccessor headerAccessor) {
		
		logger.trace("LOOK FOR ME");
		
		headerAccessor.getSessionAttributes().put("user", userId);
		headerAccessor.getSessionAttributes().put("lobby", lobbyId);
		
		GameManagerService gm = GameManagerService.getInstance();
		
		GameSessionBean game = gm.getGameByKey(new StringBuffer(lobbyId));
		
		logger.trace(game);
		
		//game.addDumbyData();
		//logger.trace("Is this it");
		
		//game.addDummyPlayer();
		
		ArrayList<PlayerBean> playerList = game.getCurrentPlayers();
		WaitingMessage wm = new WaitingMessage();
		
		int status = game.getState();
		
		wm.setPlayers(playerList);
		wm.setStatus(status);
		
		return wm;
	}
	
}
