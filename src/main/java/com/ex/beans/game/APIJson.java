package com.ex.beans.game;

import java.util.Arrays;

import org.springframework.stereotype.Component;

public class APIJson {
	
	private String response_code;
	//private Results[] results;
	private QuestionBean[] results;
	
	public String getResponse_code() {
		return response_code;
	}
	public void setResponse_code(String response_code) {
		this.response_code = response_code;
	}
	public QuestionBean[] getResults() {
		return results;
	}
	public void setResults(QuestionBean[] results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "ObjectJSON [response_code=" + response_code + ", question=" + Arrays.toString(results) + "]";
	}
	
	
	
	
	

}
