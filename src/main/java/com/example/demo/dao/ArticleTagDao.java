package com.example.demo.dao;

import com.example.demo.pojo.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleTagDao extends JpaRepository<ArticleTag, String> {

    @Query("delete from ArticleTag where articleId = ?1")
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    void deleteAllTagByArticleId(@Param("articleId") String id);

    List<ArticleTag> findByArticleId(String articleId);

    @Query("select tagName from ArticleTag where articleId =?1")
    List<String> findTagNameByArticleId(@Param("articleId") String articleId);
}
