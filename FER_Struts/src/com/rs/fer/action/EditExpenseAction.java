package com.rs.fer.action;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.rs.fer.bean.Expense;
import com.rs.fer.form.AddExpenseForm;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class EditExpenseAction extends DispatchAction {
	FERService ferService = new FERServiceImpl();

	public ActionForward editExpenseDropdown(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		session.setAttribute("id", request.getParameter("id"));
		List<Expense> expenses = ferService.getExpenses();
		session.setAttribute("expenses", expenses);
		
		return mapping.findForward("editdropdown");
	}

	public ActionForward displayEditExpense(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		
		HttpSession session = request.getSession();
		String idinfo = request.getParameter("id");
		int id = Integer.parseInt(idinfo);
		Expense expense = ferService.getExpense(id);
		session.setAttribute("id", id);
		
		AddExpenseForm expenseForm = (AddExpenseForm) form;
		expenseForm.setExpensetype(expense.getExpensetype());
		expenseForm.setDate(expense.getDate());
		expenseForm.setPrice(expense.getPrice());
		expenseForm.setNumberofitems(expense.getNumberofitems());
		expenseForm.setTotal(expense.getTotal());
		expenseForm.setBywhom(expense.getBywhom());
		
		return mapping.findForward("editexpense");
	}

	public ActionForward editExpenseStatus(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Expense expense = new Expense();
		HttpSession session = request.getSession();
		
		String priceobj = request.getParameter("price");
		int price = Integer.parseInt(priceobj);

		String numberofitemsobj = request.getParameter("numberofitems");
		int numberofitems = Integer.parseInt(numberofitemsobj);

		String totalobj = request.getParameter("total");
		int total = Integer.parseInt(totalobj);

		String idobj=session.getAttribute("id").toString();
		

		expense.setExpensetype(request.getParameter("expensetype"));
		expense.setDate(request.getParameter("date"));
		expense.setPrice(price);
		expense.setNumberofitems(numberofitems);
		expense.setTotal(total);
		expense.setBywhom(request.getParameter("bywhom"));
		expense.setId(Integer.parseInt(idobj));
		
		DataSource dataSource=getDataSource(request, "FER_STRUTS");
		Connection connection=dataSource.getConnection();
		
		boolean editExpense = ferService.editExpense(expense,connection);
		session.setAttribute("editExpense", editExpense);
		
		return mapping.findForward("editExpensestatus");
	}

}
