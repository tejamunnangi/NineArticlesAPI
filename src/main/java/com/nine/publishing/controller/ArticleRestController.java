package com.nine.publishing.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ResponseEntity<?> createArticle(@RequestBody Article article) {
		if (article.getTitle() != null) {
			List<Article> articles = articleService.saveArticle(Arrays.asList(article));
			return new ResponseEntity<>(articles, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@GetMapping(value = "/articles/{id}", produces = "application/json")
	public Article getArticleById(@PathVariable("id") Long id) {
		return articleService.getArticleById(id);
		
	}
}
