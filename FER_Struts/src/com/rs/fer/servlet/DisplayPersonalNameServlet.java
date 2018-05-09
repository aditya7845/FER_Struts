package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class DisplayPersonalNameServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		FERService ferservice = new FERServiceImpl();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String username = session.getAttribute("username").toString();

		// String userId = request.getParameter("id");
		// int id = Integer.parseInt(userId);
		PersonalInfo personalinfo = ferservice.getPersonalInfo(username);

		session.setAttribute("personalinfo", personalinfo);

		HTMLUtil.generateHeaderAndLeftFrame(out,
				session.getAttribute("username").toString());
		
	
		out.println("<table border='1' align='center'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>UpdateName</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>FirstName</td>");
		out.println("<td><input type='text' name='firstname' value='"
				+ personalinfo.getUser().getFirstname() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>MiddleName</td>");
		out.println("<td><input type='text' name='middlename' value='"
				+ personalinfo.getUser().getMiddlename() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>LastName</td>");
		out.println("<td><input type='text' name='lastname' value='"
				+ personalinfo.getUser().getLastname() + "'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'><input type='button' value='Next' onclick='javascript:submitForm(\"displayPersonalContact\");'></td>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</td>");
		out.println("</table>");
		HTMLUtil.generateFooter(out);
	}

}
