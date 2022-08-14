package com.company.pressRestApi.controller;

import com.company.pressRestApi.entity.Article;
import com.company.pressRestApi.exception.ArticleCreateException;
import com.company.pressRestApi.exception.ArticleDeleteException;
import com.company.pressRestApi.exception.ArticleNotFoundException;
import com.company.pressRestApi.exception.ArticleUpdateException;
import com.company.pressRestApi.service.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> getArticles (){
        return articleService.getAll();
    }

    @GetMapping("/articles/{id}")
    public Article getArticle (@PathVariable int id){
        Article article = articleService.getById(id);

        if(article == null){
            throw new ArticleNotFoundException("Article id not found - " + id);
        }

        return article;
    }

    @GetMapping("/articles/content/{content}")
    public List<Article> getArticlesByContent (@PathVariable String content){

        return articleService.searchByContentKeyWord(content);
    }

    @GetMapping("/articles/title/{title}")
    public List<Article> getArticlesByTitle (@PathVariable String title){

        return articleService.searchByTitleKeyWord(title);
    }

    @PostMapping("/articles")
    public Article addArticle (@RequestBody Article article){
        article.setId(0);

        if (!articleService.create(article)){
            throw  new ArticleCreateException("Can not add article to database - "  + article);
        }

        return  article;
    }

    @PutMapping("/articles")
    public Article updateArticle (@RequestBody Article article){
        boolean updated = false;
        try {
            updated = articleService.update(article);
        }
        catch (ConcurrencyFailureException ignored) {

        }
        finally {
            if (!updated){
                throw  new ArticleUpdateException("Can not update article in database - "  + article);
            }
        }
        return  article;
    }

    @DeleteMapping("/articles/{id}")
    public String deleteArticle (@PathVariable int id){
        Article article = articleService.getById(id);

        if (article == null){
            throw new ArticleNotFoundException("Article id not found - " + id);
        }

        if (!articleService.delete(article)){
            throw  new ArticleDeleteException("Can not add article to database - "  + article);
        }

        return "Deleted article id - " + id;
    }

}
