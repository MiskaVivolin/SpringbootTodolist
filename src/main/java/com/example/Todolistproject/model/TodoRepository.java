package com.example.Todolistproject.model;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface TodoRepository extends CrudRepository<Todo, Long> {

	List<Todo> findByName(String name);
	List<Todo> findByDate(String date);
}
