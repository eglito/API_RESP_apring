package com.devsuperior.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.userdept.entities.User;
import com.devsuperior.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users") // Indica que o caminho utilizado terá /users
public class UserController {
	
	@Autowired
	private UserRepository repository ;
	
	@GetMapping // Congura o método para realizar as consutas necessárias no banco SQL > faz o join nas tabelas, transforma em objeto java e, por fim, faz a serialização para json
	public List<User> findAll(){ //Busca todos os usuários no banco de dados
		List<User> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}") // além do /users a busca também ocorrerá em /{id}
	public User findById(@PathVariable Long id) {
		User result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping //Anotação indica que o método introduz 
	public User insert(@RequestBody User user) {
		User result = repository.save(user);
		return result;
	}

}























