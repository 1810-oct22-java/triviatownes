package com.ex.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.game.LeaderboardBean;
import com.ex.services.LeaderboardService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/leaders")
public class LeaderboardController {

	
	@CrossOrigin(origins = "*")
	@RequestMapping(method=RequestMethod.GET)
	public List<LeaderboardBean> getAll() {
		LeaderboardService ls = new LeaderboardService();
		return ls.getAll();
	}
}
