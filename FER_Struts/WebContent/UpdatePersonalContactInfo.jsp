<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo"%>


<jsp:useBean id="user" class="com.rs.fer.bean.User" scope="session" />

<%
FERService ferservice = new FERServiceImpl();
String username = session.getAttribute("username").toString();
PersonalInfo personalinfo = ferservice.getPersonalInfo(username);
session.setAttribute("personalinfo", personalinfo);

	 /* personalinfo.getUser().setFirstname(
			request.getParameter("firstname"));
	personalinfo.getUser().setMiddlename(
			request.getParameter("middlename"));
	personalinfo.getUser()
			.setLastname(request.getParameter("lastname")); 
 */
	String phone = personalinfo.getUser().getMobile();
	String emailid = personalinfo.getUser().getEmailid();

	session.getAttribute(("username").toString());
%>

<html:form action="dispPersonalInfo.do?method=addressInfo">

	<table border='1' align="center">

		<tr>
			<td>Email</td>
			<td><input type='text' name='emailid'
				value="<%=personalinfo.getUser().getEmailid()%>"></td>
		</tr>
		<tr>
			<td>Mobile</td>
			<td><input type='text' name='mobile'
				value="<%=personalinfo.getUser().getMobile()%>"></td>

		</tr>

		<tr>
			<td colspan='2' align='center'><input type='submit' value='Next'></td>
		</tr>
	</table>
</html:form>