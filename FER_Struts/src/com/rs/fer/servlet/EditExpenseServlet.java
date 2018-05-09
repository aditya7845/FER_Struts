package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.Expense;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class EditExpenseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		FERService ferservice = new FERServiceImpl();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Expense expense = new Expense();

		String priceobj = request.getParameter("price");
		int price = Integer.parseInt(priceobj);

		String numberofitemsobj = request.getParameter("numberOfItems");
		int numberOfItems = Integer.parseInt(numberofitemsobj);

		String totalobj = request.getParameter("total");
		int total = Integer.parseInt(totalobj);

		String idobj=session.getAttribute("id").toString();
		

		expense.setExpensetype(request.getParameter("expensetype"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(price);
		expense.setNumberofitems(numberOfItems);
		expense.setTotal(total);
		expense.setBywhom(request.getParameter("bywhom"));
		expense.setId(Integer.parseInt(idobj));

		boolean editExpenseFlag = ferservice.editExpense(expense,null);

		if (editExpenseFlag) {
			HTMLUtil.generateHeaderAndLeftFrame(out, " ");
			out.println("Edit successfully");
		} else {
			out.println("Unable to Edit");

		}
		HTMLUtil.generateFooter(out);
	}
}