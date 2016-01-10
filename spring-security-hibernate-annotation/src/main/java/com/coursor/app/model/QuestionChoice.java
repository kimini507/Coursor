package com.coursor.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="QUESTION_CHOICE")
public class QuestionChoice extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2206172741740914009L;

	private int seqno;
	private String choiceDetail;
	private int points;
	private Question question;
	
	@Column(name="seqno")
	public int getSeqno() {
		return seqno;
	}
	
	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}
	
	@Column(name="choice_detail")
	public String getChoiceDetail() {
		return choiceDetail;
	}
	
	public void setChoiceDetail(String choiceDetail) {
		this.choiceDetail = choiceDetail;
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
	@JoinColumn(name = "question_id", nullable = false)
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
}
