package com.example.Todolistproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.Todolistproject.model.Todo;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryid;
	private String name;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Todo> todos;
	
	public Category() {
	}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return categoryid;
	}

	public void setId(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Todo> getBooks() {
		return todos;
	}

	public void setBooks(List<Todo> books) {
		this.todos = books;
	}

	@Override
	public String toString() {
		return "id [id=" + categoryid + ", name=" + name + "]";
	}

}
