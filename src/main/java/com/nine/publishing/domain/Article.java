package com.nine.publishing.domain;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Article {
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String title;
	@Column
	private LocalDate date;
	@Column
	private String body;
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "article_tag", 
        joinColumns = { @JoinColumn(name = "article_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "tag") }
    )
	Set<Tag> articleTags;

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

	public Set<Tag> getTags() {
		return articleTags;
	}

	public void setTags(Set<Tag> tags) {
		this.articleTags = tags;
	}

}
