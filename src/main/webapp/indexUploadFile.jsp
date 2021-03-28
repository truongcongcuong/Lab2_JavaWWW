<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP-Servlet Upload file</title>
</head>
<body>
	<h2>Demo JSP-Servlet Upload File</h2>
	<form method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/UploadFileServlet">
		Select file to upload:
		<p>
			<input type="file" name="file1" size="60" />
		</p>
		<p>
			<input type="file" name="file2" size="60" />
		</p>
		<p>
			<input type="file" name="file3" size="60" />
		</p>
		<p>
			<input type="file" name="file4" size="60" />
		</p>
		<p>
			<input type="file" name="file5" size="60" />
		</p>
		<br> <input type="submit" value="Upload" />
	</form>
</body>
</html>