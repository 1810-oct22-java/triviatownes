package com.ex.controllers;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.beans.game.GameSessionInfo;
import com.ex.beans.game.PlayerBean;
import com.ex.services.GameManagerService;
import com.google.gson.Gson;

@Controller
@CrossOrigin(origins = "*")
public class LobbyHashController {
	
	private static Logger logger = Logger.getLogger(NewUserController.class);
	
	@MessageMapping("{category}/get-lobby-data")
	@SendTo("/lobbies-hash/{category}/get-lobby-data")
	@CrossOrigin(origins = "*")
	public int connect(@DestinationVariable String category,SimpMessageHeaderAccessor headerAccessor){
		
		logger.trace(category);
		logger.trace("Hello");
		
		GameManagerService gm = GameManagerService.getInstance();
		
		if(!gm.isFilled()) gm.makeDummyList();
		
		//gm.getGame(0).getCurrentPlayers().add(new PlayerBean());
	
		ArrayList<GameSessionInfo> payload = gm.getGameSessionsInfo(category);
		
		int jsonHash = new Gson().toJson(payload).hashCode();
		
		
		 
		logger.trace(jsonHash);
		
		return jsonHash;
	}
	
}
