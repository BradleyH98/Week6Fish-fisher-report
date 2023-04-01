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
			if (document.newList.reportName.value == "") {
				alert("the report name is missing");
				document.newList.reportName.focus();
				return false;
			}
			if (document.newList.month.value == "") {
				alert("the month for the date is missing");
				document.newList.month.focus();
				return false;
			}
			if (document.newList.day.value == "") {
				alert("the day of the date is missing");
				document.newList.day.focus();
				return false;
			}
			if (document.newList.year.value == "") {
				alert("the year of the date is missing");
				document.newList.year.focus();
				return false;
			}
			if (document.newList.fisherName.value == "") {
				alert("the fisher's name is missing");
				document.newList.fisherName.focus();
				return false;
			}
			return(true);
		}
	</script>
</head>
<body>
<form name="newList" action = "createNewListServlet" onsubmit="return validateInput()" method="post">
	Report Name: <input type ="text" name = "reportName"><br />
	Report date: <input type ="text" name = "month" placeholder="mm"
	size="4"> <input type ="text" name = "day" placeholder="dd"
	size="4">, <input type ="text" name = "year" placeholder="yyyy"
	size="4">
	Fisher Name: <input type = "text" name = "fisherName"><br />
	Available Items:<br />
	<select name="allItemsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allItems}" var="currentitem">
		<option value = "${currentitem.dataID}">${currentitem.fishName} | ${currentitem.fishWeight} | ${currentitem.river}</option>
	</c:forEach>
</select>
	<br />
	<input type = "submit" value="Create List and Add Items">
</form>
<a href = "index.html">Go add new items instead.</a>
</body>
</html>