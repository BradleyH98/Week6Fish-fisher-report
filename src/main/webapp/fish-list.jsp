<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Fish Information Chart</title>
</head>
<body>
<form method = "post" action = "navigationServlet">
	<table>
		<tr>
			<th>Object Select</th>
			<th>Fish Name</th>
			<th>Fish Weight (Pounds)</th>
			<th>River Name</th>
		</tr>
		<c:forEach items="${requestScope.showAllItems}" var="currentitem">
			<tr>
				<td><input type="radio" name="id" value="${currentitem.dataID}"></td>
				<td>${currentitem.fishName}</td>
				<td>${currentitem.fishWeight}</td>
				<td>${currentitem.river}</td>
			</tr>
		</c:forEach>
	</table>
<input type = "submit" value = "edit" name="doThisToItem">
<input type = "submit" value = "delete" name="doThisToItem">
<input type="submit" value = "add" name = "doThisToItem">
</form>
</body>
</html>