package com.wombats.library.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class ResponseException {

  private LocalDateTime timestamp;
  private String details;
  private Integer code;
  private String status;

}
