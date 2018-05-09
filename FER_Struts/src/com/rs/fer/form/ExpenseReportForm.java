package com.rs.fer.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ExpenseReportForm extends ActionForm {

	private String expensetype;
	private String fromdate;
	private String todate;





	public String getExpensetype() {
		return expensetype;
	}





	public void setExpensetype(String expensetype) {
		this.expensetype = expensetype;
	}





	public String getFromdate() {
		return fromdate;
	}





	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}





	public String getTodate() {
		return todate;
	}





	public void setTodate(String todate) {
		this.todate = todate;
	}





	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (expensetype == null || expensetype.length() < 1) {
			errors.add("expensetype", new ActionMessage("error.expensetype.required"));
		}
		if (fromdate == null || fromdate.length() < 1) {
			errors.add("fromdate", new ActionMessage("error.fromdate.required"));
		}
		if (todate == null || todate.length() < 1) {
			errors.add("todate", new ActionMessage("error.todate.required"));
		}
		return errors;

	}
}
