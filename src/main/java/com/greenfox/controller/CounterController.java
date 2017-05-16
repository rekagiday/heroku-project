package com.greenfox.controller;

import com.greenfox.model.Counter;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan
public class CounterController {

  @Autowired
  Counter counter;

  AtomicLong atomicLong = new AtomicLong(1);

  @RequestMapping(value = "/counter")
  @ResponseBody
  public Counter greeting() {
    return new Counter(atomicLong.getAndIncrement());
  }
}
