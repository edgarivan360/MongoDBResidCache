package com.wombats.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorExceptionResolver {

  private ResponseException responseException;

  @ExceptionHandler(NoDataFoundException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  public ResponseEntity<ResponseException> resolveNoDataFoundException(
      NoDataFoundException exception) {
    responseException = new ResponseException();
    responseException.setTimestamp(LocalDateTime.now());
    responseException.setDetails("[Response exception] - Exception: " + exception.getMessage());
    responseException.setCode(HttpStatus.FORBIDDEN.value());
    responseException.setStatus(ErrorType.ERROR.toString());
    return new ResponseEntity<>(responseException, HttpStatus.FORBIDDEN);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<ResponseException> resolveMethodArgumentNotValidException(
      MethodArgumentNotValidException exception) {

    /*
     * responseException = new ResponseException(); Map<String, List<String>> groupedErrors = new
     * HashMap<>();
     * 
     * List<FieldError> fieldErrors = exception.getFieldErrors(); List<String> fields = new
     * ArrayList<>();
     * 
     * for (FieldError fieldError : fieldErrors) { String message = fieldError.getDefaultMessage();
     * String field = fieldError.getField(); groupedErrors.computeIfAbsent(message, key ->
     * Collections.singletonList(field)); fields.add(field); }
     * 
     * if (!groupedErrors.isEmpty()) {
     * responseException.setDetails("[Response exception] - Exception: " +
     * groupedErrors.toString()); }
     */

    String messageError = exception.getFieldErrors().stream().map(FieldError::getDefaultMessage)
        .collect(Collectors.joining(". "));

    responseException = new ResponseException();
    responseException.setTimestamp(LocalDateTime.now());
    responseException.setDetails("[Response exception] - Exception: " + messageError);
    responseException.setCode(HttpStatus.BAD_REQUEST.value());
    responseException.setStatus(ErrorType.ERROR.toString());
    return new ResponseEntity<>(responseException, HttpStatus.BAD_REQUEST);
  }

}
