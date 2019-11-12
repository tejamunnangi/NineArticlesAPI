package com.nine.publishing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nine.publishing.dao.ArticleRepository;
import com.nine.publishing.domain.Article;
import com.nine.publishing.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepo;
	
	public List<Article> saveArticle(List<Article> articles) {
		return articleRepo.saveAll(articles);
	}

	public Article getArticleById(Long id) {
		return articleRepo.findById(id).orElse(new Article());
	}

	
}
