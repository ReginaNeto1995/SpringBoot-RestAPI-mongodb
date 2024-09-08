package com.Regina.SpringBootMongoDB.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Regina.SpringBootMongoDB.domain.User;
import com.Regina.SpringBootMongoDB.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();

		User luis = new User(null, "Luís Fernandes", "luís@gmail.com");
		User carina = new User(null, "Carina Dia", "carina@gmail.com");
		User daniel = new User(null, "Daniel Sousa", "daniel@gmail.com");
		
		userRepository.saveAll(Arrays.asList(luis,carina,daniel));

	}

}
