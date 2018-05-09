<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo"%>

<jsp:useBean id="user" class="com.rs.fer.bean.User" scope="session"/>
<jsp:useBean id="address" class="com.rs.fer.bean.Address" scope="session" />

<%
FERService ferservice = new FERServiceImpl();
String username = session.getAttribute("username").toString();
PersonalInfo personalinfo = ferservice.getPersonalInfo(username);
session.setAttribute("personalinfo", personalinfo);

String firstname = personalinfo.getUser().getFirstname();
String middlename = personalinfo.getUser().getMiddlename();
String lastname = personalinfo.getUser().getLastname();

String phone = personalinfo.getUser().getMobile();
String emailid = personalinfo.getUser().getEmailid();

session.getAttribute(("username").toString());


String Streetname = personalinfo.getAddress().getStreetname();
String town = personalinfo.getAddress().getTown();
String city = personalinfo.getAddress().getCity();
String state = personalinfo.getAddress().getState();
String zip = personalinfo.getAddress().getZip();
String country = personalinfo.getAddress().getCountry();
session.getAttribute(("username").toString());
%>

<html:form action="dispPersonalInfo.do?method=personalInfoStatus">

<table border='1' align="center">
	<tr>
		<td>First Name</td>
		<td><%=personalinfo.getUser().getFirstname()%></td>
	</tr>

	<tr>
		<td>Middle Name</td>
		<td><%=personalinfo.getUser().getMiddlename()%></td>
	</tr>

	<tr>
		<td>Last Name</td>
		<td><%=personalinfo.getUser().getLastname()%></td>
	</tr>

	<tr>
		<td>Email</td>
		<td><%=personalinfo.getUser().getEmailid()%></td>
	</tr>

	<tr>
		<td>Mobile</td>
		<td><%=personalinfo.getUser().getMobile()%></td>
	</tr>

	<tr>
		<td>AddressLine1</td>
		<td><%=personalinfo.getAddress().getStreetname()%></td>
	</tr>

	<tr>
		<td>City</td>
		<td><%=personalinfo.getAddress().getCity()%></td>
	</tr>

	<tr>
		<td>Town</td>
		<td><%=personalinfo.getAddress().getTown()%></td>
	</tr>

	<tr>
		<td>State</td>
		<td><%=personalinfo.getAddress().getState()%></td>
	</tr>

	<tr>
		<td>Zip</td>
		<td><%=personalinfo.getAddress().getZip()%></td>
	</tr>
<tr>
		<td>Country</td>
		<td><%=personalinfo.getAddress().getCountry()%></td>
	</tr>
	<tr>
		<td colspan='2'><input type='submit' value='previous'> 
		<input type='submit' value='update'></td>
	</tr>
</table>
</html:form>