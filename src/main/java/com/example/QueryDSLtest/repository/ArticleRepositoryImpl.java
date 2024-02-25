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

	// JPQL vs QueryDSL : https://www.inflearn.com/questions/38771/querydsl%EA%B3%BC-jpql%EC%9D%84-%EC%84%A0%ED%83%9D%ED%95%98%EB%8A%94-%EC%B0%A8%EC%9D%B4%EA%B0%80-%EA%B6%81%EA%B8%88%ED%95%A9%EB%8B%88%EB%8B%A4
	// repository 추상화 정도 : https://www.inflearn.com/questions/31415/spring-jpa-repository
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
