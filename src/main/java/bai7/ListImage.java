package bai7;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/list" })
public class ListImage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=UploadFileServletDB";
	private static final String USER = "sa";
	private static final String PASS = "sapassword";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		String message = null;

		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			conn = DriverManager.getConnection(URL, USER, PASS);
			String sql1 = "select first_name, last_name from contacts";
			PreparedStatement statement = conn.prepareStatement(sql1);

			statement = conn.prepareStatement(sql1);
			ResultSet rs = statement.executeQuery();
			List<Person> persons = new ArrayList<Person>();
			while (rs.next()) {
				Person person = new Person();
				person.setFirstName(rs.getString("first_name"));
				person.setLastName(rs.getString("last_name"));
				persons.add(person);
			}
			req.setAttribute("persons", persons);
			message = "ok";

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
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Connection conn = null;

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");

		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			conn = DriverManager.getConnection(URL, USER, PASS);
			String sql1 = "select photo from contacts where first_name=? and last_name=?";
			PreparedStatement statement = conn.prepareStatement(sql1);
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				byte[] bytes = rs.getBytes("photo");
				resp.getOutputStream().write(bytes);
			}

		} catch (Exception e) {
			System.out.println("=========");
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
				}
			}
		}
	}

}
