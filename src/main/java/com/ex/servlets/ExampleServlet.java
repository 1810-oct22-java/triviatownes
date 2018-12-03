package com.ex.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ex.util.ConnectionFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/example")
public class ExampleServlet extends HttpServlet {
	
	private static Logger logger = Logger.getLogger(ExampleServlet.class);
	
	//get all genres method
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String hello = "test";
	
		//convert to JSON
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(hello);
		logger.trace(json);
		
		//send response
		PrintWriter writer = resp.getWriter();
		resp.setContentType("application/json");
		writer.write(json);
		
	}
	
}
