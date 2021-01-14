package com.wombats.library.entity;

import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "book")
public class BookEntity {

  @Id
  private String id;

  @Indexed
  private String title;

  private String author;

  private String description;

}
