package com.nine.publishing.controller;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.nine.publishing.Application;
import com.nine.publishing.domain.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@Transactional
@TestPropertySource(
		  locations = "classpath:application-test.properties")
public class ArticleRestControllerTest extends AbstractTest {
	
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void createArticleWithNoTitleTest() throws Exception {
		String uri = "/articles";
		Article article = new Article();
		String inputJson = super.mapToJson(article);
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(422, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "The submitted article is not valid");
	}
	
	@Test
	public void createArticleSuccessTest() throws Exception {
		String uri = "/articles";
		Article article = new Article();
		article.setTitle("Title");
		String inputJson = super.mapToJson(article);
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		List<Article> articleList = mapFromJson(content, List.class);
		assertEquals(articleList.size(), 1);
		assertTrue(articleList.stream().findFirst().get().getTitle().equals("Title"));
	}
	
	@Test
	public void getArticleByIdTest() throws Exception {
		String uri = "/articles/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
			      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);
		assertTrue(content.isEmpty());
	}
}