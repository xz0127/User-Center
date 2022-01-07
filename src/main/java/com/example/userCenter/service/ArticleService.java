package com.example.userCenter.service;

import com.example.userCenter.pojo.Article;
import com.example.userCenter.rpcDomain.common.RespResult;
import com.example.userCenter.rpcDomain.req.ArticleRequest;

import java.util.List;

public interface ArticleService extends BaseService<Article, String> {

    RespResult publishArticle(ArticleRequest req, String userId);

    RespResult updateArticleByAuthor(ArticleRequest req, String userId);

    RespResult deleteArticleByArticleId(String id);

    RespResult showSingleArticle(ArticleRequest req);

    List<Article> getRecentPublishedArticles();
}

