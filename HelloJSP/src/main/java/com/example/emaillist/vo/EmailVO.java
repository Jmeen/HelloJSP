package com.example.emaillist.vo;

import java.util.Date;

public class EmailVO {

	// 필드
	private Long no;
	private String last_name;
	private String first_name;
	private String email;
	private Date createdAt;

	// Getter /setter

	public EmailVO(Long no, String last_name, String first_name, String email, Date createdAt) {
		this.no = no;
		this.last_name = last_name;
		this.first_name = first_name;
		this.email = email;
		this.createdAt = createdAt;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
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
		return "EmailVO [no=" + no + ", last_name=" + last_name + ", first_name=" + first_name + ", email=" + email
				+ ", createdAt=" + createdAt + "]";
	}

}
