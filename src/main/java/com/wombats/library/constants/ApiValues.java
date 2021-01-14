package com.wombats.library.constants;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class ApiValues {

  @Value("${custom.error.messages.noBookFound}")
  private String noBookFoundMessage;

}
