package com.wombats.library.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseException {

  private LocalDateTime timestamp;
  private String details;
  private Integer code;
  private String status;

}
