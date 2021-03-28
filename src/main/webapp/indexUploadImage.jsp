<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP-Servlet Upload Image</title>
</head>
<body>
	<h2>Demo JSP-Servlet Upload Image</h2>
	<form method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/UploadImageServlet">
		Select file to upload:
		<p>
			First name:<input type="text" name="firstName" />
		</p>
		<p>
			Last name:<input type="text" name="lastName" />
		</p>
		<p>
			Select Image: <input type="file" name="photo" size="60" />
		</p>
		<br> <input type="submit" value="Upload" />
	</form>
</body>
</html>