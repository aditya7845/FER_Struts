package com.rs.fer.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rs.fer.form.LoginForm;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class LoginAction extends Action {
	private final static String DASHBOARD = "dashboard";
	private final static String FAILURE = "failure";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		FERService ferService = new FERServiceImpl();
		
		LoginForm loginForm = (LoginForm) form;
		
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("username", username);
		
		DataSource dataSource = getDataSource(request, "FER_STRUTS");
		Connection connection = dataSource.getConnection();
		
		boolean loginFlag = ferService.login(username, password, connection);
		
		if (loginFlag) {
			return mapping.findForward(DASHBOARD);
		} else {
			return mapping.findForward(FAILURE);
		}

	}
}
