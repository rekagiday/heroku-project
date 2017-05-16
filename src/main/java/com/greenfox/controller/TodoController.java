package com.greenfox.controller;

import com.greenfox.model.Todo;
import com.greenfox.service.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo")
public class TodoController {

  @Autowired
  private TodoRepository repository;

  @RequestMapping(value = {"/list", "/"})
  public String list(@RequestParam(value = "isActive", required = false) boolean isActive,
      Model model) {
    if (isActive) {
      model.addAttribute("todos", repository.findByIsDoneFalse());
    } else {
      model.addAttribute("todos", repository.findAll());
    }
    return "index";
  }

  @RequestMapping(value = "/add")
  public String add() {
    return "add";
  }

  @PostMapping(value = "/addtodo")
  public String addtodo(String title) {
    repository.save(new Todo(title));
    return "redirect:/todo/list";
  }
}

