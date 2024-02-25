package com.example.QueryDSLtest;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.QueryDSLtest.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class QueryDslTestService {

	private final ArticleRepository articleRepository;

	public List<Article> searchArticles(String keyword) {
		return articleRepository.searchArticles(keyword);
	}
}
