package com.ex.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/game")
public class GameController {
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String home() {
		return "Welcome to Spring MVC!";
	}

}