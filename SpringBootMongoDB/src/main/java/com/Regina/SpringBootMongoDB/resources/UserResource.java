package com.Regina.SpringBootMongoDB.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Regina.SpringBootMongoDB.domain.User;
import com.Regina.SpringBootMongoDB.dto.UserDTO;
import com.Regina.SpringBootMongoDB.services.UserService;

@RestController
@RequestMapping(value ="/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = userService.findAll();
		/**
		 * No controller vamos retornar uma DTO, para isso:
		 * 1 º - criamos a lista para guardar os objetos DTO
		 * 2 º - Vamos converter a lista de Users original para uma DTO, para isso vamos usar uma expressão lambda
		 * 3 º - list.stream() para transformar a lista numa stream (coleção compativel com as expressões lambda)
		 * 4 º - list.stram().map(x -> new UserDTO(x) o map vai pegar cada elemento da lista de User (x) e transformar no tipo UserDTO
		 * 5 º - collect(Collectors.toList()) -> Por fim volto a tranformar a stream numa lista
		 */	
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById( @PathVariable String id){
		User user = userService.findById(id);
		return ResponseEntity.ok().body(new UserDTO(user));
	}

}
