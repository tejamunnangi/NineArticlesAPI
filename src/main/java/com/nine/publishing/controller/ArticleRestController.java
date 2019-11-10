package com.nine.publishing.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nine.publishing.domain.Article;
import com.nine.publishing.service.ArticleService;

@RestController
public class ArticleRestController {

	@Autowired
	private ArticleService articleService;

	@PostMapping(value = "/articles", consumes = "application/json", produces = "application/json")
	public List<Article> createArticle(@RequestBody Article article) {
		return articleService.saveArticle(Arrays.asList(article));
	}
}
