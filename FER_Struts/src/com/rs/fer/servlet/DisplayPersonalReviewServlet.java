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

public class DisplayPersonalReviewServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		FERService service=new FERServiceImpl();
		PrintWriter out=response.getWriter();
		
		PersonalInfo personalinfo=(PersonalInfo) session.getAttribute("personalinfo");
		
		personalinfo.getAddress().setStreetname(request.getParameter("streetname"));
		personalinfo.getAddress().setTown(request.getParameter("town"));
		personalinfo.getAddress().setCity(request.getParameter("city"));
		personalinfo.getAddress().setState(request.getParameter("state"));
		personalinfo.getAddress().setZip(request.getParameter("zip"));
		personalinfo.getAddress().setCountry(request.getParameter("country"));
	
		HTMLUtil.generateHeaderAndLeftFrame(out,session.getAttribute("username").toString());
		
		out.println("<table border='1'>");
		out.println("<tr>");
		out.println("<td>First Name</td>");
		out.println("<td>" +personalinfo.getUser().getFirstname() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Middle Name</td>");
		out.println("<td>"+ personalinfo.getUser().getMiddlename() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Last Name</td>");
		out.println("<td>"+ personalinfo.getUser().getLastname() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Email Id</td>");
		out.println("<td>"+ personalinfo.getUser().getEmailid() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Mobile Number</td>");
		out.println("<td>"+ personalinfo.getUser().getMobile() + "</td>");
		out.println("</tr>");
		
		
		out.println("<tr>");
		out.println("<td>Streetname</td>");
		out.println("<td>"+ personalinfo.getAddress().getStreetname() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Town</td>");
		out.println("<td>"+ personalinfo.getAddress().getTown() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>City</td>");
		out.println("<td>"+ personalinfo.getAddress().getCity() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>State</td>");
		out.println("<td>"+ personalinfo.getAddress().getState() + "</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td>Zip</td>");
		out.println("<td>"+ personalinfo.getAddress().getZip() + "</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Country</td>");
		out.println("<td>"+ personalinfo.getAddress().getCountry() + "</td>");
		out.println("</tr>");
		



		out.println("<tr>");
		out.println("<td colspan='2'>");
		out.println("<input type='button' value='previous' onclick='javascript:submitForm(\"displayAddressInfo\");'>");
		out.println("<input type='button' value='update' onclick='javascript:submitForm(\"updatePersonalInfo\");'></td>");
		out.println("</tr>");
		out.println("</table>");
		
		HTMLUtil.generateFooter(out);
	}

}
