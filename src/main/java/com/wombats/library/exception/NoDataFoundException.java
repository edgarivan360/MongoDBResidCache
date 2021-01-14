package com.wombats.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class NoDataFoundException extends RuntimeException {

  public NoDataFoundException() {}

  public NoDataFoundException(String message) {
    super(message);
  }

  public NoDataFoundException(Throwable throwable) {
    super(throwable);
  }

  public NoDataFoundException(String message, Throwable throwable) {
    super(message, throwable);
  }

}
