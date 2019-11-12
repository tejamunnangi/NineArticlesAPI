package com.nine.publishing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nine.publishing.domain.Tag;
import com.nine.publishing.service.TagService;

@RestController
public class TagRestController {

	@Autowired
	private TagService tagService;
	
	@GetMapping(value = "/tags/{id}", produces = "application/json")
	public Tag getTagById(@PathVariable("id") Long id) {
		return tagService.getTagById(id);
		
	}
}
