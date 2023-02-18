<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edit Info</title>
</head>
<body>
	<form action = "editItemServlet" method="post">
	Fish: <input type ="text" name = "fish" value= "${itemToEdit.fishName}">
	Weight: <input type = "text" name = "weight" value= "${itemToEdit.fishWeight}">
	River: <input type = "text" name = "river" value= "${itemToEdit.river}">
	<input type = "hidden" name = "id" value="${itemToEdit.dataID}">
	<input type = "submit" value="Save Edited Item">
	</form>
</body>
</html>