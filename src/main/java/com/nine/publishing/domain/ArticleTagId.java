package com.nine.publishing.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ArticleTagId implements Serializable {

	private static final long serialVersionUID = 2875894487612781997L;

	@Column(name = "article_id")
    Long articleId;
 
    @Column(name = "tag")
    String tag;

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
    
    
}
