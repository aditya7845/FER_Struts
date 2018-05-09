<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html:form action="/AddExpense">
	<table align='center' border='10'>
		<tr>
			<td colspan='2' align='center'>Add Expense</td>
		</tr>

		<tr>
			<td>Expensetype</td>
			<td><html:text name="AddExpenseForm" property="expensetype" /></td>

		</tr>
		<tr>
			<td>Date</td>
			<td><html:text name="AddExpenseForm" property="date" /></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><html:text name="AddExpenseForm" property="price" /></td>
		</tr>
		<tr>
			<td>NumberOfItems</td>
			<td><html:text name="AddExpenseForm" property="numberofitems" /></td>
		</tr>
		<tr>
			<td>Total</td>
			<td><html:text name="AddExpenseForm" property="total" /></td>
		</tr>
		<tr>
			<td>Bywhom</td>
			<td><html:text name="AddExpenseForm" property="bywhom" /></td>
		</tr>
		<tr>
			<td colspan='2' align='center'><html:submit value="Add" /></td>
		</tr>
	</table>
</html:form>