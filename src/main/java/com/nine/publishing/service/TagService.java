package com.nine.publishing.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.nine.publishing.domain.ArticleTagResponse;
import com.nine.publishing.domain.Tag;

public interface TagService {

	Set<Tag> save(Set<Tag> tags);

	Tag getTagById(String tag);

	List<Tag> getAllTags();

	List<ArticleTagResponse> getTagInfo(String tagName, LocalDate date);

}
