package com.nine.publishing.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "article_tag")
public class ArticleTags {
 
    @EmbeddedId
    ArticleTagId id;
 
    @ManyToOne
    @MapsId("article_id")
    @JoinColumn(name = "article_id")
    Article article;
 
    @ManyToOne
    @MapsId("tag")
    @JoinColumn(name = "tag")
    Tag tag;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public ArticleTagId getId() {
		return id;
	}
 
}
