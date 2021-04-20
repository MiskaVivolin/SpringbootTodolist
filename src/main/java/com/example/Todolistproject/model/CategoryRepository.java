package com.example.Todolistproject.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.Todolistproject.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name); 
}
