package com.example.demo.control;

import com.example.demo.common.utils.JwtTokenUtils;
import com.example.demo.rpcDomain.common.RespResult;
import com.example.demo.rpcDomain.req.ArticleRequest;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping(value = "/publish", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public RespResult publish(@RequestHeader(name = JwtTokenUtils.AUTH_HEADER_KEY) String headerValue,
                              @RequestBody ArticleRequest req) {
        String userId = JwtTokenUtils.getUserIdByAuthorHead(headerValue);
        return articleService.publishArticle(req, userId);
    }

    @RequestMapping(value = "/delete", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public RespResult delete(@RequestBody ArticleRequest req) {
        return articleService.deleteArticleByArticleId(req.getId());
    }

    @RequestMapping(value = "/update", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public RespResult update(@RequestHeader(name = JwtTokenUtils.AUTH_HEADER_KEY) String headerValue,
                             @RequestBody ArticleRequest req) {
        String userId = JwtTokenUtils.getUserIdByAuthorHead(headerValue);
        return articleService.updateArticleByAuthor(req, userId);
    }

    @RequestMapping(value = "/show/detail", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public RespResult show(@RequestBody ArticleRequest req) {
        return articleService.showSingleArticle(req);
    }
}
