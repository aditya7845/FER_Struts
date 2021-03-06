package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class DeleteExpenseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FERService ferService = new FERServiceImpl();
		String Idobj = request.getParameter("expenseId");
		int expenseId = Integer.parseInt(Idobj);

		boolean deleteExpenseFlag = ferService.deleteExpense(expenseId,null);
		PrintWriter out = response.getWriter();
		HTMLUtil.generateHeaderAndLeftFrame(out, " ");

		if (deleteExpenseFlag) {
			out.println("delete successfully");
		} else {
			out.println("delete failed");
		}
		HTMLUtil.generateFooter(out);
	}

}
