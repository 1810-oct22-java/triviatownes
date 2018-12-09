package com.ex.beans.game;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperQuestion {
	
	//Turn JSON into question arrayList 
	public static void main(String[] args) {
		try {
			
			String url = "https://opentdb.com/api.php?amount=10";
			
			
			List<QuestionBean> questionList = new ArrayList<>();
			
			QuestionBean[] question;
			
			ObjectJSON obj = readJsonWithObjectMapper(url);
			
			question = obj.getResults();
			
			for(QuestionBean q : question ) {
				questionList.add(q);
			}
			
			System.out.println(questionList);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	//Read JSON from trivia api and turn it into object
	public static ObjectJSON readJsonWithObjectMapper(String urlApi) throws IOException {
		
	
        URL url = new URL(urlApi);
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectJSON obj = mapper.readValue(url, ObjectJSON.class);
		return obj;
	}
}
