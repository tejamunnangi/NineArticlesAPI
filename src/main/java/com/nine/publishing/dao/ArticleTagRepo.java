package com.nine.publishing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nine.publishing.domain.ArticleTagId;
import com.nine.publishing.domain.ArticleTags;

@Repository
public interface ArticleTagRepo extends JpaRepository<ArticleTags, ArticleTagId> {

	@Query(value = "SELECT * from article_tag where article_id in :articleId and tag = :tag", nativeQuery = true)
	List<ArticleTags> findByArticleIdsAndTagName(@Param("articleId") List<Long> articleId, @Param("tag") String tagName);

	@Query(value = "SELECT * from article_tag where article_id in :articleId", nativeQuery = true)
	List<ArticleTags> findByArticleIds(@Param("articleId") List<Long> articleIds);

}
