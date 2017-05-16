package com.greenfox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Counter {

  long id;

  public long getId() {
    return id;
  }
}
