package com.ex.beans.game;

import java.io.IOException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperQuestion {
	
	//Turn JSON into array results
	public static void main(String[] args) {
		try {
			Results[] result;
			
			ObjectJSON obj = readJsonWithObjectMapper();
			result = obj.getResults();
			for(Results r : result ) {
				System.out.println(r);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Read JSON from trivia api and turn it into object
	public static ObjectJSON readJsonWithObjectMapper() throws IOException {
		
		String query_url = "https://opentdb.com/api.php?amount=10";
        URL url = new URL(query_url);
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectJSON obj = mapper.readValue(url, ObjectJSON.class);
		return obj;
	}
}
