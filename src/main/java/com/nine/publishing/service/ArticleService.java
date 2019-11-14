package com.nine.publishing.service;

import java.time.LocalDate;
import java.util.List;

import com.nine.publishing.domain.Article;

public interface ArticleService {

	List<Article> saveArticle(List<Article> article);

	Article getArticleById(Long id);

	List<Article> getArticlesByDate(LocalDate date);

}
