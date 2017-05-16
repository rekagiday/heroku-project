package com.greenfox.service;

import com.greenfox.model.Todo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TodoRepository extends CrudRepository<Todo, Long>{

  List<Todo> findByIsDoneFalse();

}
