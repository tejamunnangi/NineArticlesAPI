package com.nine.publishing.domain;

import javax.persistence.Embeddable;

@Embeddable
public class TagId {
	int articleId;
	String tag;
}
