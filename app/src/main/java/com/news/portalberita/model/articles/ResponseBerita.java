package com.news.portalberita.model.articles;

import com.news.portalberita.base.BaseResponse;

import java.util.List;

public class ResponseBerita extends BaseResponse{
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
