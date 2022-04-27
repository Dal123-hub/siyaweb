package com.broadinfo.controller.dto;

import javax.validation.constraints.NotBlank;

public class NewsDescriptionDto {

	@NotBlank(message = "heading is required")
	private String heading ;

	@NotBlank(message = "Date is required")
	private String date;

	@NotBlank(message = "Subject is required")
	private String subject;

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public NewsDescriptionDto(String heading, String date, String subject) {
		super();
		this.heading = heading;
		this.date = date;
		this.subject = subject;
	}

}
