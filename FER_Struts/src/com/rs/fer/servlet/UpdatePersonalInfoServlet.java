package com.rs.fer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.util.HTMLUtil;

public class UpdatePersonalInfoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FERService service=new FERServiceImpl();
		HttpSession session=request.getSession();
		PersonalInfo personalinfo=(PersonalInfo) session.getAttribute("personalinfo");
		PrintWriter out=response.getWriter();
		
		boolean updateFlag=service.uppdatePersonalInfo(personalinfo.getUser(), personalinfo.getAddress());
		
		HTMLUtil.generateHeaderAndLeftFrame(out, session.getAttribute("username").toString());
		
		if(updateFlag){
			out.println("Update Successfully");
		}else{
			out.println("Unable To Update");
		}
		 
		HTMLUtil.generateFooter(out);
	}

}
