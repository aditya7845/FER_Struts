<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,com.rs.fer.bean.PersonalInfo"%>

<jsp:useBean id="address" class="com.rs.fer.bean.Address"
	scope="session" />
<jsp:useBean id="user" class="com.rs.fer.bean.User" scope="session" />

<%
	FERService ferservice = new FERServiceImpl();
	String username = session.getAttribute("username").toString();
	PersonalInfo personalinfo = ferservice.getPersonalInfo(username);
	session.setAttribute("personalinfo", personalinfo);
	String Streetname = personalinfo.getAddress().getStreetname();
	String town = personalinfo.getAddress().getTown();
	String city = personalinfo.getAddress().getCity();
	String state = personalinfo.getAddress().getState();
	String zip = personalinfo.getAddress().getZip();
	String country = personalinfo.getAddress().getCountry();
	session.getAttribute(("username").toString());
%>
<html:form action="dispPersonalInfo.do?method=review">
	<table border='1' align="center">

		<tr>
			<td>Streetname</td>
			<td><input type='text' name='streetname'
				value="<%=personalinfo.getAddress().getStreetname()%>"></td>
		</tr>
		<tr>
			<td>City</td>
			<td><input type='text' name='city'
				value="<%=personalinfo.getAddress().getCity()%>"></td>
		</tr>
		<tr>
			<td>Town</td>
			<td><input type='text' name='town'
				value="<%=personalinfo.getAddress().getTown()%>"></td>
		</tr>
		<tr>
			<td>State</td>
			<td><input type='text' name='state'
				value="<%=personalinfo.getAddress().getState()%>"></td>
		</tr>
		<tr>
			<td>Zip</td>
			<td><input type='text' name='zip'
				value="<%=personalinfo.getAddress().getZip()%>"></td>
		</tr>
		<tr>
			<td>Country</td>
			<td><input type='text' name='country'
				value="<%=personalinfo.getAddress().getCountry()%>"></td>
		</tr>
		<tr>
			<td colspan='2' align='center'><input type='submit' value='Next'></td>
		</tr>
	</table>
</html:form>
