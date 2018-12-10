package com.ex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.game.LeaderboardBean;
import com.ex.services.LeaderboardService;

@RestController
@RequestMapping("/leaders")
public class LeaderboardController {

	
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<LeaderboardBean> getAll() {
		LeaderboardService ls = new LeaderboardService();
		return ls.getAll();
	}
}
