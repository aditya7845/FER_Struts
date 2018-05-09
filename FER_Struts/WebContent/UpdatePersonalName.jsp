<%@page import="com.rs.fer.bean.PersonalInfo"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo"%>
<jsp:useBean id="user" class="com.rs.fer.bean.User" scope="session" />

<%
	FERService ferservice = new FERServiceImpl();
	String username = session.getAttribute("username").toString();
	PersonalInfo personalinfo = ferservice.getPersonalInfo(username);
	session.setAttribute("personalinfo", personalinfo);

	String firstname = personalinfo.getUser().getFirstname();
	String middlename = personalinfo.getUser().getMiddlename();
	String lastname = personalinfo.getUser().getLastname();
%>

<html:form action="dispPersonalInfo.do?method=contactInfo">
	<table border='1' align='center'>
		<tr>
			<td colspan='2' align='center'>UpdateName</td>
		</tr>
		<tr>
			<td>FirstName</td>
			<td><input type='text' name='firstname'
				value="<%=personalinfo.getUser().getFirstname()%>"></td>
		</tr>
		<tr>
			<td>MiddleName</td>
			<td><input type='text' name='middlename'
				value="<%=personalinfo.getUser().getMiddlename()%>"></td>
		</tr>
		<tr>
			<td>LastName</td>
			<td><input type='text' name='lastname'
				value="<%=personalinfo.getUser().getLastname()%>"></td>
		</tr>
		<tr>
			<td colspan='2' align='center'><input type='submit' value='Next'></td>

		</tr>

	</table>
</html:form>