package com.coursor.app.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="QUIZ")
public class Quiz extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6846312650003818347L;

	private int maxAttempts;
	private int passingScore;
	private Date dueDate;
	private int slideId;
	private List<Question> questions;
	
	@Column(name="max_attempts")
	public int getMaxAttempts() {
		return maxAttempts;
	}
	
	public void setMaxAttempts(int maxAttempts) {
		this.maxAttempts = maxAttempts;
	}
	
	@Column(name="passing_score")
	public int getPassingScore() {
		return passingScore;
	}
	
	public void setPassingScore(int passingScore) {
		this.passingScore = passingScore;
	}
	
	@Column(name="due_dt")
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	@Column(name="slide_id")
	public int getSlideId() {
		return slideId;
	}

	public void setSlideId(int slideId) {
		this.slideId = slideId;
	}

	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, mappedBy="quiz")
	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
