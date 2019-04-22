package com.mrhu.requestandresponse;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/body.view")
public class TestStream extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String body = readBody(request);
		String user = request.getParameter("user");
		System.out.println(body);
		System.out.println(user);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String body = readBody(req);
		String user = req.getParameter("user");
		System.out.println(body);
		System.out.println(user);
	}



	private String readBody(HttpServletRequest request) throws IOException {
		String body = null;
		String input;
		BufferedReader reader = request.getReader();
		while((input = reader.readLine()) != null) {
			body = body + input + "<br>"; 
		}
		return body;
	}
	
}