package com.nine.publishing.domain;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {

	@Id
	private String tag;
	
	@Column
	@JsonIgnore
	private LocalDate updatedDate;
	
	@ManyToMany(mappedBy = "articleTags")
	private Set<Article> articles;
	
	public Tag(String tag) {
		this.tag = tag;
	}
	
	public Tag() {
	}
	
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}
	
}
