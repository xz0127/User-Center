package com.example.demo.dao;

import com.example.demo.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article, String> {
}
