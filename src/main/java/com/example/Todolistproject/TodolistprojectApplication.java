package com.example.Todolistproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.Todolistproject.model.Todo;
import com.example.Todolistproject.model.TodoRepository;

@SpringBootApplication
public class TodolistprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistprojectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(TodoRepository repository) {
		return (args) -> {
			Todo t1 = new Todo("Laundry", "9.4.2021", "high");
			Todo t2 = new Todo("Dishes", "9.4.2021", "high");
			Todo t3 = new Todo("Walking the dog", "9.4.2021", "high");
			
			repository.save(t1);
			repository.save(t2);
			repository.save(t3);
		};
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
	UserDetails user = User.withDefaultPasswordEncoder()
	.username("user")
	.password("password")
	.roles("USER")
	.build();
	List<UserDetails> users = new ArrayList();
	users.add(user);
	return new InMemoryUserDetailsManager(users);
	}
}
