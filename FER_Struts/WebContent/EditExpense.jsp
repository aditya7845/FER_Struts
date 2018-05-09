<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@page
	import="com.rs.fer.service.FERService,com.rs.fer.service.FERServiceImpl,java.lang.*,java.util.*,com.rs.fer.bean.Expense"%>
<html:form action="displayEditExpense.do?method=editExpenseStatus">

	<table border='1' align='center'>
		<tr height='50px'>
			<td align='center' colspan='2'>Edit Expense</td>
		</tr>

		<tr>
			<td>Expense Type</td>
			<td><html:text name="AddExpenseForm" property='expensetype'/></td>


		</tr>
		<tr>
			<td>Date</td>
			<td><html:text name="AddExpenseForm" property='date'/></td>


		</tr>
		<tr>
			<td>Price</td>
			<td><html:text name="AddExpenseForm" property='price'/></td>
		</tr>

		<tr>
			<td>NumberOfItems</td>
			<td><html:text name="AddExpenseForm" property='numberofitems'/></td>
		</tr>

		<tr>
			<td>Total</td>
			<td><html:text name="AddExpenseForm" property='total'/></td>
		</tr>
		<tr>
			<td>By Whom</td>
			<td><html:text name="AddExpenseForm" property='bywhom'/></td>


		</tr>
		<tr>
			<td colspan='2' align='center'><html:submit value='Edit Expense' /></td>
		</tr>

	</table>

</html:form>

