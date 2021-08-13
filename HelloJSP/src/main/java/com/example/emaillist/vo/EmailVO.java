package com.example.emaillist.vo;

import java.util.Date;

public class EmailVO {

	// 필드
	private Long no;
	private String lastname;
	private String firstname;
	private String email;
	private Date createdAt;

	// Getter /setter
	public EmailVO() {
		
	}

	public EmailVO(Long no, String last_name, String first_name, String email, Date createdAt) {
		this.no = no;
		this.lastname = last_name;
		this.firstname = first_name;
		this.email = email;
		this.createdAt = createdAt;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String last_name) {
		this.lastname = last_name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String first_name) {
		this.firstname = first_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "EmailVO [no=" + no + ", last_name=" + lastname + ", first_name=" + firstname + ", email=" + email
				+ ", createdAt=" + createdAt + "]";
	}

}
