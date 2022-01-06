package com.example.demo.service;

import com.example.demo.pojo.Article;
import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.rpcDomain.req.ArticleRequest;

import java.util.List;

public interface ArticleService extends BaseService<Article, String> {

    RespResult publishArticle(ArticleRequest req, String userId);

    RespResult updateArticleByAuthor(ArticleRequest req, String userId);

    RespResult deleteArticleByArticleId(String id);

    RespResult showSingleArticle(ArticleRequest req);

    List<Article> getRecentPublishedArticles();
}

