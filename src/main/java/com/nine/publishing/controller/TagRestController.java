package com.nine.publishing.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nine.publishing.domain.ArticleTagResponse;
import com.nine.publishing.domain.Tag;
import com.nine.publishing.service.TagService;

@RestController
public class TagRestController {

	@Autowired
	private TagService tagService;
	
	@GetMapping(value = "/tags/{tag}", produces = "application/json")
	public Tag getTagById(@PathVariable("tag") String tag) {
		return tagService.getTagById(tag);
		
	}
	
	@GetMapping(value = "/tags", produces = "application/json")
	public List<Tag> getTags() {
		return tagService.getAllTags();
	}
	
	@GetMapping(value = "/tags/{tagName}/{date}", produces = "application/json")
	public ArticleTagResponse getTagInfo(@PathVariable("tagName") String tagName, @PathVariable("date") String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		return tagService.getTagInfo(tagName, LocalDate.parse(date, formatter));
	}
}
