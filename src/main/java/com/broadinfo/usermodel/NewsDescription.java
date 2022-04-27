package com.broadinfo.usermodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class NewsDescription {

	@Id
	@GeneratedValue
	private int nid;

	private String heading;



	@DateTimeFormat(iso = ISO.DATE)
	private String date;

	private String subject;

	public NewsDescription(String heading, String date, String subject) {
		super();
		this.heading = heading;
		this.date = date;
		this.subject = subject;
	}


	public NewsDescription() {
		super();
	}


	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

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


}
