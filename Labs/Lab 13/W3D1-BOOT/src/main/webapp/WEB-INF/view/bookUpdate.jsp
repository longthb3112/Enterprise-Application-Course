<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Update a Book</title>
</head>

<body>

		<form:form modelAttribute="book" action="update" method="post">
			<form:errors path="*" cssClass="errorblock" element="div" />
			<table>
				<tr>
					<td>Id:</td>
					<td><form:input path="id" readonly="true"/> </td>
					<td><form:errors path="id" cssClass="error" /> </td>
				</tr>
				<tr>
					<td>ISBN:</td>
					<td><form:input path="ISBN" /> </td>
					<td><form:errors path="ISBN" cssClass="error" /> </td>

				</tr>
				<tr>
					<td>Title:</td>
					<td><form:input path="title" /> </td>
					<td><form:errors path="title" cssClass="error" /> </td>
				</tr>
				<tr>
					<td>Author:</td>
					<td><form:input path="author" /> </td>
					<td><form:errors path="author" cssClass="error" /> </td>
				</tr>
				<tr>
					<td>Price:</td>
					<td><form:input path="price" /> </td>
					<td><form:errors path="price" cssClass="error" /> </td>
				</tr>
			</table>
			<input type="submit" />
		</form:form>


</body>
<form:form action="delete?bookId=${book.id}" method="post">
	<button type="submit">Delete</button>
</form:form>


</html>