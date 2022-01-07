package com.example.userCenter.service.impl;

import com.example.userCenter.common.utils.UUIDUtils;
import com.example.userCenter.dao.ArticleDao;
import com.example.userCenter.dao.ArticleTagDao;
import com.example.userCenter.pojo.Article;
import com.example.userCenter.pojo.ArticleTag;
import com.example.userCenter.rpcDomain.common.RespResult;
import com.example.userCenter.rpcDomain.common.ResultCode;
import com.example.userCenter.rpcDomain.req.ArticleRequest;
import com.example.userCenter.rpcDomain.resp.ArticleResp;
import com.example.userCenter.service.ArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl extends BaseServiceImpl<Article, String>
        implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleTagDao articleTagDao;

    @Override
    public RespResult publishArticle(ArticleRequest req, String userId) {
//        List<String> validateMsg = BeanUtil.validateProperty(req, "id");
//        if (validateMsg.size() > 0) {
//            return new RespResult(ResultCode.PARAM_IS_BLANK, validateMsg);
//        }

        Article article = new Article();
        BeanUtils.copyProperties(req, article);
        article.setUserId(userId);
        article.setId(UUIDUtils.get());
        article.setPublishTime(new Timestamp(req.getPublishTime().getTime()));

        if (req.getArticleTagList() != null) {
            ArticleTag articleTag;
            for (String tagName : req.getArticleTagList()) {
                articleTag = new ArticleTag();
                articleTag.setId(UUIDUtils.get());
                articleTag.setTagName(tagName);
                articleTag.setArticleId(article.getId());
                articleTagDao.save(articleTag);
            }
        }

        articleDao.save(article);
        return new RespResult(ResultCode.SUCCESS, article.getId());
    }

    @Override
    public RespResult updateArticleByAuthor(ArticleRequest req, String userId) {
        if (req.getId() == null) {
            return new RespResult(ResultCode.PARAM_IS_BLANK, "id cannot be empty");
        }
        Article article = new Article();
        BeanUtils.copyProperties(req, article);
        article.setUserId(userId);
        article.setPublishTime(new Timestamp(req.getPublishTime().getTime()));

        articleTagDao.deleteAllTagByArticleId(article.getId());

        if (req.getArticleTagList() != null) {
            ArticleTag articleTag;
            for (String tagName : req.getArticleTagList()) {
                articleTag = new ArticleTag();
                articleTag.setId(UUIDUtils.get());
                articleTag.setTagName(tagName);
                articleTag.setArticleId(article.getId());
                articleTagDao.save(articleTag);
            }
        }

        articleDao.save(article);
        return new RespResult(ResultCode.SUCCESS);
    }

    @Override
    public RespResult deleteArticleByArticleId(String articleId) {
        if (StringUtils.isBlank(articleId)) {
            return new RespResult(ResultCode.PARAM_IS_BLANK, "Id cannot be empty");
        } else if (!articleDao.findById(articleId).isPresent()) {
            return new RespResult(ResultCode.RESULT_DATA_NONE, "Id not exist");
        }
        articleDao.deleteById(articleId);
        if (articleTagDao.findByArticleId(articleId).size() > 0) {
            articleTagDao.deleteAllTagByArticleId(articleId);
        }
        return new RespResult(ResultCode.SUCCESS);
    }

    @Override
    public RespResult showSingleArticle(ArticleRequest req) {
        if (StringUtils.isBlank(req.getId())) {
            return new RespResult(ResultCode.PARAM_IS_BLANK, "Id cannot be empty");
        }

        Optional<Article> optionalArticle = articleDao.findById(req.getId());
        if (optionalArticle.isPresent()) {
            ArticleResp articleResp = new ArticleResp();
            Article article = optionalArticle.get();
            BeanUtils.copyProperties(article, articleResp);
            articleResp.setArticleTagList(articleTagDao.findTagNameByArticleId(req.getId()));
            return new RespResult(ResultCode.SUCCESS, articleResp);
        } else {
            return new RespResult(ResultCode.RESULT_DATA_NONE);
        }
    }

    @Override
    public List<Article> getRecentPublishedArticles() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "publishTime"));
        List<Article> articles = new ArrayList<>();
        articleDao.findAll(pageable).forEach(articles::add);
        return articles;
    }

    @Override
    protected JpaRepository getRepository() {
        return articleDao;
    }
}
