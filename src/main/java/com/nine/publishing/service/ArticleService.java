package com.nine.publishing.service;

import java.time.LocalDate;
import java.util.List;

import com.nine.publishing.domain.Article;
import com.nine.publishing.service.exception.ArticleInvalidException;

public interface ArticleService {

	List<Article> saveArticle(List<Article> article) throws ArticleInvalidException;

	Article getArticleById(Long id);

	List<Article> getArticlesByDate(LocalDate date);

}
