<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP-Servlet Upload file</title>
</head>
<body>
	<table style="width: 40%">
		<tr>
			<th>First name</th>
			<th>Last name</th>
			<th>Image</th>
		</tr>
		<c:forEach var="p" items="${persons}">
			<tr>
				<td>${p.firstName}</td>
				<td>${p.lastName}</td>
				<td>
					<form action="${pageContext.request.contextPath }/list"
						method="post">
						<input type="hidden" name="firstName" value="${p.firstName}">
						<input type="hidden" name="lastName" value="${p.lastName}">
						<input type="submit" value="image">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>