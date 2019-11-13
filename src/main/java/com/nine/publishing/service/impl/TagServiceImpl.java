package com.nine.publishing.service.impl;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nine.publishing.dao.TagRepository;
import com.nine.publishing.domain.ArticleTagResponse;
import com.nine.publishing.domain.Tag;
import com.nine.publishing.service.TagService;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagRepository tagRepo;
	
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
	public List<ArticleTagResponse> getTagInfo(String tagName, LocalDate date) {
		return null;
	}
	
}
