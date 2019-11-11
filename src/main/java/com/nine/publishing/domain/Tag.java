package com.nine.publishing.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(TagId.class)
public class Tag {

	@Id
	private Long articleId;
	
	@Id
	private String tag;
	
	@ManyToOne
    private Article article;
}
