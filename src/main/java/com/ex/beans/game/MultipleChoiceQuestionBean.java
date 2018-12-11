package com.ex.beans.game;

import com.ex.interfaces.game.QuestionInterface;
import org.springframework.stereotype.Component;

@Component
public class MultipleChoiceQuestionBean{
	
	private boolean isMultipleChoice; 
	private String category;
	private String difficulty;
	private String question;
	private String[] answers;
	
	public MultipleChoiceQuestionBean() {
		
	};
	
	public MultipleChoiceQuestionBean(String category, String difficulty, String question, String[] answers) {
		super();
		this.category = category;
		this.difficulty = difficulty;
		this.question = question;
		this.answers = answers;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String[] getAnswers() {
		return answers;
	}
	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
	
	
}
