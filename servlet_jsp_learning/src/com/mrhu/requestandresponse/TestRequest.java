package com.mrhu.requestandresponse;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testRequest")
public class TestRequest extends HttpServlet{
	
	public TestRequest() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("执行了doGet方法");
		processRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("执行了doPost方法");
		processRequest(request, response);
	}
	
	/**
	 * 当get方法和post方法要执行相同的逻辑时采用这种方法
	 * @param request 传过来的请求
	 * @param response 传递回去的响应
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		String param1 = request.getParameter("user");
		String[] param2 = request.getParameterValues("course");
		Enumeration<String> e = request.getParameterNames();
		String protocol = request.getProtocol();
		System.out.println(param1 + "\n" + protocol);
		for(String s : param2) {
			System.out.println(s);
		}
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
}
