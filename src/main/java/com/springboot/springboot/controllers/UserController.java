package com.springboot.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springboot.model.User;
import com.springboot.springboot.repository.UserRepository;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {
	
	// Injeção de dependencia
	@Autowired
	private UserRepository userRepository;
	
	/// Buscando o usuario pelo ID
	@GetMapping("/{id}") 	// http://localhost:8080/users/
	public User user(@PathVariable("id") Long id) {
		
		Optional<User> userFind = this.userRepository.findById(id);
		
		if(userFind.isPresent()) {
			return userFind.get();
		}
		return null;
	}
	
	// Cadastra usuario no banco
	@PostMapping("/")
	public User user(@RequestBody User user) {
		this.userRepository.save(user);
		return user;
	}
	
	
	// Listagem dos usuarios cadastrados
	@GetMapping("/list")
	public List<User> userList(){
		return this.userRepository.findAll();
	}
	
	// Busca dos usuarios pelo id (listagem)
		@GetMapping("/list/{id}")
		public List<User> userListMoreThan(@PathVariable("id") Long id){
			return this.userRepository.findAllMoreThan(id);
		}
		
	// Busca dos usuarios pelo nome (listagem)
		@GetMapping("/findByName/{name}")
		public List<User> userListByName(@PathVariable("name") String name){
			return this.userRepository.findByNameIgnoreCase(name);
		}
	
	
	
	
	

}
