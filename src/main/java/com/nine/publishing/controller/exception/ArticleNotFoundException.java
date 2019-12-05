package com.nine.publishing.controller.exception;

public class ArticleNotFoundException extends Exception {

	private static final long serialVersionUID = -16581112419290442L;
	
	public ArticleNotFoundException(String message) {
		super(message);
	}
}
