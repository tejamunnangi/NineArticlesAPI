package com.nine.publishing.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nine.publishing.domain.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>  {

	List<Article> findByDate(LocalDate date);

}
