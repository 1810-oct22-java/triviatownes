package com.ex.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.ex.beans.game.HighScoreBean;
import com.ex.beans.game.PlayerBean;
import com.ex.repository.UserRepository;

@Component
public class App {

	@Autowired
	private static UserRepository repo;
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserRepository repo = (UserRepository) context.getBean(UserRepository.class);
		
		List<HighScoreBean> u = repo.oddQuery();
		System.out.println(u);
		
		//repo.Save("bill", 10, 15, 15);
		//repo.Save("NULL","Bill", 10, 12, 12);
		HighScoreBean hsb = new HighScoreBean();
//hsb.setId(1);
hsb.setUsername("John");
hsb.setScore(12);
hsb.setMaxStreak(6);
hsb.setRightAnswers(12);
		repo.save(hsb);
		
		
	}

}