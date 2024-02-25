package com.example.QueryDSLtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QueryDSLtest.Article;

public interface ArticleJpaRepository extends JpaRepository<Article, Long> {
}
