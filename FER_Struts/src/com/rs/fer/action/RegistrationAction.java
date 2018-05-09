package com.rs.fer.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationAction extends org.apache.struts.action.Action {
	private final static String SUCCESS = "success";
	private final static String FAILURE = "failure";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		FERService ferService = new FERServiceImpl();

		User user = new User();

		user.setFirstname(request.getParameter("firstname"));
		user.setMiddlename(request.getParameter("middlename"));
		user.setLastname(request.getParameter("lastname"));
		user.setEmailid(request.getParameter("emailid"));
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setMobile(request.getParameter("mobile"));
        
		DataSource datasource=getDataSource(request, "FER_STRUTS");
		Connection connection=datasource.getConnection();
		
		boolean registrationFlag = ferService.registration(user, connection);
		if (registrationFlag) {
			return mapping.findForward(SUCCESS);
		} else {
			return mapping.findForward(FAILURE);
		}

	}

}