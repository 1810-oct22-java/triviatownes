package com.ex.services;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.game.HighScorePlayerBean;
import com.ex.repository.UserRepository;



public class LeaderBoardService {
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	UserRepository repo = (UserRepository) context.getBean(UserRepository.class);
	public List<HighScorePlayerBean> getAll(){
		return repo.findAll();
	}
	
	public HighScorePlayerBean save(HighScorePlayerBean highScore) {
		return repo.save(highScore);
	}
}
