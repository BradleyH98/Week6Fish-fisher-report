<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "editListDetailServlet" method="post">
<input type ="hidden" name = "id" value= "${reportToEdit.id}">
	Report Name: <input type ="text" name = "reportName" value= "${reportToEdit.reportName}"><br />
	Report date: <input type ="text" name = "month" placeholder="mm" size="4" value= "${month}">
		<input type ="text" name = "day" placeholder="dd" size="4" value= "${date}">
		<input type ="text" name = "year" placeholder="yyyy" size="4" value= "${year}">
	Fisher Name: <input type = "text" name = "fisherName" value="${reportToEdit.fisher.fisherName}"><br />
	Available Items:<br />
<select name="allItemsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allItems}" var="currentitem">
	<option value = "${currentitem.dataID}">${currentitem.fishName} | ${currentitem.fishWeight} | ${currentitem.river}</option>
	</c:forEach>
</select>
<br />
<input type = "submit" value="Edit List and Add Items">
</form>
<a href = "index.html">Go add new items instead.</a>
</body>
</html>