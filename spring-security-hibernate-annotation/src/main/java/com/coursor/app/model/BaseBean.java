package com.coursor.app.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6370447895930167584L;

	private Long id;
	
	private Date createDate;
	
	private Date lastModDate = null;
	
	private Long lastModBy;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="create_dt")
	public Date getCreateDate() {
		if(createDate == null){
			createDate = new Date(System.currentTimeMillis());
		}
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name="last_mod_dt")
	public Date getLastModDate() {
		if(lastModDate == null){
			lastModDate = new Date(System.currentTimeMillis());
		}
		return lastModDate;
	}

	public void setLastModDate(Date lastModDate) {
		this.lastModDate = lastModDate;
	}

	@Column(name="last_mod_by")
	public Long getLastModBy() {
		return lastModBy;
	}

	public void setLastModBy(Long lastModBy) {
		this.lastModBy = lastModBy;
	}
}
