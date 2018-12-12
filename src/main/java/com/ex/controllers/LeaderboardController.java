package com.ex.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.game.HighScorePlayerBean;
import com.ex.services.LeaderBoardService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/leaders")
public class LeaderboardController {

	
	@CrossOrigin(origins = "*")
	@RequestMapping(method=RequestMethod.GET)
	public List<HighScorePlayerBean> getAll() {
		LeaderBoardService ls = new LeaderBoardService();
		return ls.getAll();
	}
}
