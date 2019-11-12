package com.nine.publishing.service;

import java.util.Set;

import com.nine.publishing.domain.Tag;

public interface TagService {

	Set<Tag> save(Set<Tag> tags);

	Tag getTagById(Long id);

}
