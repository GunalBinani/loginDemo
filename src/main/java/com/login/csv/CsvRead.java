package com.login.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.bean.LoginBean;
import com.login.util.Dbconnection;
import com.opencsv.CSVReader;

public class CsvRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<LoginBean> userList = getUserDetails("C:\\Users\\gbinani\\Training\\employee.csv");
		for(LoginBean bean :userList) {
			System.out.println(bean);
		}
	
	Dbconnection db = new Dbconnection();
	
	try {
		db.insertUsers(userList);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
		private static List<LoginBean> getUserDetails(String file){
			List<LoginBean> userlist = new ArrayList<>();
			Path pathToFile = Paths.get(file);			  
			try(BufferedReader br = Files.newBufferedReader(pathToFile)){
				String row = br.readLine();
				while(row!=null) {
					String[] attributes = row.split(",");
					LoginBean bean = getOneUser(attributes);
					userlist.add(bean);
					row=br.readLine();
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return userlist;
		}

		
		private static LoginBean getOneUser(String[] attributes) {
			int userid;
			long uphone;
			String username, password,uemail,urole;
			try {
				userid = Integer.parseInt(attributes[0]);
			}
			catch(Exception e){userid=0;}
			try {
				username = (attributes[1]);
			}
			catch(Exception e){username=null;}
			try {
				password = (attributes[2]);
			}
			catch(Exception e){password=null;}
			try {
				uemail = (attributes[3]);
			}
			catch(Exception e){uemail=null;}
			try {
				uphone = Long.parseLong(attributes[4]);
			}
			catch(Exception e){uphone=0;}
			try {
				urole = (attributes[5]);
			}
			catch(Exception e){urole=null;}
			
//			 userid = Integer.parseInt(attributes[0]);
//			 username = attributes[1];
//			 password = attributes[2];
//			 uemail = attributes[3];
//			 uphone = Long.parseLong(attributes[4]);
//			 urole = attributes[5];
			LoginBean bean = new LoginBean(userid,username,password,uemail,uphone,urole) ;
			return bean;
		}
	}

	

	
//try(FileReader fileReader = new FileReader(filename);
//CSVReader csvReader = new CSVReader(fileReader);){
//List<String[]> userlist = csvReader.readAll();
//for(String[] userarr: userlist) {
//	for(String userstr:userarr) {
//		System.out.print(userstr + " \t");
//	}
//	System.out.println();
//}
//
//}catch(Exception e){
//e.printStackTrace();
//}
//}
