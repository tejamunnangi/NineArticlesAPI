package com.nine.publishing.service;

import java.util.List;

import com.nine.publishing.domain.Article;

public interface ArticleService {

	List<Article> saveArticle(List<Article> article);

}
