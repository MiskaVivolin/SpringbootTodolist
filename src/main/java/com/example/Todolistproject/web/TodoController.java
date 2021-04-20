package com.example.Todolistproject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Todolistproject.model.Todo;
import com.example.Todolistproject.model.TodoRepository;

@Controller
public class TodoController {
	
	@Autowired
	private TodoRepository repository;
	
	@RequestMapping(value="/Todolist", method = RequestMethod.GET)
	public String todoList(Model model) {
		model.addAttribute("todos", repository.findAll());
		return "todolist";
	}
	@RequestMapping(value="/todos", method = RequestMethod.GET)
	public @ResponseBody List<Todo> todoListRest() {
		return (List<Todo>)repository.findAll();
	}
	
	@RequestMapping(value="/todo/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Todo> findTodoRest(@PathVariable("id") Long todoId) {
		return repository.findById(todoId);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {	
        return "login";
	}
	@RequestMapping(value = "/add")
	public String addTodo(Model model) {
		model.addAttribute("todo", new Todo());
		return "addTodo";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Todo todo) {
		repository.save(todo);
		return "redirect:Todolist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteTodo(@PathVariable("id") Long todoId, Model model) {
		repository.deleteById(todoId);
		return "redirect:../Todolist";
	}
	@RequestMapping(value = "/edit/{id}")
	public String addTodo(@PathVariable("id") Long todoId, Model model) {
		model.addAttribute("todo", repository.findById(todoId));
		return "editTodo";
	}
}
