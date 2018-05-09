package com.rs.fer.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class AddExpenseForm extends ActionForm {

	private String expensetype;
	private String date;
	private int price;
	private int numberofitems;
	private int total;
	private String bywhom;

	public String getExpensetype() {
		return expensetype;
	}

	public void setExpensetype(String expensetype) {
		this.expensetype = expensetype;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumberofitems() {
		return numberofitems;
	}

	public void setNumberofitems(int numberofitems) {
		this.numberofitems = numberofitems;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getBywhom() {
		return bywhom;
	}

	public void setBywhom(String bywhom) {
		this.bywhom = bywhom;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors Errors = new ActionErrors();
		String method = request.getParameter("method");
		if (method != null
				&& (method.equalsIgnoreCase("editExpenseDropdown") || method.equalsIgnoreCase("displayEditExpense"))) {
			return null;
		}

		/*if (method != null && (method.equalsIgnoreCase("deleteExpenseDropdown"))
				|| method.equalsIgnoreCase(("deleteExpenseDropdown"))) {
			return null;
		}*/

		if (expensetype == null || expensetype.length() < 1) {
			Errors.add("expensetype", new ActionMessage("error.expensetype.required"));
		}
		if (date == null || date.length() < 1) {
			Errors.add("date", new ActionMessage("error.date.required"));
		}
		if (this.price == 0) {
			Errors.add("price", new ActionMessage("error.price.required"));
		}
		if (this.numberofitems == 0) {
			Errors.add("numberofitems", new ActionMessage("error.numberofitems.required"));
		}
		if (this.total == 0) {
			Errors.add("total", new ActionMessage("error.total.required"));
		}
		if (bywhom == null || bywhom.length() < 1) {
			Errors.add("bywhom", new ActionMessage("error.bywhom.required"));
		}

		return Errors;
	}

}
