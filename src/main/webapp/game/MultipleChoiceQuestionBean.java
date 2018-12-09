package com.ex.beans.game;

import com.ex.interfaces.game.QuestionInterface;

public class MultipleChoiceQuestionBean implements QuestionInterface{
	
	private StringBuilder question;
	private int answer;
	private StringBuilder a;
	private StringBuilder b;
	private StringBuilder c;
	private StringBuilder d;
	
	@Override
	public Boolean checkAnswer(int answer) {
		
		if(answer == this.answer) return true;
		return false;
	}
	@Override
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	@Override
	public int getAnswer() {
		return this.answer;
	}
	@Override
	public void setOption(StringBuilder option, int place) {
		if(place == 0) this.a = new StringBuilder(option);
		if(place == 1) this.b = new StringBuilder(option);
		if(place == 2) this.c = new StringBuilder(option);
		if(place == 3) this.d = new StringBuilder(option);
	}
}
