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
@Table(name="QUESTION")
public class Question extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String questionDetail;
	private int seqno;
	private String type;
	private int points;
	private Quiz quiz;
	private List<QuestionChoice> questionChoice;
	
	@Column(name="question_detail")
	public String getQuestionDetail() {
		return questionDetail;
	}
	
	public void setQuestionDetail(String questionDetail) {
		this.questionDetail = questionDetail;
	}
	
	@Column(name="seqno")
	public int getSeqno() {
		return seqno;
	}
	
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	
	@Column(name="type")
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="points")
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quiz_id", nullable = false)
	public Quiz getQuiz() {
		return quiz;
	}
	
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@JsonManagedReference
	@OneToMany(fetch=FetchType.LAZY, mappedBy="question")
	public List<QuestionChoice> getQuestionChoice() {
		return questionChoice;
	}

	public void setQuestionChoice(List<QuestionChoice> questionChoice) {
		this.questionChoice = questionChoice;
	}
}
