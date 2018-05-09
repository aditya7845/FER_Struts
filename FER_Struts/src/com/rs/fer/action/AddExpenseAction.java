package com.rs.fer.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rs.fer.bean.Expense;
import com.rs.fer.form.AddExpenseForm;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class AddExpenseAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		FERService ferService = new FERServiceImpl();
		AddExpenseForm addExpenseForm = (AddExpenseForm) form;
		Expense expense = new Expense();

		expense.setExpensetype(addExpenseForm.getExpensetype());
		expense.setDate(addExpenseForm.getDate());
		expense.setPrice(addExpenseForm.getPrice());
		expense.setNumberofitems(addExpenseForm.getNumberofitems());
		expense.setTotal(addExpenseForm.getTotal());
		expense.setBywhom(addExpenseForm.getBywhom());
		
		DataSource dataSource = getDataSource(request, "FER_STRUTS");
		Connection connection = dataSource.getConnection();

		boolean addExpense = ferService.addExpense(expense,connection);

		if (addExpense) {
			return mapping.findForward("success");
		} else {
			return mapping.findForward("failure");
		}

	}

}
