package com.coursor.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.sql.Blob;

@Entity
@Table(name="SLIDE")
public class Slide extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7964680145986025713L;

	private String header;
	private String content;
	private String type;
	private int seqno;
	private Topic topic;
	
	@Column(name="header")
	public String getHeader() {
		return header;
	}
	
	public void setHeader(String header) {
		this.header = header;
	}
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topic_id", nullable = false)
	public Topic getTopic() {
		return topic;
	}
	
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Column(name="content")
	@Lob
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Column(name="seqno")
	public int getSeqno() {
		return seqno;
	}

	public void setSeqno(int order) {
		this.seqno = order;
	}
}
