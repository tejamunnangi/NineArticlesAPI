package com.nine.publishing.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nine.publishing.domain.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>  {

}
