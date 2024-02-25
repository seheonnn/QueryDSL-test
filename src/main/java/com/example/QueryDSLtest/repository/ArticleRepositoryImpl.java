package com.example.QueryDSLtest.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.QueryDSLtest.Article;
import com.example.QueryDSLtest.QArticle;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

	private final EntityManager entityManager;
	private final ArticleJpaRepository articleJpaRepository;

	@Override
	public List<Article> searchArticles(String keyword) {
		QArticle article = QArticle.article;

		JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
		return queryFactory.selectFrom(article)
			.where(article.title.contains(keyword))
			.leftJoin(article.user).fetchJoin()
			.fetch();
	}
}
