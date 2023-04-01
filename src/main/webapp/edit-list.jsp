<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<script>
		function validateInput() {
			if (document.editList.reportName.value == "") {
				alert("the report name is missing");
				document.editList.reportName.focus();
				return false;
			}
			if (document.editList.month.value == "") {
				alert("the month for the date is missing");
				document.editList.month.focus();
				return false;
			}
			if (document.editList.day.value == "") {
				alert("the day of the date is missing");
				document.editList.day.focus();
				return false;
			}
			if (document.editList.year.value == "") {
				alert("the year of the date is missing");
				document.editList.year.focus();
				return false;
			}
			if (document.editList.fisherName.value == "") {
				alert("the fisher's name is missing");
				document.editList.fisherName.focus();
				return false;
			}
			return(true);
		}
	</script>
</head>
<body>
<form name="editList" action = "editListDetailServlet" onsubmit="return validateInput()" method="post">
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