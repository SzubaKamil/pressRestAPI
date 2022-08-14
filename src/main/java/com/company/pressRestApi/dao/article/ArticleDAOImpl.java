package com.company.pressRestApi.dao.article;

import com.company.pressRestApi.dao.Crud;
import com.company.pressRestApi.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;

@Repository
public class ArticleDAOImpl extends Crud<Article> implements ArticleDAO {

    @Autowired
    public ArticleDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<Article> getAll() {
        List<Article> articles = getAll("Article", Article.class);

        // in the case of a large database, a query to the database with a sort parameter
        articles.sort(Comparator.comparing(Article::getDatePublication));

        return articles;
    }

    @Override
    public Article getById(int id) {
        return getById(id, Article.class);
    }

    @Override
    public boolean create(Article article) {
        return super.create(article);
    }

    @Transactional
    @Override
    public boolean update(Article article) {
        return super.update(article);
    }

    @Override
    public boolean delete(Article article) {
        return super.delete(article);
    }

    @Override
    public List<Article> searchByContentKeyWord(String keyWord) {
        return searchByParameter(entityManager, Article.class, "Article", "content", keyWord);
    }

    @Override
    public List<Article> searchByTitleKeyWord(String keyWord) {
        return searchByParameter(entityManager, Article.class, "Article", "title", keyWord);
    }
}
