package com.Library.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Library.restapi.entity.User;
import com.Library.restapi.repository.userrepository;

@RestController
public class userController {
	@Autowired
	userrepository repo;
    @GetMapping("/User")//uri
	public List<User> getAllusers()
{
		List<User> user=repo.findAll();
        return user;		
}
	@GetMapping("/User/{id}")
	public User getuser(@PathVariable int id) {
		User user=repo.findById(id).get();
		return user;
	}
	@PostMapping("/User/add" ) 	
	@ResponseStatus(code=HttpStatus.CREATED)
	public void CreateUser(@RequestBody User u) {
		repo.save(u);
	}
	@PutMapping("/User/update/{id}")
	public User updateuser(@PathVariable int id) {
		User u=repo.findById(id).get();
		u.setUname("Mah");
		u.setUpno("9874561230");
		repo.save(u);
		return u;
	}
	@DeleteMapping("/User/delete/{id}")
	public void remove(@PathVariable int id) {
		User uu=repo.findById(id).get();
	   repo.delete(uu);
	}
}
