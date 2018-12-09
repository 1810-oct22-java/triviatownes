package com.ex.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.game.GameSessionBean;
import com.ex.services.GameManagerService;

@RestController
@RequestMapping("/create-game")
public class CreateGameController {
		
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public GameSessionBean createGame(HttpServletRequest req, HttpServletResponse resp) {
		GameManagerService service = GameManagerService.getInstance();
		int id = service.createGame();
		GameSessionBean gs = service.getGame(id);
		return gs;
	}

}
