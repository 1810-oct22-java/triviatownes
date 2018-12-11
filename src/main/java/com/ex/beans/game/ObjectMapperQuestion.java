package com.ex.beans.game;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperQuestion {
	
	//Turn JSON into question arrayList 
	public static void main(String[] args) {
		
		getQuestions(1, "All", "easy");
	}
	
	
	
	public static  List<QuestionBean > getQuestions(int numOfQuestions, String category, String difficulty) {
		
		try {
			
			String url;
			
			int categoryNumber = convertCategoryToNumber(category);
			
			if(categoryNumber == 0) {
				url = "https://opentdb.com/api.php?amount=" + numOfQuestions + "&difficulty=" + difficulty;
			} else {
				url = "https://opentdb.com/api.php?amount=" + numOfQuestions + "&category=" + categoryNumber + "&difficulty=" + difficulty;
			}
			
			
			APIJson objJson = readJsonWithObjectMapper(url);
			
			QuestionBean[] question;
			
			//Get a question array
			question = objJson.getResults();
			
			//appending to arraylist
			List<QuestionBean> questionList = new ArrayList<>();
			
			for(QuestionBean q : question ) {
				questionList.add(q);
			}
			
			System.out.println(questionList);
			
			return questionList;
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}

	//Read JSON from trivia api and turn it into object
	public static APIJson readJsonWithObjectMapper(String urlApi) throws IOException {
		
	
        URL url = new URL(urlApi);
		
		ObjectMapper mapper = new ObjectMapper();
		APIJson obj = mapper.readValue(url, APIJson.class);
		return obj;
	}
	
	
	//Convert category name to its corresponding category number
	public static int convertCategoryToNumber(String category) {
		
		
		switch(category) {
		case "Geography": return 22;
		case "History": return 23;
		case "Sport": return 21;
		case "Politics": return 24;
		case "Art": return 25;
		case "Math": return 19;
		case "Computer": return 18;
		case "Movies": return 11;
		case "All": return 0;
		
		default: System.out.println("wrong category");
		return 1;
		}
	
	}
}
