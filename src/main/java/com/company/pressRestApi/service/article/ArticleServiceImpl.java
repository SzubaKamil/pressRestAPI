package com.company.pressRestApi.service.article;

import com.company.pressRestApi.dao.article.ArticleDAO;
import com.company.pressRestApi.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDAO articleDAO;

    @Override
    public List<Article> getAll() {
        return articleDAO.getAll();
    }

    @Override
    public Article getById(int id) {
        return articleDAO.getById(id);
    }

    @Override
    public boolean create(Article article) {
        return articleDAO.create(article);
    }

    @Override
    public boolean update(Article article) {
        return articleDAO.update(article);
    }

    @Override
    public boolean delete(Article article) {
        return articleDAO.delete(article);
    }

    @Override
    public List<Article> searchByContentKeyWord(String keyWord) {
        return articleDAO.searchByContentKeyWord(keyWord);
    }

    @Override
    public List<Article> searchByTitleKeyWord(String keyWord) {
        return articleDAO.searchByTitleKeyWord(keyWord);
    }
}
