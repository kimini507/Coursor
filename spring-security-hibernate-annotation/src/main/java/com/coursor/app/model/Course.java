package com.coursor.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="COURSE")
public class Course extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5789790916383097673L;

	private String code;
	private String title;
	private String description;
	private List<Topic> topics;
//	private List<User> users;
	
	@Column(name="code")
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, mappedBy="course")
	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

//	@ManyToMany(cascade={CascadeType.ALL})
//	@JoinTable(name="USER_COURSE", joinColumns={@JoinColumn(name="USER_ID")})
//	public List<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
}
