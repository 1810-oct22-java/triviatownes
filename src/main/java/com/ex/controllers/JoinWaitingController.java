package com.ex.controllers;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ex.beans.game.GameSessionBean;
import com.ex.beans.game.PlayerBean;
import com.ex.services.GameManagerService;

@Controller
@CrossOrigin(origins = "*")
public class JoinWaitingController {
	
	private static Logger logger = Logger.getLogger(NewUserController.class);
	
	@MessageMapping("{lobbyId}/get-waiting-lobby-data")
	@SendTo("/send-waiting-info/{lobbyId}/send-waiting-lobby-data")
	@CrossOrigin(origins = "*")
	public ArrayList<PlayerBean> connect(@DestinationVariable String lobbyId,SimpMessageHeaderAccessor headerAccessor) {
		
		GameManagerService gm = GameManagerService.getInstance();
		
		GameSessionBean game = gm.getGameByKey(new StringBuffer(lobbyId));
		ArrayList<PlayerBean> playerList = game.getCurrentPlayers();
		
		return playerList;
	}
		

}
