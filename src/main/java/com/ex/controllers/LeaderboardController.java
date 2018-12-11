package com.ex.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.game.LeaderboardBean;
import com.ex.services.LeaderBoardService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/leaders")
public class LeaderboardController {

	
	@CrossOrigin(origins = "*")
	@RequestMapping(method=RequestMethod.GET)
	public List<LeaderboardBean> getAll() {
		LeaderBoardService ls = new LeaderBoardService();
		return ls.getAll();
	}
}
