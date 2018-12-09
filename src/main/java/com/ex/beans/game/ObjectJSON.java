package com.ex.beans.game;

import java.util.Arrays;

public class ObjectJSON {
	
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
	
	
	
	
	
//	public Results[] getResults() {
//		return results;
//	}
//	public void setResults(Results[] results) {
//		this.results = results;
//	}
//	@Override
//	public String toString() {
//		return "ObjectJSON [response_code=" + response_code + ", results=" + Arrays.toString(results) + "]";
//	}
	
	
	
	

}
