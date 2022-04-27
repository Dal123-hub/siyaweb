package com.broadinfo.usermodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class UserInfo {

	@Id
	@GeneratedValue
	private int id;


	private String uname;


	private String upass;

//	@NotBlank(message = "Retype Password is required")
	private String rpass;


	public UserInfo(String name, String pass, String rpass) {

		this.uname = name;
		this.upass = pass;
		this.rpass = rpass;
	}

	public UserInfo() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getRpass() {
		return rpass;
	}

	public void setRpass(String rpass) {
		this.rpass = rpass;
	}


}
