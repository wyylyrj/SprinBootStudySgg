package com.yrj.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "yrj",type = "book")
public class Book {
    private Integer id;
    private String bookName;
    private String author;
}
