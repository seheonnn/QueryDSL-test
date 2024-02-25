package com.example.QueryDSLtest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/querydsl")
public class QueryDslTestController {

	private final QueryDslTestService queryDslTestService;

	@GetMapping("")
	public List<Article> searchArticles(@RequestParam(name = "keyword") String keyword) {
		return queryDslTestService.searchArticles(keyword);
	}
}
