package com.ex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ex.beans.game.GameSessionBean;
import com.ex.beans.game.GameSessionInfo;
import com.ex.beans.game.GameUpdateResponse;
import com.ex.beans.game.HighScorePlayerBean;
import com.ex.repository.HighScoreBeanRepository;

@Component
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/leaders")
public class LeaderBoardController {
	@Autowired
	private static HighScoreBeanRepository repo;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method=RequestMethod.GET)
	public static void leaderboard(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HighScoreBeanRepository repo = (HighScoreBeanRepository) context.getBean(HighScoreBeanRepository.class);
		
		GameSessionBean gsb = new GameSessionBean();
		
		gsb.getCurrentPlayers();
		gsb.getNumberOfQuestions();
		gsb.getInstanceId();
		gsb.getCurrentAnswers();
		gsb.getCurrentQuestion();
		gsb.getDifficulty();
		gsb.getSortByPointsComparator();
		
		
		
		GameSessionInfo gsi = new GameSessionInfo(gsb);
		GameUpdateResponse gup = new GameUpdateResponse();
		
		gsb.getCurrentPlayers();
		gsb.getTopThreePlayers();
		gsb.getSortByPointsComparator();
		
		
		
		HighScorePlayerBean hspb = new HighScorePlayerBean();
		
		
		for(int i =0; i < gsi.getMaxPlayers(); i++) {
		
		hspb.setScore(gsb.getCurrentAnswers()/gsb.getNumberOfQuestions());
		hspb.setMaxStreak(gsb.getCurrentAnswers());
		hspb.setRightAnswers(gsb.getCurrentAnswers());
		hspb.setUsername(gsb.getName());
		
		repo.save(hspb);
		
		
		}
		
         List<HighScorePlayerBean> u = repo.findAll();
		
	}
}