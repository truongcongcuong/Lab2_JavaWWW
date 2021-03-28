<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP-Servlet Upload file</title>
</head>
<body>
	<h2>Demo JSP-Servlet Mail</h2>
	<hr>

	<form action="${pageContext.request.contextPath}/mail" method="post">
		<table>
			<tr>
				<td>From:</td>
				<td><input type="text" name="from" /></td>
			</tr>
			<tr>
				<td>To</td>
				<td><input type="text" name="to" /></td>
			</tr>
			<tr>
				<td>Subject:</td>
				<td><input type="text" name="subject" /></td>
			</tr>
			<tr>
				<td>Content:</td>
				<td><input type="text" name="content" /></td>
			</tr>
			<tr>
				<td>Your Email id:</td>
				<td><input type="text" name="user"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="send" /></td>
			</tr>
		</table>
	</form>
</body>
</html>