package bai7;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = { "/UploadImageServlet" })
@MultipartConfig
public class FileUploadDBServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int BUFFER_SIZE = 4096;
	private static final String SAVE_DIR = "images";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=UploadFileServletDB";
	private static final String USER = "sa";
	private static final String PASS = "sapassword";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("indexUploadImage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");

		InputStream inputStream = null;
		Part filePart = req.getPart("photo");
		String fileUploadName = "";
		if (filePart != null) {
			fileUploadName = filePart.getName();
			inputStream = filePart.getInputStream();
		}

		Connection conn = null;
		String message = null;

		String filePath = "d:\\" + SAVE_DIR + "\\" + fileUploadName + ".jpg";

		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			conn = DriverManager.getConnection(URL, USER, PASS);
			String sql = "insert into contacts(first_name, last_name, photo) values(?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			if (inputStream != null) {
				statement.setBlob(3, inputStream);
			}
			int row = statement.executeUpdate();
			if (row > 0) {
				message = "thêm thành công vào database";
			}

			/*
			 * String sql1 =
			 * "select photo from contacts where first_name=? and last_name=?"; statement =
			 * conn.prepareStatement(sql1); statement.setString(1, firstName);
			 * statement.setString(2, lastName); ResultSet rs = statement.executeQuery(); if
			 * (rs.next()) { Blob blob = rs.getBlob("photo"); inputStream =
			 * blob.getBinaryStream(); OutputStream outputStream = new
			 * FileOutputStream(filePath);
			 * 
			 * int byteRead = -1; byte[] buffer = new byte[BUFFER_SIZE];
			 * 
			 * while ((byteRead = inputStream.read(buffer)) != -1) {
			 * outputStream.write(buffer, 0, byteRead); } inputStream.close();
			 * outputStream.close(); }
			 */

		} catch (Exception e) {
			message = "error: " + e.getMessage();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
				}
			}
		}
		req.setAttribute("message", message);
		req.getRequestDispatcher("resultUploadImage.jsp").forward(req, resp);

	}

}
