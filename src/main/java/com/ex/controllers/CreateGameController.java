package com.ex.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.game.GameSessionBean;
import com.ex.beans.game.PlayerBean;
import com.ex.services.GameManagerService;

@RestController
@RequestMapping("/create-game")
public class CreateGameController {
	
	static int count = 1;
        
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public int createGame(HttpServletRequest req, HttpServletResponse resp) {
        GameManagerService service = GameManagerService.getInstance();
        int id = service.createGame();
        GameSessionBean gs = service.getGame(id);
        
        gs.setJoinKey(new StringBuffer(count));
        gs.setDifficulty(new StringBuffer(req.getParameter("difficulty")));
        gs.setCategory(new StringBuffer(req.getParameter("category")));
        gs.setMaxPlayers(new Integer(req.getParameter("seats")));
        gs.numberOfQuestions = new Integer(req.getParameter("questions"));
        gs.setName(new StringBuffer(req.getParameter("difficulty")));
        
        StringBuffer username = new StringBuffer(req.getParameter("username"));
        
        PlayerBean player = new PlayerBean();
        
        player.setUsername(username);
        
        gs.addPlayer(player);
        
        gs.loadQuestions();
        
        return count;
    }
}
