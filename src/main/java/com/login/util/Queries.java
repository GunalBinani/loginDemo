package com.login.util;

public class Queries {
	 public static final String CREATEQUERY = "create table product (userId number primary key auto_increment, username varchar(20), "
				+ "password varchar(20))";
		
		public static final String INSERTQUERY = "insert into product values(?,?,?)";

}
