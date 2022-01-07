package com.example.userCenter.dao;

import com.example.userCenter.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article, String> {
}
