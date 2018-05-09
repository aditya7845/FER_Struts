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

public class AddExpenseServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		FERService ferservice=new FERServiceImpl();
		Expense expense=new Expense();
		
		String priceobj=request.getParameter("price");
		int price=Integer.parseInt(priceobj);
		
		String numberofitemsobj=request.getParameter("numberOfItems");
		int numberOfItems=Integer.parseInt(numberofitemsobj);
		
		String totalobj=request.getParameter("total");
		int total=Integer.parseInt(totalobj);
		
		
		expense.setExpensetype(request.getParameter("expenseType"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(price);
		expense.setNumberofitems(numberOfItems);
		expense.setTotal(total);
		expense.setBywhom(request.getParameter("byWhom"));
		expense.setRemarks(request.getParameter("remarks"));
		
		boolean addexpenseFlag=ferservice.addExpense(expense,null);
		
		HttpSession session=request.getSession();
		HTMLUtil.generateHeaderAndLeftFrame(out, session.getAttribute("username").toString());
		if(addexpenseFlag){
			out.println("Expense added successfully");
		}else{
			
			out.println("Adding Expense Failed");
			out.println("<a href=\"javascript:history.go(-1)\">Back</a>");
			
		}
		HTMLUtil.generateFooter(out);
		
	}



}
