package com.nine.publishing.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Article implements Serializable {
	private static final long serialVersionUID = -7937993487047663283L;
	private Long id;
	private String title;
	private LocalDate date;
	private String body;
	private List<String> tags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
