<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report List</title>
</head>
<body>
	<form name="listReport" method = "post" action = "listNavigationServlet">
	<table>
	<c:forEach items="${requestScope.allLists}" var="currentlist">
		<tr>
			<td><input type="radio" name="id" value="${currentlist.id}"></td>
			<td><h2>${currentlist.reportName}</h2></td></tr>
			<tr><td colspan="3">Report Date: ${currentlist.reportDate}</td></tr>
			<tr><td colspan="3">Fisher: ${currentlist.fisher.fisherName}</td></tr>
			<c:forEach var = "listVal" items = "${currentlist.listOfFish}">
				<tr><td></td><td colspan="3">
					${listVal.fishName}, ${listVal.fishWeight}, ${listVal.river}
					</td>
				</tr>
	</c:forEach>
</c:forEach>
</table>
<input type = "submit" value = "edit" name="doThisToList">
<input type = "submit" value = "delete" name="doThisToList">
<input type="submit" value = "add" name = "doThisToList">
</form>
<a href="addItemsForListServlet">Create a new List</a>
<a href="index.html">Insert a new item</a>
</body>
</html>