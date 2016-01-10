package com.coursor.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="TOPIC")
public class Topic extends BaseBean {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1903355507655086293L;

	private int seqno;
	private String header;
	private String description;
	private List<Slide> slides;
	private Course course;

	@Column(name="header")
	public String getHeader() {
		return header;
	}
	
	public void setHeader(String header) {
		this.header = header;
	}
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
		
	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, mappedBy="topic")
	public List<Slide> getSlides() {
		return slides;
	}
	
	public void setSlides(List<Slide> slides) {
		this.slides = slides;
	}
		
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id", nullable = false)
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name = "seqno", nullable = false)
	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int order) {
		this.seqno = order;
	}
}
