package com.nine.publishing.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleTagResponse implements Serializable {
	private static final long serialVersionUID = 8882227507240545211L;
	@JsonProperty("tag")
	private String tagName;
	@JsonProperty("count")
	private int tagCount;
	@JsonProperty("articles")
	private List<Long> articles;
	@JsonProperty("related_tags")
	private Set<String> relatedTags;
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public int getTagCount() {
		return tagCount;
	}
	public void setTagCount(int tagCount) {
		this.tagCount = tagCount;
	}
	public List<Long> getArticles() {
		return articles;
	}
	public void setArticles(List<Long> articles) {
		this.articles = articles;
	}
	public Set<String> getRelatedTags() {
		return relatedTags;
	}
	public void setRelatedTags(Set<String> relatedTags) {
		this.relatedTags = relatedTags;
	}
	
}
