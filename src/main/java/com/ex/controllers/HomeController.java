package com.ex.controllers;


import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.game.HighScoreBean;
import com.ex.repository.UserRepository;

@RestController
@RequestMapping(value = "/home/")
public class HomeController {
	
	
    @RequestMapping(method=RequestMethod.GET, value="/test")
    @ResponseBody
    public String home(HttpServletResponse resp, HttpServletRequest req) {
        
        HttpSession session = req.getSession();
        
        
	
	
	
	
/*	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public String home() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserRepository repo = (UserRepository) context.getBean(UserRepository.class);
		
		List<HighScoreBean> u = repo.findAll();
		System.out.println(u);
		
		//repo.Save("bill", 10, 15, 15);
		//repo.Save("NULL","Bill", 10, 12, 12);
		HighScoreBean hsb = new HighScoreBean();
//hsb.setId(1);
hsb.setUsername("John");
hsb.setScore(12);
hsb.setMaxStreak(6);
hsb.setRightAnswers(12);
		repo.save(hsb);*/
		
		
		return "Welcome to Spring!";
		
		
		
	}

}