package com.login.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import com.login.bean.LoginBean;

public class CsvToObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filname ="C:\\Users\\gbinani\\Training\\csvdemofile.csv";
		try {
			List<LoginBean> beans = new CsvToBeanBuilder<LoginBean>(new FileReader(filname))
					.withType(LoginBean.class)
					.build()
					.parse();
			for(LoginBean user: beans) {
				System.out.println(user);
			}
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
