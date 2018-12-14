package com.yrj.repository;

import com.yrj.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}
