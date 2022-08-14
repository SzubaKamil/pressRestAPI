package com.company.pressRestApi.dao.article;

import com.company.pressRestApi.dao.CrudDAO;
import com.company.pressRestApi.dao.SearchDAO;
import com.company.pressRestApi.entity.Article;

import java.util.List;

public interface ArticleDAO extends CrudDAO<Article>, SearchDAO<Article> {
    List<Article> searchByContentKeyWord(String keyWord);

    List<Article> searchByTitleKeyWord(String keyWord);
}
