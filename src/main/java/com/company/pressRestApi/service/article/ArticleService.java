package com.company.pressRestApi.service.article;

import com.company.pressRestApi.entity.Article;
import com.company.pressRestApi.service.CrudService;

import java.util.List;

public interface ArticleService extends CrudService<Article> {
    List<Article> searchByContentKeyWord (String keyWord);
    List<Article> searchByTitleKeyWord (String keyWord);
}
