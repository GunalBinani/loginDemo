package com.login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.login.bean.LoginBean;

public class Dbconnection {

	 static Connection connection;
	Connection conn = null;
	Statement stmt = null;

	public Dbconnection() {
		System.out.println("inside Db constructor");
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
			String username = "gbinani";
			String password = "gbinY7)hK$Lo(";
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Conection is created successfully");
			stmt = conn.createStatement();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static Connection openConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		  String url = "jdbc:oracle:thin:@192.168.18.40:1521:ASCEND";
		    String username = "gbinani";
		    String password = "gbinY7)hK$Lo(";  
		try {
			connection = DriverManager.getConnection(url,username,password);
			Statement statement = connection.createStatement();
		//statement.execute(Queries.CREATEQUERY);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void closeConnection() {
		try {
			
			if(connection!=null)
				connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertUsers(List<LoginBean> userlist) throws SQLException {
		System.out.println("inserting users...");
		for (LoginBean bean : userlist) {
			try {
				PreparedStatement ps =

						conn.prepareStatement("insert into users " +

								"(userid,username,password,email,phone,role) " +

								"values (?, ?, ?, ?, ?, ?)");

				try {
					ps.setInt(1, bean.getUserid());
					ps.setString(2, bean.getUserName());
					ps.setString(3, bean.getPassword());
					ps.setString(4, bean.getUemail());
					ps.setLong(5, bean.getUphone());
					ps.setString(6, bean.getUrole());
					System.out.println("executing ps now");
					ps.executeUpdate();
					conn.close();
					System.out.println("executing ps done");

				} finally {

					ps.close();

				}

//				String insertOC = "insert into users(userid,username,password,email,phone,role)" 
//				+ "values("
//						+ bean.getUserid() + ",'" + bean.getUserName() + "','" + bean.getPassword() + "','"
//						+ bean.getUemail() + "'," + bean.getUphone() + ",'" + bean.getUrole() + "')";
//
//				System.out.println("insert oc ::" + insertOC);
//				int output = stmt.executeUpdate(insertOC);
//				System.out.println("output : " +output);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			finally {
				conn.close();
			}
//				try {
//					if (stmt != null)
//						conn.close();
//				} catch (SQLException e) {
//					System.out.println(e.getMessage());
//				}
//				try {
//					if (conn != null)
//						conn.close();
//				} catch (SQLException e) {
//					System.out.println(e.getMessage());
//				}
//			}
		}
	}

}