package com.catamania;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NumberOne extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		for(int i=0;i<5000;i++) {
			CompoundService.INSTANCE.faster("toto");
		}
		
		resp.getWriter().println("200 ok");
	}

	
	
}
