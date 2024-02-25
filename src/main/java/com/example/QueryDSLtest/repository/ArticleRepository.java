package com.example.QueryDSLtest.repository;

import java.util.List;

import com.example.QueryDSLtest.Article;

public interface ArticleRepository {
	List<Article> searchArticles(String keyword);
}
