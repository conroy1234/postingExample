package com.posting.postingExample.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.posting.postingExample.exception.UserNatFoundException;
import com.posting.postingExample.model.User;
import com.posting.postingExample.service.UserService;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import static org.springframework.hateoas.Resource.*;
@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@GetMapping(path="/api/user")
	public List<User> getAllUsers() {
		
		return userService.findAll();
		
	}
	
	@GetMapping(path="/api/user/{id}")
	public User findOne(@PathVariable int id) {
		User entity =userService.findById(id);
		if(entity==null) {
			throw new UserNatFoundException("id="+id);
		}
		return entity;
	}
	
	
	@GetMapping(path="/api/user/-hateoas/{id}")
	public Resource<User> findOneHateoas(@PathVariable int id) {
		User entity =userService.findById(id);
		
		Resource<User> resource = new Resource<User>(entity);
		ControllerLinkBuilder builder =linkTo(methodOn(this.getClass()).getAllUsers());
		
		if(entity==null) {
			throw new UserNatFoundException("id="+id);
		}
		
		
		resource.add(builder.withRel("all-links"));
		
		return resource;
	}
	
	@GetMapping(path = "/users-todos/{id}")
	
	public Resource<User> retrieveTodo(@PathVariable int id) {
		User todo = userService.findById(id);
		if (todo == null) {
			throw new UserNatFoundException("id="+id);
		}

		Resource<User> todoResource = new Resource<User>(todo);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
		todoResource.add(linkTo.withRel("parent"));
		return todoResource;
	}
	
	@DeleteMapping(path="/api/user/{id}")
	public User deleteOne(@PathVariable int id) {
		User entity =userService.deleteById(id);
		if(entity==null) {
			throw new UserNatFoundException("id="+id);
		}
		return entity;
	}
	
	@PostMapping(path="/api/user")
	public ResponseEntity createUser(@Valid @RequestBody User user) {
		User entity =userService.createUser(user);		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(entity.getId()).toUri();
		System.out.println(location);
		return ResponseEntity.created(location).build();
		
	}

}
