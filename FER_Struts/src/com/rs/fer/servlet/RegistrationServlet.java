package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("RegistrationHttp.doPost");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		com.rs.fer.bean.User user=new com.rs.fer.bean.User();
		
		user.setFirstname(request.getParameter("firstname"));
		user.setMiddlename(request.getParameter("middlename"));
		user.setLastname(request.getParameter("lastname"));
		user.setEmailid(request.getParameter("emailid"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setMobile(request.getParameter("mobile"));
		
		FERService ferservice=new FERServiceImpl();
		boolean isRegister=ferservice.registration(user,null);
		
		if(isRegister){
			out.println("Registration Success..");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}else{
			out.println("Regristration Failed");
			
			out.println("<a href=\"javascript:history.go(-1)\">Back</a>");
		}

		
		
		
		
	}

}
