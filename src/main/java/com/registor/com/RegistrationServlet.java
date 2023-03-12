package com.registor.com;

import java.io.IOException; 
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("pass");
		String umobile = request.getParameter("contact");
		//PrintWriter out = response.getWriter();
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.40:1521:ASCEND?useSSL=false","gbinani","gbinY7)hK$Lo(");
			PreparedStatement pst = con.prepareStatement("insert into users values(?,?,?,?,?,?)");
		     pst.setInt(1,16 );
			pst.setString(2, uname);
			pst.setString(3, upwd);
			pst.setString(4, uemail);
			pst.setString(5, umobile);
			pst.setString(6, "User");
			RequestDispatcher dispatcher = null;
			int rowcount=pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp"); 
			if(rowcount>0) {
				request.setAttribute("status", "success");
			}else {
				request.setAttribute("status", "failed");

			}
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		
		}
	}

}
