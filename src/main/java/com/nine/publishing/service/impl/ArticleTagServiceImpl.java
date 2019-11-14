package com.nine.publishing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nine.publishing.dao.ArticleTagRepo;
import com.nine.publishing.domain.ArticleTags;
import com.nine.publishing.service.ArticleTagService;

@Service
public class ArticleTagServiceImpl implements ArticleTagService {

	@Autowired
	private ArticleTagRepo articleTagRepo;
	@Override
	public List<ArticleTags> findByArticleIdsAndTagName(List<Long> articleIds, String tagName) {
		return articleTagRepo.findByArticleIdsAndTagName(articleIds, tagName);
	}
	@Override
	public List<ArticleTags> findByArticleIds(List<Long> articleIds) {
		return articleTagRepo.findByArticleIds(articleIds);
	}

}
