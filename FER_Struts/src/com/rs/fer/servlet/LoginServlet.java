package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String username = request.getParameter("username");
		String password = request.getParameter("password");
        HttpSession session = request.getSession();
        FERService ferService = new FERServiceImpl();
        boolean loginFlag = ferService.login(username, password, null);
		PrintWriter out = response.getWriter();
		

		if (loginFlag) {
			
			HTMLUtil.generateHeaderAndLeftFrame(out, username);
			session.setAttribute("username", username);
			out.println("Welcome to	User: "+username);
			HTMLUtil.generateFooter(out);																																																												

		} else

		{
			out.println("Invalid Username Or Password ");
		} 
	}

}
