package com.mrhu.struts.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CrosFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse)rsp;
		HttpServletRequest request = (HttpServletRequest)req;

		response.setHeader("Access-Control-Allow-Origin", "*"); 
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");  
        response.setHeader("Access-Control-Max-Age", "3600");  
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, accept, Content-Type");  
        response.setHeader("Access-Control-Allow-Credentials", "true");
        chain.doFilter(req, rsp);
	}

}
