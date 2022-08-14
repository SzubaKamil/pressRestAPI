package com.company.pressRestApi.exception;

public class ArticleNotFoundException extends RuntimeException {

    public ArticleNotFoundException(String message) {
        super(message);
    }
}
