package com.wombats.library.controller;

import com.wombats.library.model.Book;
import com.wombats.library.service.BookService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

  private final Logger log = Logger.getLogger(BookController.class.getName());

  private final BookService bookService;

  @GetMapping
  public ResponseEntity<List<Book>> findAllBooks() {
    return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
  }

  /*
   * @GetMapping("/{title}") public ResponseEntity<Book> findBookByTitle(@PathVariable("title")
   * String title) { try { return new ResponseEntity<>(bookService.findBookByTitle(title),
   * HttpStatus.OK); } catch (NoDataFoundException exception) { throw new
   * ResponseStatusException(HttpStatus.FORBIDDEN, exception.getMessage()); } }
   */
  /*
   * httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
   * httpServletResponse.sendError(HttpStatus.FORBIDDEN.value(), exception.getMessage());
   */
  @GetMapping("/{title}")
  public ResponseEntity<Book> findBookByTitle(@PathVariable("title") String title) {
    return new ResponseEntity<>(bookService.findBookByTitle(title), HttpStatus.OK);
  }

  /*
   * @PostMapping public void saveBook(@RequestBody @Valid Book book, BindingResult bindingResult) {
   * if (!bindingResult.getFieldErrors().isEmpty()) { String messageError =
   * bindingResult.getFieldErrors().stream()
   * .map(FieldError::getDefaultMessage).collect(Collectors.joining(". ")); throw new
   * ResponseStatusException(HttpStatus.BAD_REQUEST, messageError); } bookService.saveBook(book); }
   */
  @PostMapping
  public void saveBook(@RequestBody @Valid Book book) {
    bookService.saveBook(book);
  }

}
