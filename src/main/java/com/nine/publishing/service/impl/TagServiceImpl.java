package com.nine.publishing.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nine.publishing.dao.TagRepository;
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
			if (tagRepo.findByTag(tag.getTag()).isEmpty()) {
				tagsSaved.add(tagRepo.save(tag));
			}
		}
		return tagsSaved;
	}

	@Override
	public Tag getTagById(Long id) {
		return tagRepo.findById(id).orElse(new Tag());
	}

}
