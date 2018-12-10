package com.ex.app;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.beans.game.HighScoreBean;
import com.ex.repository.UserRepository;

public class AppTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		UserRepository repo = (UserRepository) context.getBean(UserRepository.class);
		
	//	List<HighScoreBean> u = repo.oddQuery();
	//	System.out.println(u);
		
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
