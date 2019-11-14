package com.nine.publishing.service.impl;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nine.publishing.dao.TagRepository;
import com.nine.publishing.domain.Article;
import com.nine.publishing.domain.ArticleTagId;
import com.nine.publishing.domain.ArticleTagResponse;
import com.nine.publishing.domain.Tag;
import com.nine.publishing.domain.ArticleTags;
import com.nine.publishing.service.ArticleService;
import com.nine.publishing.service.ArticleTagService;
import com.nine.publishing.service.TagService;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagRepository tagRepo;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private ArticleTagService articleTagService;
	
	@Override
	public Set<Tag> save(Set<Tag> tags) {
		Set<Tag> tagsSaved = new HashSet<>();
		for (Tag tag : tags) {
			if (!tagRepo.findById(tag.getTag()).isPresent()) {
				tag.setUpdatedDate(LocalDate.now());
				tagsSaved.add(tagRepo.save(tag));
			}
		}
		return tagsSaved;
	}

	@Override
	public Tag getTagById(String tag) {
		return tagRepo.findById(tag).orElse(new Tag());
	}

	@Override
	public List<Tag> getAllTags() {
		return tagRepo.findAll();
	}

	@Override
	public ArticleTagResponse getTagInfo(String tagName, LocalDate date) {
		List<Article> articlesByDate = articleService.getArticlesByDate(date);
		List<Long> articleIds = articlesByDate.stream().map(Article::getId).collect(Collectors.toList());
		List<ArticleTags> articleTags = articleTagService.findByArticleIdsAndTagName(articleIds, tagName);
		List<Long> relatedArticles = articleTags.stream().map(ArticleTags::getId).map(ArticleTagId::getArticleId).collect(Collectors.toList());
		List<ArticleTags> relatedTags = articleTagService.findByArticleIds(relatedArticles);
		Set<String> relatedTagIds = new HashSet<String>(relatedTags.stream().map(ArticleTags::getId).map(ArticleTagId::getTag).filter(t -> !t.equals(tagName)).collect(Collectors.toList()));
		ArticleTagResponse articleTagResponse = new ArticleTagResponse();
		articleTagResponse.setTagCount(articleTags.size());
		articleTagResponse.setArticles(relatedArticles);
		articleTagResponse.setTagName(tagName);
		articleTagResponse.setRelatedTags(relatedTagIds);
		return articleTagResponse;
	}
	
}
