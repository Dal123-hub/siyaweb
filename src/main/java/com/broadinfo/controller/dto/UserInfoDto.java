package com.broadinfo.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserInfoDto {

	@NotBlank(message = "User name is reqired")
	@Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$",
	 message = "User name should be aleast 3-character Not start with dot(.),hyphen(_)and underscore(-)")
	private String uname;

	@NotBlank(message = "Password is required")
	@Size(min=8, message="Password must be atleast 8-chacters")
	private String upass;

	private String rpass;

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

	public UserInfoDto(String uname, String upass, String rpass) {
		super();
		this.uname = uname;
		this.upass = upass;
		this.rpass = rpass;
	}



}
