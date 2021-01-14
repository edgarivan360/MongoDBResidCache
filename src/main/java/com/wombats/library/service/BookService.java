package com.wombats.library.service;

import com.wombats.library.constants.ApiValues;
import com.wombats.library.entity.BookEntity;
import com.wombats.library.exception.NoDataFoundException;
import com.wombats.library.model.Book;
import com.wombats.library.repository.BookRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

  private final ApiValues apiValues;
  private final BookRepository bookRepository;

  public List<Book> findAllBooks() {
    return bookRepository.findAll().stream()
        .map(bookEntity -> Book.builder().id(bookEntity.getId()).title(bookEntity.getTitle())
            .author(bookEntity.getAuthor()).description(bookEntity.getDescription()).build())
        .collect(Collectors.toList());
  }

  public Book findBookByTitle(String title) {
    BookEntity bookEntity = Optional.ofNullable(bookRepository.findByTitle(title)).orElseThrow(
        () -> new NoDataFoundException(String.format(apiValues.getNoBookFoundMessage(), title)));

    return Book.builder().id(bookEntity.getId()).title(bookEntity.getTitle())
        .author(bookEntity.getAuthor()).description(bookEntity.getDescription()).build();
  }

  public void saveBook(Book book) {
    BookEntity bookEntity = BookEntity.builder().title(book.getTitle()).author(book.getAuthor())
        .description(book.getDescription()).build();
    bookRepository.save(bookEntity);
  }

}
