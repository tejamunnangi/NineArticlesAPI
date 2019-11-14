package com.nine.publishing.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nine.publishing.dao.ArticleRepository;
import com.nine.publishing.domain.Article;
import com.nine.publishing.service.ArticleService;
import com.nine.publishing.service.TagService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepo;
	
	@Autowired
	private TagService tagService;
	
	public List<Article> saveArticle(List<Article> articles) {
		for (Article article : articles) {
			article.setDate(LocalDate.now());
			tagService.save(article.getTags());
		}
		return articleRepo.saveAll(articles);
	}

	public Article getArticleById(Long id) {
		return articleRepo.findById(id).orElse(new Article());
	}

	@Override
	public List<Article> getArticlesByDate(LocalDate date) {
		List<Article> articleList = articleRepo.findByDate(date);
		return articleList;
	}

	
}
