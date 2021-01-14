package com.wombats.library.repository;

import com.wombats.library.entity.BookEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<BookEntity, String> {

  BookEntity findByTitle(String title);

  void deleteByTitle(String title);

}
