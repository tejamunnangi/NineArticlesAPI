package com.nine.publishing.service;

import java.util.List;

import com.nine.publishing.domain.ArticleTags;


public interface ArticleTagService {

	public List<ArticleTags> findByArticleIdsAndTagName(List<Long> articleIds, String tagName);

	public List<ArticleTags> findByArticleIds(List<Long> articleIds);

}
