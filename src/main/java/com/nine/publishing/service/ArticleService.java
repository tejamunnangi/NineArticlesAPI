package com.nine.publishing.service;

import java.util.List;

import com.nine.publishing.domain.Article;

public interface ArticleService {

	Article saveArticle(List<Article> article);

}
