package com.rs.fer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class UpdatePersonalInfoAction extends DispatchAction {
	FERService ferService = new FERServiceImpl();
	private final static String UPDATEPERSONALNAME = "UpdatePersonalName";
	private final static String UPDATEPERSONALCONTACT = "UpdatePersonalContact";

	public ActionForward nameInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();
		FERService ferService = new FERServiceImpl();
		String username = session.getAttribute("username").toString();

		PersonalInfo personalinfo = ferService.getPersonalInfo(username);
		session.setAttribute("personalinfo", personalinfo);

		return mapping.findForward(UPDATEPERSONALNAME);
	}

	public ActionForward contactInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		PersonalInfo personalinfo = (PersonalInfo) session
				.getAttribute("personalinfo");

		personalinfo.getUser().setFirstname(request.getParameter("firstname"));
		personalinfo.getUser().setMiddlename(
				request.getParameter("middlename"));
		personalinfo.getUser().setLastname(request.getParameter("lastname"));

		return mapping.findForward(UPDATEPERSONALCONTACT);
	}

	public ActionForward addressInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		PersonalInfo personalinfo = (PersonalInfo) session
				.getAttribute("personalinfo");
		
		personalinfo.getUser().setEmailid(request.getParameter("emailid"));
		personalinfo.getUser().setMobile(request.getParameter("mobile"));

		return mapping.findForward("AddressInfo");
	}

	public ActionForward review(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		PersonalInfo personalinfo = (PersonalInfo) session
				.getAttribute("personalinfo");
		personalinfo.getAddress().setStreetname(
				request.getParameter("streetname"));
		
		personalinfo.getAddress().setCity(request.getParameter("city"));
		personalinfo.getAddress().setTown(request.getParameter("town"));
		personalinfo.getAddress().setState(request.getParameter("state"));
	    personalinfo.getAddress().setCountry(request.getParameter("country"));
        personalinfo.getAddress().setZip(request.getParameter("zip"));
        
		return mapping.findForward("ReviewPersonalInfo");
	}

	public ActionForward personalInfoStatus(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		FERService ferService = new FERServiceImpl();
		HttpSession session = request.getSession();

		PersonalInfo personalInfo = (PersonalInfo) session
				.getAttribute("personalInfo");
		boolean updateFlag = ferService.uppdatePersonalInfo(
				personalInfo.getUser(), personalInfo.getAddress());

		session.setAttribute("status",
				updateFlag ? "Information Updated Successfully."
						: "Unable to Update Information");
		return mapping.findForward("UpdatePersonalInfoStatus");

	}

}
