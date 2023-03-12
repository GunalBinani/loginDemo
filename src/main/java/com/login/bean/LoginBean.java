package com.login.bean;

import com.opencsv.bean.CsvBindByPosition;

public class LoginBean {
	
		
	@CsvBindByPosition(position=0)
	private int userid;
	@CsvBindByPosition(position=1)
    private String userName;
	@CsvBindByPosition(position=2)
    private String password;
	@CsvBindByPosition(position=3)
    private String uemail;
	@CsvBindByPosition(position=4)
    private long uphone;
	@CsvBindByPosition(position=5)
	private String urole;
	
	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginBean(int userid, String userName, String password, String uemail, long uphone, String urole) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.password = password;
		this.uemail = uemail;
		this.uphone = uphone;
		this.urole = urole;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public long getUphone() {
		return uphone;
	}

	public void setUphone(long uphone) {
		this.uphone = uphone;
	}

	public String getUrole() {
		return urole;
	}

	public void setUrole(String urole) {
		this.urole = urole;
	}

	@Override
	public String toString() {
		return "LoginBean [userid=" + userid + ", userName=" + userName + ", password=" + password + ", uemail="
				+ uemail + ", uphone=" + uphone + ", urole=" + urole + "]";
	}
	
	
	
    
    
	
 
//    public String getUserName() {
//    return userName;
//    }
//    public void setUserName(String userName) {
//    this.userName = userName;
//    }
//    public String getPassword() {
//    return password;
//    }
//    public void setPassword(String password) {
//    this.password = password;
//    }
}