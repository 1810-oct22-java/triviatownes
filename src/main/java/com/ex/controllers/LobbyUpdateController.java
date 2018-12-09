package com.ex.controllers;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.game.GameSessionInfo;
import com.ex.services.GameManagerService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/lobby-data/data")
@CrossOrigin(origins = "*")
public class LobbyUpdateController {
	
	private static Logger logger = Logger.getLogger(LobbyUpdateController.class);
	
	//GET BY ID
	@RequestMapping(
					method=RequestMethod.GET)
	@CrossOrigin(origins = "*")
	@ResponseBody
	public String sendLobbyData() {
		
		logger.trace("Sending Payload");
		
		GameManagerService gm = GameManagerService.getInstance();
		
		if(!gm.isFilled()) gm.makeDummyList();
		
		ArrayList<GameSessionInfo> payload = gm.getGameSessionsInfo("");
		
		logger.trace("Testing");
		
		String json = new Gson().toJson(payload).toString();
		
		String fJson = "{\"data\":" + json + "}";
		
		logger.trace(fJson);
		
		return fJson;
	}
	

}