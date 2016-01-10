package com.coursor.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

@Entity
@Table(name = "USER_ROLE", uniqueConstraints = @UniqueConstraint(columnNames = { "role", "user_id" }))
public class UserRole extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4480615601501090778L;
	private User user;

	private String role;

	public UserRole() {

	}

	public UserRole(User user, String role) {
		this.user = user;
		this.role = role;
	}

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "ROLE", nullable = false)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
