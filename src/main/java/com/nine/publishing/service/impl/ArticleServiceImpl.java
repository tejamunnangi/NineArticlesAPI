package com.nine.publishing.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nine.publishing.dao.ArticleRepository;
import com.nine.publishing.domain.Article;
import com.nine.publishing.service.ArticleService;
import com.nine.publishing.service.TagService;
import com.nine.publishing.service.exception.ArticleInvalidException;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepo;
	
	@Autowired
	private TagService tagService;
	
	public List<Article> saveArticle(List<Article> articles) throws ArticleInvalidException {
		for (Article article : articles) {
			if (article.getTitle() == null) {
				throw new ArticleInvalidException("The submitted article is not valid");
			}
			article.setDate(LocalDate.now());
			if (article.getTags() != null && !article.getTags().isEmpty()) {
				tagService.save(article.getTags());
			}
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
