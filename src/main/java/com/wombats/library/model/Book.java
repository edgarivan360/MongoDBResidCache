package com.wombats.library.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.env.Environment;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class Book {

  private String id;

  @NotEmpty(message = "El título no puede ser nulo")
  private String title;

  @NotEmpty(message = "El autor no puede ser nulo")
  private String author;

  @NotEmpty(message = "La descripción no puede ser nula")
  private String description;

}
