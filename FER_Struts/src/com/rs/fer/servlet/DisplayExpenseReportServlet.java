package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;
import com.sun.media.jfxmedia.events.NewFrameEvent;

public class DisplayExpenseReportServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		FERService ferservice= new FERServiceImpl();
		PrintWriter out=response.getWriter();
        
		
		
		
		HTMLUtil.generateHeaderAndLeftFrame(out, session.getAttribute("username").toString());
		
		out.println("<table border='10' align='center'>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'>Get Expense</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Expense Type</td>");
		out.println("<td><input type='text' name='expenseType'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>FromDate</td>");
		out.println("<td><input type='text' name='fromdate'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>ToDate</td>");
		out.println("<td><input type='text' name='todate'></td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td colspan='2' align='center'><input type='button'");
		out.println("value='Get Report' onclick=\"javascript:submitForm('expenseReport')\"></td>");
		out.println("</tr>");
		out.println("</table>");
		
		HTMLUtil.generateFooter(out);
	}

}
